package com.yxnne.mybulter.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.yxnne.mybulter.R;
import com.yxnne.mybulter.entity.MyUser;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText mEtUserName,mEtAge,mEtDescription,mEtPassWord,
                        mEtComfrimPwd,mEtEmail;
    private RadioGroup mRadioGroup;
    private RadioButton mRadioMale,mRadioFemale;
    private Button mBtnRegister;

    //性别 true表示 男
    private boolean isMale = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        mEtUserName = (EditText) findViewById(R.id.et_username_reginster);
        mEtAge = (EditText) findViewById(R.id.et_age_reginster);
        mEtDescription = (EditText) findViewById(R.id.et_description_reginster);
        mEtPassWord = (EditText) findViewById(R.id.et_password_register);
        mEtComfrimPwd = (EditText) findViewById(R.id.et_confirmpwd_register);
        mEtEmail = (EditText) findViewById(R.id.et_email_register);

        mRadioGroup = (RadioGroup) findViewById(R.id.RadioGroup_reginster);
        mRadioMale = (RadioButton) findViewById(R.id.rb_boy_registerr);
        mRadioFemale = (RadioButton) findViewById(R.id.rb_girl_register);

        mBtnRegister = (Button) findViewById(R.id.btn_registered_register);

        mBtnRegister.setOnClickListener(this);

    }

    /**
     * 点击事件的监听
     * @param v 控件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_registered_register:
                doRegister();
                break;
        }
    }

    /**
     * 注册的逻辑
     * 先检查参数
     * 再注册
     */
    private void doRegister() {
        String username = mEtUserName.getText().toString().trim();
        String age = mEtAge.getText().toString().trim();
        String description = mEtDescription.getText().toString().trim();
        String password = mEtPassWord.getText().toString().trim();
        String confirmPwd = mEtComfrimPwd.getText().toString().trim();
        String email = mEtEmail.getText().toString().trim();

        //检查参数
        if(!TextUtils.isEmpty(username) & !TextUtils.isEmpty(age) &
                !TextUtils.isEmpty(password) &
                !TextUtils.isEmpty(confirmPwd) &
                !TextUtils.isEmpty(email)){//该填上的都填上
            //两次密码是否一致
            if(password.equals(confirmPwd)){//一致
                //得到性别
                mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if(checkedId == R.id.rb_boy_registerr){
                            isMale = true;
                        }else {
                            isMale = false;
                        }
                    }
                });

                //判断简介是否是空
                if(TextUtils.isEmpty(description)){
                    description = getString(R.string.empty_description);
                }

                //准备条件已经完成,注册
                MyUser user = new MyUser();
                user.setUsername(username);
                user.setAge(Integer.parseInt(age));
                user.setDesc(description);
                user.setSex(isMale);
                user.setEmail(email);
                user.setPassword(password);

                user.signUp(new SaveListener<MyUser>() {
                    @Override
                    public void done(MyUser myUser, BmobException e) {
                        if(e==null){
                            Toast.makeText(RegisterActivity.this, R.string.text_registere_successful, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(RegisterActivity.this, getString(R.string.text_registere_failure) + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }else{
                Toast.makeText(this,"密码确认不一致",Toast.LENGTH_SHORT).show();
            }

        }else{
            //有必填的没有填，弹窗
            Toast.makeText(this,"有必填项未填",Toast.LENGTH_SHORT).show();
        }
    }
}
