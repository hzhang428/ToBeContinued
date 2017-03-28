package com.example.haozhang.tobecontinued.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by haozhang on 3/27/17.
 */

public class ToDo implements Parcelable {

    public String text;

    public Date remindDate;

    public ToDo(String text, Date remindDate) {
        this.text = text;
        this.remindDate = remindDate;
    }

    protected ToDo(Parcel in) {
        text = in.readString();
        remindDate = new Date(in.readLong());
    }

    public static final Creator<ToDo> CREATOR = new Creator<ToDo>() {
        @Override
        public ToDo createFromParcel(Parcel in) {
            return new ToDo(in);
        }

        @Override
        public ToDo[] newArray(int size) {
            return new ToDo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
        parcel.writeLong(remindDate.getTime());
    }
}
