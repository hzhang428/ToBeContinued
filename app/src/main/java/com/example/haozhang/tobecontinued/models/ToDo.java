package com.example.haozhang.tobecontinued.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.UUID;

/**
 * Created by haozhang on 3/27/17.
 */

public class ToDo implements Parcelable {

    public String id;

    public String text;

    public boolean done;

    public Date remindDate;

    public ToDo(String text, Date remindDate) {
        this.id = UUID.randomUUID().toString();
        this.text = text;
        this.done = false;
        this.remindDate = remindDate;
    }

    protected ToDo(Parcel in) {
        id = in.readString();
        text = in.readString();
        done = in.readByte() != 0;
        long date = in.readLong();
        remindDate = date == 0 ? null : new Date(date);

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
        parcel.writeString(id);
        parcel.writeString(text);
        parcel.writeByte((byte) (done ? 1 : 0));
        parcel.writeLong(remindDate != null ? remindDate.getTime() : 0);
    }
}
