package com.example.haozhang.tobecontinued;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

/**
 * Created by haozhang on 3/28/17.
 */

public abstract class BaseEditActivity<T> extends AppCompatActivity {

    private T data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setElevation(0);
        data = initializeData();
        if (data == null) {
            setupUIforCreate();
        } else {
            setupUIforEdit(data);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Log.i("Click", "back btn clicked");
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected abstract void setupUIforCreate();

    protected abstract void setupUIforEdit(@NonNull T data);

    protected abstract int getLayoutId();

    protected abstract void saveAndExit(@NonNull T data);

    protected abstract T initializeData();
}
