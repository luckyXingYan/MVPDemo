package com.example.mvpdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

import com.example.mvpdemo.R;
import com.example.mvpdemo.base.BaseScrollTitleBarActivity;
import com.example.mvpdemo.base.mvp.BasePresenter;

/**
 * TextInputEditText往往和 TextInputLayout 一起使用，两者结合可以优雅的实现多个输入框的联级校验
 * TextInputLayout 继承自 LinearLayout
 */
public class TextInputActivity extends BaseScrollTitleBarActivity<BasePresenter> {

    private Button submit;
    private TextInputEditText etPhone, etPwd;
    private TextInputLayout textInputLayoutPwd;

    public static void open(Context context) {
        context.startActivity(new Intent(context, TextInputActivity.class));
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_text_input;
    }

    @Override
    protected void initContentView() {

        submit = getView(R.id.btn_submit);
        etPhone = getView(R.id.et_phone);
        etPwd = getView(R.id.et_password);
        textInputLayoutPwd = getView(R.id.textInputLayout_password);
        textInputLayoutPwd.setPasswordVisibilityToggleDrawable(R.drawable.selector_toggle_btn_bg);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = etPhone.getText().toString().trim();
                String pwd = etPwd.getText().toString().trim();

                if (TextUtils.isEmpty(phone)) {
                    etPhone.setError("手机号不能为空");//设置 textInputEditText 的 error 信息
                    return;
                }
                if (TextUtils.isEmpty(pwd)) {
                    textInputLayoutPwd.setErrorEnabled(true);//设置是否一直显示着错误提示
                    textInputLayoutPwd.setError("手机号不能为空");//设置 textInputLayout 的 error 信息
                    return;
                }
            }
        });

        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(s)) {
                    textInputLayoutPwd.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }
}
