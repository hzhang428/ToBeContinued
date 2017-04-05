package com.example.haozhang.tobecontinued;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.haozhang.tobecontinued.models.ToDo;
import com.example.haozhang.tobecontinued.utils.UIUtils;

import java.util.List;

/**
 * Created by haozhang on 3/27/17.
 *
 */

public class ToDoListAdapter extends BaseAdapter{

    private MainActivity activity;
    private List<ToDo> data;

    public ToDoListAdapter(MainActivity activity, List<ToDo> data) {
        this.activity = activity;
        this.data = data;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = activity.getLayoutInflater().inflate(R.layout.main_list_item, parent, false);

            vh = new ViewHolder();
            vh.todoText = (TextView) convertView.findViewById(R.id.main_list_item_text);
            vh.checkBox = (CheckBox) convertView.findViewById(R.id.main_list_item_check);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        final ToDo todo = (ToDo) getItem(position);
        vh.todoText.setText(todo.text);
        vh.checkBox.setChecked(todo.done);
        UIUtils.setTextViewStrikeLine(vh.todoText, todo.done);
        vh.todoText.setTextColor(vh.checkBox.isChecked() ? Color.LTGRAY : Color.GRAY);

        vh.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                activity.updateToDo(position, isChecked);
            }
        });

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ToDoEditActivity.class);
                intent.putExtra(ToDoEditActivity.KEY_TODO, todo);
                activity.startActivityForResult(intent, MainActivity.REQ_CODE_TODO_EDIT);
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView todoText;
        CheckBox checkBox;
    }
}
