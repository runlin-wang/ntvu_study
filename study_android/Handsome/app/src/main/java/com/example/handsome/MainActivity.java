package com.example.handsome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rg; // 声明 RadioGroup 组件的变量 rg

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 将通过 ID 找到的单选按钮组赋值给 rg
        rg = (RadioGroup)this.findViewById(R.id.radioGroup1);
        // 添加单选按钮组的选择改变监听
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId 保存用户选中的单选按钮的 ID 。下面利用此变量进行比对，判断所选答案是否正确
                switch (checkedId) {
                    case R.id.sHai :
                        Toast.makeText(MainActivity.this, "答对了", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.gZhou :
                    case R.id.sZhen :
                    case R.id.xAn : // 如果 checkedId 的值是 xAn，则说明用户选择了“西安”单选按钮
                        Toast.makeText(MainActivity.this,  "答错了", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}
