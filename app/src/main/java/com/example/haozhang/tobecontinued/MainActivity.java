package com.example.haozhang.tobecontinued;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.example.haozhang.tobecontinued.models.ToDo;
import com.example.haozhang.tobecontinued.utils.ModelUtils;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQ_CODE_TODO_EDIT = 100;

    private static final String MODEL_TODO = "todo_items";

    private List<ToDo> toDos;
    private ToDoListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ToDoEditActivity.class);
                startActivityForResult(intent, REQ_CODE_TODO_EDIT);
            }
        });

        loadData();

        adapter = new ToDoListAdapter(this, toDos);
        ((ListView) findViewById(R.id.main_list_view)).setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == REQ_CODE_TODO_EDIT) {
            ToDo todo = data.getParcelableExtra(ToDoEditActivity.KEY_TODO);
            Log.i("todo_debug", (todo == null) + " after save");
            updateToDo(todo);
        }
    }

    private void updateToDo(ToDo todo) {
        boolean found = false;
        for (int i = 0; i < toDos.size(); i++) {
            if (TextUtils.equals(todo.id, toDos.get(i).id)) {
                toDos.set(i, todo);
                found = true;
                break;
            }
        }
        if (!found) {
            toDos.add(todo);
        }
        adapter.notifyDataSetChanged();
        ModelUtils.save(this, MODEL_TODO, toDos);
    }

    public void updateToDo(int index, boolean done) {
        toDos.get(index).done = done;

        adapter.notifyDataSetChanged();
        ModelUtils.save(this, MODEL_TODO, toDos);
    }

    private void loadData() {
        toDos = ModelUtils.read(this, MODEL_TODO, new TypeToken<List<ToDo>>(){});
        if (toDos == null) {
            Log.i("toDosxxxx", (toDos == null) + "");
            toDos = new ArrayList<>();
        }
    }
}
