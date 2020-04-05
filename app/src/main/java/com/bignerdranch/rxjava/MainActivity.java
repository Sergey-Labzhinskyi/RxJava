 package com.bignerdranch.rxjava;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static io.reactivex.Observable.combineLatest;
import static io.reactivex.Observable.interval;
import static io.reactivex.Observable.just;


 public class MainActivity extends AppCompatActivity {

     private String TAG = "RxTest";
     private Subscription mSubscription;
     private Button mButton;
     private Button startDialog;
     List list3 = new ArrayList();
     private AdView mAdView;


     @Override
     protected void onDestroy() {
         super.onDestroy();
     }

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

       //  createObserveble();
         mButton = (Button) findViewById(R.id.first);
startDialog = (Button) findViewById(R.id.btn_startDialog);



startDialog.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        FragmentManager manager = getSupportFragmentManager();
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(manager, "myDialog");



    }
});



        /* List list1 = new ArrayList();
         list1.add(25);
         list1.add(28);
         list1.add(30);


         List list3 = new ArrayList();

         for (int i = 0; i < list1.size(); i++) {
             list3.add(list1.get(i));
             Log.d("list", String.valueOf(list3.size()));
             Log.d("list", String.valueOf(list3.get(i)));
             }

             //Log.d("list", String.valueOf(list3.size()));*/

       // fgdfg();
       // fgdfg();
         //print1();


         MobileAds.initialize(this, initializationStatus -> {
         });


         mAdView = findViewById(R.id.adBetweenNews);
         AdRequest adRequest = new AdRequest.Builder().build();
         mAdView.loadAd(adRequest);


     }


     private void createBanner() {
         Log.d(TAG, "createBanner()");


     }

         public  void fgdfg(){
             List list1 = new ArrayList();
             list1.add(25);
             list1.add(28);
             list1.add(30);




             for (int i = 0; i < list1.size(); i++) {
                 list3.add(list1.get(i));
                 Log.d("list", String.valueOf(list3.size()));
                 Log.d("list", String.valueOf(list3.get(i)));
             }
         }



        /* Observable<Integer> observable = upData();
         Observer<Integer> observer = new Observer<Integer>() {
             @Override
             public void onSubscribe(Disposable d) {

             }

             @Override
             public void onNext(Integer i) {
                 //  Toast.makeText(MainActivity.this, i, Toast.LENGTH_LONG).show();
                 Log.e(TAG, "onNext: " + i);
             }

             @Override
             public void onError(Throwable e) {
                 Log.e(TAG, "onError: " + e);
             }

             @Override
             public void onComplete() {
                 Log.e(TAG, "onComplete: ");
             }
         };
         observable.subscribe(observer);

*/


 /*    public Observable<Integer> upData() {
         int d = 0;
         Observable<Integer> observable = Observable.create(
         for (int i = 0; i < 10000; i++) {
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             d = i;

         }
        );

         for (int i = 0; i < 10000; i++) {
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             d = i;

         }
         observable = Observable.c;
         return observable;
     }
*/
     public void createObserveble() {
         Observable<Integer> mObservable = just(1, 2, 3 ,4);
         /*  Observable<Integer> mObservable = Observable.fromCallable(new Callable<Integer>() {
           @Override
             public Integer call() throws Exception {
                 int a = 0;
                 for (int i = 0; i < 1000000; i++) {
                    Thread.sleep(1000);
                      a = i;

                 }
                 return a;
             }
         });*/
         mObservable
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Observer<Integer>() {

                             @Override
                             public void onSubscribe(Disposable d) {
                                 Log.d(TAG, "onSubscribe");
                             }

                             @Override
                             public void onNext(Integer integer) {
                                mButton.setText(Integer.toString(integer));
                                 Log.d(TAG, integer.toString());
                                 Log.d(TAG, "onNext");

                             }

                             @Override
                             public void onError(Throwable e) {
                                 Log.d(TAG, "onError");
                             }

                             @Override
                             public void onComplete() {
                                 Log.e(TAG, "onComplete");
                             }


                         });
     }

     public void print(){
         Observable observable = Observable.just(10L, 7L, 1L);

         observable.flatMap(x -> just(x).delay((Long) x, TimeUnit.SECONDS)).subscribe(System.out::println);
     }

     public void print1(){
         Observable.combineLatest(interval(17, TimeUnit.MILLISECONDS).map(x -> "S" + x),
                 interval(10, TimeUnit.MILLISECONDS).map(x -> "F" + x),
         (s, f) -> f + ":" + s).forEach (System.out::println);

     }
 }


