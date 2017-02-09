package com.yxnne.mybulter.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yxnne.mybulter.R;

/**
 * Class Full Name  : com.yxnne.mybulter.fragment.ButlerFragment
 * Author Name      : yxnne
 * Create Time      : 2017/2/7
 * Project Name     : MyBulter
 * Descriptions     : 个人服务
 */
public class UserFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user,null);
        return view;
    }
}
