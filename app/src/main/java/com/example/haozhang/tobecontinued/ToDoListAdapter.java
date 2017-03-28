package com.example.haozhang.tobecontinued;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.haozhang.tobecontinued.models.ToDo;

import java.util.List;

/**
 * Created by haozhang on 3/27/17.
 */

public class ToDoListAdapter extends BaseAdapter{

    private Context context;
    private List<ToDo> data;

    public ToDoListAdapter(@NonNull Context context, List<ToDo> data) {
        this.context = context;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.main_list_item, parent, false);
            vh = new ViewHolder();
            vh.todoText = (TextView) convertView.findViewById(R.id.main_list_item_text);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        ToDo todo = data.get(position);
        vh.todoText.setText(todo.text);
        return convertView;
    }

    private static class ViewHolder {
        TextView todoText;
    }
}
