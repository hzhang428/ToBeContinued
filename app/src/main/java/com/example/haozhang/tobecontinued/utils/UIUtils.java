package com.example.haozhang.tobecontinued.utils;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.widget.TextView;

/**
 * Created by haozhang on 4/4/17.
 * Set strike line for completed task
 */

public class UIUtils {

    public static void setTextViewStrikeLine(@NonNull TextView view, boolean strickThrough) {
        if (strickThrough) {
            view.setPaintFlags(view.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            view.setPaintFlags(view.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }
}
