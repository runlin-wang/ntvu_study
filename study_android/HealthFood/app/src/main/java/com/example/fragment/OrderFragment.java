package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;

import com.example.healthfood.R;

import java.util.ArrayList;
import java.util.HashMap;

public class OrderFragment extends Fragment {

    private int images[] = {R.drawable.po1_hetao, R.drawable.po2_mi, R.drawable.po3_jidan,
                            R.drawable.po4_huasheng, R.drawable.po5_huajiao};
    private String[] price = {"￥50 元/公斤", "￥10 元/公斤", "￥25 元/公斤", "￥30 元/公斤", "￥100 元/公斤"};
    private String[] address = {"云南大理", "惠州惠东", "惠州农门", "河源和平", "四川汶川"};
    private String[] name = {"核桃", "大米", "鸡蛋", "花生", "花椒"};
    ArrayList data;
    ListView order;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        // 利用布局加载器加载 ”我的订单“ 布局，将其转换为 View
        View view = inflater.inflate(R.layout.frag_order, null);
        init(view);
        showOrder();
        return view;
    }

    public void init(View view) {
        order = view.findViewById(R.id.frag_order_orderList);
    }

    public void showOrder() {
        initDate();
        SimpleAdapter adapter = new SimpleAdapter(this.getActivity(), data, R.layout.buju_order_orderlist,
                new String[]{"image", "price", "address", "name"},
                new int[]{R.id.buju_gourment_pic, R.id.buju_orderList_price, R.id.buju_orderList_address, R.id.buju_orderList_name});
        order.setAdapter(adapter);
    }

    public void initDate() {
        data = new ArrayList();
        for (int i = 0; i < images.length; i++) {
            HashMap hm = new HashMap();
            hm.put("image", images[i]);
            hm.put("price", price[i]);
            hm.put("address", address[i]);
            hm.put("name", name[i]);
            data.add(hm);
        }
    }
}
