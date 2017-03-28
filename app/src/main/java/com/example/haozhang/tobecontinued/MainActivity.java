package com.example.haozhang.tobecontinued;

import android.content.Intent;
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

    private static final int REQ_CODE_TODO_EDIT = 100;

    private List<ToDo> toDos;
    private ToDoListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI(fakeData());
    }

    private void setupUI(@NonNull List<ToDo> todos) {

        adapter = new ToDoListAdapter(this, todos);
        ((ListView) findViewById(R.id.main_list_view)).setAdapter(adapter);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ToDoEditActivity.class);
                startActivityForResult(intent, REQ_CODE_TODO_EDIT);
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
