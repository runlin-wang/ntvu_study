package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.healthfood.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Adapter.GourmetBaseAdapter;

public class GourmetFragment extends Fragment {

    private ListView listView;
    private int images[] = {
            R.drawable.p1_gourmet, R.drawable.p2_gourmet,
            R.drawable.p3_gourmet, R.drawable.p4_gourmet,
            R.drawable.p5_gourmet, R.drawable.p6_gourmet,
            R.drawable.p7_gourmet, R.drawable.p8_gourmet
    };
    private String[] comment = {"减肥干嘛 又不是吃不起", "这样的馒头，感觉能吃一筐", "给你一个爱上烘培的理由", "不是我瘦不下来 是敌人太强",
                                "一场咖啡与鲜花的比赛", "美食是灵魂伴侣", "吃货的幸福世界", "美得舍不得下咽"};
    private String[] date = {"2016 年 7 月", "2016 年 9 月", "2017 年 1 月", "2017 年 1 月",
                             "2017 年 10 月", "2018 年 5 月", "2018 年 9 月", "2018 年 10 月"};
    private String[] name = {"叶德娴", "刘芸", "徐自贤", "丁志诚", "梁文道", "张笛", "杨若兮", "王丽达"};
    private List<HashMap> data;
    GourmetBaseAdapter baseAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 利用布局加载器加载”吃货驾到“布局，将其转换为 View
        View view = inflater.inflate(R.layout.frag_home, null);
        initData();
        baseAdapter = new GourmetBaseAdapter(data, this.getActivity());
        listView = view.findViewById(R.id.gourmet_frag_listView);
        listView.setAdapter(baseAdapter);
        return view;    // 返回 View
    }

    private void initData() {
        data = new ArrayList<>();
        for (int i = 0; i < date.length; i++) {
            HashMap hm = new HashMap();
            hm.put("image", images[i]);
            hm.put("date", date[i]);
            hm.put("comment", comment[i]);
            hm.put("name", name[i]);
            data.add(hm);
        }
    }
}
