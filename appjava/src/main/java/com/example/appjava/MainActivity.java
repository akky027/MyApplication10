package com.example.appjava;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.appjava.fragment.ListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Log.d("TEST_TEST", "init");

        if(savedInstanceState == null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // BackStackを設定
            fragmentTransaction.addToBackStack(null);

            Log.d("TEST_TEST", "init2");

            // counterをパラメータとして設定
            int count = 0;
            fragmentTransaction.replace(R.id.container, ListFragment.newInstance(count));

            fragmentTransaction.commit();
        }
    }
}
