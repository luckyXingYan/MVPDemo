package com.example.mvpdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvpdemo.R;

public class FourActivity extends AppCompatActivity {
    public static void open(Context context) {
        context.startActivity(new Intent(context, FourActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
    }
}
