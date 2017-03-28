package com.example.haozhang.tobecontinued;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.haozhang.tobecontinued.models.ToDo;
import com.example.haozhang.tobecontinued.utils.DateUtil;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by haozhang on 3/28/17.
 */

public class ToDoEditActivity extends AppCompatActivity implements
        TimePickerDialog.OnTimeSetListener,
        DatePickerDialog.OnDateSetListener{

    public static final String KEY_TODO = "todo_item";

    private EditText todoText;
    private TextView dateTv;
    private TextView timeTv;
    private CheckBox completeCb;

    private ToDo data;
    private Date remindDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = getIntent().getParcelableExtra(KEY_TODO);
        if (data == null) {
            remindDate = null;
        } else {
            remindDate = data.remindDate;
        }
        setupUI();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupUI() {
        setContentView(R.layout.activity_todo_edit);
        setActionBar();

        todoText = (EditText) findViewById(R.id.todo_detail_edit_text);
        dateTv = (TextView) findViewById(R.id.todo_detail_datePick);
        timeTv = (TextView) findViewById(R.id.todo_detail_timePick);
        completeCb = (CheckBox) findViewById(R.id.todo_detail_checkBox);

        if (remindDate != null) {
            dateTv.setText(DateUtil.dateToString(remindDate));
            timeTv.setText(DateUtil.dateToString(remindDate));
        } else {
            dateTv.setText(R.string.set_date);
            timeTv.setText(R.string.set_time);
        }
        setDatePicker();
    }

    private void setActionBar() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Edit");
    }

    private void setDatePicker() {
        dateTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = getCalenderFromRemindDate();
                Dialog dialog = new DatePickerDialog(
                        ToDoEditActivity.this,
                        ToDoEditActivity.this,
                        c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH),
                        c.get(Calendar.DATE)
                );
                dialog.show();
            }
        });

        timeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = getCalenderFromRemindDate();
                Dialog dialog = new TimePickerDialog(
                        ToDoEditActivity.this,
                        ToDoEditActivity.this,
                        c.get(Calendar.HOUR_OF_DAY),
                        c.get(Calendar.MINUTE),
                        true
                );
                dialog.show();
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar c = getCalenderFromRemindDate();
        c.set(year, month, day);

        remindDate = c.getTime();
        dateTv.setText(DateUtil.dateToString(remindDate));
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = getCalenderFromRemindDate();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);

        remindDate = c.getTime();
        timeTv.setText(DateUtil.dateToString(remindDate));
    }

    private Calendar getCalenderFromRemindDate() {
        Calendar c = Calendar.getInstance();
        if (remindDate != null) {
            c.setTime(remindDate);
        }
        return c;
    }
}
