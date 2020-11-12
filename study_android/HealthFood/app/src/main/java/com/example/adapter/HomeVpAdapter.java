package com.example.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class HomeVpAdapter extends PagerAdapter {

    List<ImageView> images;     // 存放轮播图片

    public HomeVpAdapter(List<ImageView> images) {
        this.images = images;
    }

    /**
     * @return ViewPager 切换的页面数
     */
    @Override
    public int getCount() {
        return images.size();
    }

    /**
     * 判断显示的 View 是否为当期 View
     * @param view 视图
     * @param object 对象
     * @return boolean
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    /**
     * 销毁视图
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(images.get(position));
        return images.get(position);
    }
}
