package com.bignerdranch.rxjava;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.disposables.CompositeDisposable;

public class RxJavaSimpleActivity extends AppCompatActivity {

    RecyclerView colorListView;
    //SimpleStringAdapter simpleStringAdapter;
    CompositeDisposable disposable = new CompositeDisposable();
    public int value =0;
}
