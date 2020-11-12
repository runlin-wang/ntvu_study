package com.example.fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        View view = inflater.inflate(R.layout.frag_gourmet, null);
        initData();
        baseAdapter = new GourmetBaseAdapter(data, this.getActivity());
        listView = view.findViewById(R.id.gourmet_frag_listView);
        listView.setAdapter(baseAdapter);
        this.registerForContextMenu(view);
        return view;    // 返回 View
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0, 1, Menu.NONE, "微信分享");
        menu.add(0, 2, Menu.NONE, "收藏");
        menu.add(0, 3, Menu.NONE, "删除");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @SuppressLint("WrongConstant")
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        final AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(getActivity(), "晚一点帮你分享", 2000).show();
                break;
            case 2:
                Toast.makeText(getActivity(), "晚一点帮你收藏", 2000).show();
                break;
            case 3:
                // 实现删除功能
                data.remove(info.position);
                baseAdapter.notifyDataSetChanged();
                break;
        }
        return super.onContextItemSelected(item);
    }

    /**
     * “微信分享” 对话框
     */
    public void dialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("确认");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        dialog.setMessage("您确认要在微信分享");
        dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "取消微信分享", 2000).show();
            }
        });
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "微信分享成功", 2000).show();
            }
        });
        dialog.show();
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
