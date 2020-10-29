package com.example.classic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] name = {"阿甘正传", "沉默的羔羊", "虎口脱险", "罗马假日", "午夜凶铃", "千与千寻", "人鬼情未了", "卧虎藏龙", "音乐之声"};
    private int[] image = {R.drawable.p1_agan, R.drawable.p2_gaoyang, R.drawable.p3_hukou, R.drawable.p4_luoma, R.drawable.p5_wuye, R.drawable.p6_qianxun, R.drawable.p7_rengui, R.drawable.p8_wohu, R.drawable.p9_yingyue};

    List imageLst;
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = this.findViewById(R.id.gridView1);
        imageLst = new ArrayList();
        for (int i : image) {
            HashMap hm = new HashMap();
            hm.put("name", name[i]);
            hm.put("image", image[i]);
            imageLst.add(hm);
        }

        SimpleAdapter adapter = new SimpleAdapter(this, imageLst, R.layout.itemview, new String[]{"image", "name"}, new int[]{R.id.imageView1, R.id.textView1});
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "你选择了：" + name[position], Toast.LENGTH_LONG).show();
            }
        });
    }
}
