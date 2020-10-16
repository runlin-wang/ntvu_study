package com.example.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.healthfood.LoginActivity;
import com.example.healthfood.R;

@SuppressLint("ValidFragment")
public class PersonalCenter extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // 利用布局加载器加载“个人中心”布局，将其转换为 View
        View view = inflater.inflate(R.layout.frag_personalcenter, null);
        doLogin(view);    // 调用 jumplogin() 方法，实现“登录”界面的跳转
        return view;    // 返回 View
    }

    public void doLogin(View v) {
        TextView login = (TextView) v.findViewById(R.id.textView);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建显示 Intent，确认从当前跳转到“登录界面”
                Intent it = new Intent(getActivity(), LoginActivity.class);
                startActivity(it);  // 启动 Activity
            }
        });
    }

}
