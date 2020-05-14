package com.bignerdranch.rxjava;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.SearchEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BooksActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("", "");
        Log.d("", "");
        Log.d("", "");
    }

    @Override
    public boolean onSearchRequested(@Nullable SearchEvent searchEvent) {
        return super.onSearchRequested(searchEvent);
    }
}
