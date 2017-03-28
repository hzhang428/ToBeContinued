package com.example.haozhang.tobecontinued;

import android.support.annotation.NonNull;

import com.example.haozhang.tobecontinued.models.ToDo;

/**
 * Created by haozhang on 3/28/17.
 */

public class ToDoEditActivity extends BaseEditActivity<ToDo> {

    public static final String KEY_TODO = "todo_item";


    @Override
    protected void setupUIforCreate() {

    }

    @Override
    protected void setupUIforEdit(@NonNull ToDo data) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_todo_edit;
    }

    @Override
    protected void saveAndExit(@NonNull ToDo data) {

    }

    @Override
    protected ToDo initializeData() {
        return getIntent().getParcelableExtra(KEY_TODO);
    }
}
