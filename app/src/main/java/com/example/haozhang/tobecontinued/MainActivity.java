package com.example.haozhang.tobecontinued;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.haozhang.tobecontinued.models.ToDo;
import com.example.haozhang.tobecontinued.utils.DateUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ToDo> toDos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI(fakeData());
    }

    private void setupUI(@NonNull List<ToDo> todos) {

//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.crappy_List);
//        linearLayout.removeAllViews();
//
//        ToDoListAdapter toDoListAdapter = new ToDoListAdapter(this, todos);
//
//        for (int i = 0; i < todos.size(); i++) {
//            ListView listView = (ListView) findViewById(R.id.main_list_view);
//        }
        ListView listView = (ListView) findViewById(R.id.main_list_view);
        listView.setAdapter(new ToDoListAdapter(this, todos));

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(MainActivity.this, "Fab clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private List<ToDo> fakeData() {
        List<ToDo> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            list.add(new ToDo("Task" + i, DateUtil.stringToDate("2017 03 28 14:00")));
        }
        return list;
    }
}
