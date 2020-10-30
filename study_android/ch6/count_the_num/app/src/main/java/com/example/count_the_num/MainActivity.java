package com.example.count_the_num;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btnStart, btnEnd;
    private TextView tvCount;
    MyThread thread;
    private int count = 0;
    Handler handler = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                switch (msg.what) {
                    case 1 :
                        count++;
                        tvCount.setText(count + "");
                        break;
                }
            }
        };
        init();
    }

    public void init() {
        btnStart = findViewById(R.id.start);
        btnEnd = findViewById(R.id.end);
        tvCount = findViewById(R.id.count);
        btnStart.setOnClickListener(this);
        btnEnd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.start :
                thread = new MyThread();
                thread.start();
                Toast.makeText(this, "start", Toast.LENGTH_SHORT).show();
                break;
            case R.id.end :
                thread.interrupt();
                Toast.makeText(this, "end", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public class MyThread extends Thread {
        @Override
        public void run() {
            //TODO
            while (!Thread.interrupted()) {
                try {
                    Thread.sleep(1000);
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
