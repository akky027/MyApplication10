package com.example.appjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String data = intent.getStringExtra("ITEM_DATA");

        Log.d("TEST_TEST", data);

        TextView tv = (TextView)findViewById(R.id.tv_id);
        tv.setText(data);


    }
}
