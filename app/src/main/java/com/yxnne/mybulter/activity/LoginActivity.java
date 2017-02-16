package com.yxnne.mybulter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.yxnne.mybulter.R;

/**
 * 登录页面
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText mEtUserName,mEtPassWord;
    private Button mBtnLogin,mBtnRegister;
    private CheckBox mCbKeep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        mEtUserName = (EditText) findViewById(R.id.et_username_login);
        mEtPassWord = (EditText) findViewById(R.id.et_password_login);

        mBtnLogin = (Button) findViewById(R.id.btn_login_login);
        mBtnRegister = (Button) findViewById(R.id.btn_register_login);

        mCbKeep = (CheckBox) findViewById(R.id.cb_keep);

        mBtnLogin.setOnClickListener(this);
        mBtnRegister.setOnClickListener(this);

    }

    /**
     * 响应点击事件
     * @param v 控件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login_login://登录

                break;
            case R.id.btn_register_login://注册
                Intent intent = new Intent(this,RegisterActivity.class);
                startActivity(intent);
                break;
        }

    }
}
