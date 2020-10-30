package com.example.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import com.example.healthfood.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Adapter.HomeVpAdapter;

public class Home_fragment extends Fragment {

    private ViewPager viewPager;    // 轮播图组件
    private GridView gridView;
    private List lst;
    private String[] nameLstView = {"新品驾到", "食趣", "食品安全", "产品溯源", "健康养生", "产品展示"};
    private int[] imageLstView = {R.mipmap.no1, R.mipmap.no2, R.mipmap.no3, R.mipmap.no4, R.mipmap.no5, R.mipmap.no6};
    private List<ImageView> lstVP = new ArrayList<ImageView>();                                 // 定义 List，用于存放 ImageView
    private int[] imageVP = {R.drawable.guanggao1, R.drawable.guanggao2, R.drawable.guanggao3}; // 此数组存放轮播图片
    TextView tvRadio;               // 用于显示指示器小圆点
    LinearLayout llViewpagerDon;     // 此线性布局用于动态加载指示器小圆点
    // 定义此 List，用于存放 3 个指示器小圆点
    private List<TextView> tvLst = new ArrayList<TextView>();
    // 用于设定动态加载的小圆点指示器在布局中的位置
    private LinearLayout.LayoutParams layoutParams;
    Thread thread;                  // 定义一个子线程，用于耗时处理
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            // 在当前页面位置加 1
            switch (msg.what) {
                case 1:
                    // 利用取模运算方法（模为3）实现动态切换 ViewPager 图片的功能
                    viewPager.setCurrentItem((viewPager.getCurrentItem() + 1) % 3);
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // 利用布局加载器加载“个人中心”布局，将其转换为 View
        View view = inflater.inflate(R.layout.frag_home, null); // 利用布局加载器加载“个人中心”布局，将其转换为 View
        initViewPager(view);
        initGridView(view);
        return view;        // 返回 View
    }

    public void initViewPager(View view) {
        viewPager = view.findViewById(R.id.home_viewpager);
        llViewpagerDon = view.findViewById(R.id.home_viewpager_dot);
        layoutParams = new LinearLayout.LayoutParams(20, 20);
        layoutParams.setMargins(0, 0, 10, 0);   // 设置 LayoutParams 的 Margins 值
        for (int i = 0; i < imageVP.length; i++) {
            ImageView image = new ImageView(getActivity());
            image.setImageResource(imageVP[i]);
            image.setAdjustViewBounds(true);
            image.setScaleType(ImageView.ScaleType.FIT_XY);
            lstVP.add(image);

            tvRadio = new TextView(getActivity());
            tvRadio.setBackgroundResource(R.drawable.tv_dot_selector);
            llViewpagerDon.addView(tvRadio, layoutParams);
            tvLst.add(tvRadio);
        }

        viewPager.setAdapter(new HomeVpAdapter(lstVP));
        viewPager.setCurrentItem(0);
        tvLst.get(0).setSelected(true);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < tvLst.size(); i++) {
                    tvLst.get(i).setSelected(position % lstVP.size() == i);

//                    if (i == position % lstVP.size())
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void onResume() {
        myThread();
        super.onResume();
    }

    @Override
    public void onStop() {
        thread.interrupt();     // 结束当前 Fragment 时中断耗时的子线程
        super.onStop();
    }

    private void myThread() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stud
                while (!Thread.interrupted()) {
                    try {
                        Thread.sleep(5000);
                        handler.sendEmptyMessage(1);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated method stud
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    private void initGridView(View view) {
        gridView = view.findViewById(R.id.home_gridView1);

        lst = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 6; i++) {
            HashMap<String, Object> hmap = new HashMap<>();
            hmap.put("name", nameLstView[i]);
            hmap.put("icon", imageLstView[i]);
            lst.add(hmap);
        }

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), lst, R.layout.buju_home_gridview, new String[]{"name", "icon"}, new int[]{R.id.buju_home_gridview_icon});
        //TODO
    }
}
