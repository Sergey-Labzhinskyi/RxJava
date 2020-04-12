package com.bignerdranch.rxjava;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MyDialogFragment extends DialogFragment {


    private AdView mAdView;
    private Disposable disposable;
    Button time;
    TextView textView;

    @Override
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        return super.onCreateAnimation(transit, enter, nextAnim);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());







        builder.setTitle("Важное сообщение!");
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.test, null);
        builder.setView(view);


     /*   MobileAds.initialize(getActivity(), initializationStatus -> {
        });


        mAdView = view.findViewById(R.id.adBetweenNews);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
*/

time = view.findViewById(R.id.btn_skip_ad);
textView = view.findViewById(R.id.textView);


        return builder.create();

    }

    @SuppressLint("SetTextI18n")
    void timer() {
        disposable = Observable.interval(0, 1, TimeUnit.SECONDS)
                .take(6)
                .observeOn(AndroidSchedulers.mainThread())
             //   .map(it -> textView.setText(it.toString().charAt()))
                .subscribe();

    }

}


