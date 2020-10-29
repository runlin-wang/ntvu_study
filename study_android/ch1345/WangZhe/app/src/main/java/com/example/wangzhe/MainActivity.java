package com.example.wangzhe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgHqs, imgZshy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void FragmentChange(Fragment myFragment) {
        FragmentManager manager = this.getSupportFragmentManager();            // 获取 FragmentManager
        FragmentTransaction transaction = manager.beginTransaction();   // 开启一个碎片管理事务
        // TODO
        transaction.replace(R.id.fragment_container, myFragment);
        transaction.commit(); // 提交事务请求
    }

    private void init() {
        imgHqs = this.findViewById(R.id.imageView2);

        imgZshy = this.findViewById(R.id.imageView3);

        imgHqs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_hqs myFragment = new Fragment_hqs();
                FragmentChange(myFragment);
            }
        });

        imgZshy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment_zshy myFragment = new Fragment_zshy();
                FragmentChange(myFragment);
            }
        });
    }
}
