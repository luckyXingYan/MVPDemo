package com.example.mvpdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.mvp.BaseActivity;
import com.example.mvpdemo.base.mvp.BasePresenter;
import com.example.mvpdemo.base.mvp.IBaseView;

public class MainActivity extends BaseActivity<BasePresenter<IBaseView>> {

    private static final String TAG = "MainActivity";
    private Button btnMvp;


    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initLayoutView(Bundle savedInstanceState) {
        btnMvp = (Button) findViewById(R.id.btn_mvp);
        btnMvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.this.startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

    }


    @Override
    protected BasePresenter<IBaseView> createPresenter() {
        return null;
    }
}
