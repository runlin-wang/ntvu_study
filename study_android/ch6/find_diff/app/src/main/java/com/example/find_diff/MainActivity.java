package com.example.find_diff;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ImageView imageView;
    private List<View> views;
    private int imageLst[] = {R.drawable.diff1, R.drawable.diff2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitImageView();
        initViewPager();
    }

    private void InitImageView() {
        views = new ArrayList<>();
        for (int i = 0; i < imageLst.length; i++) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(imageLst[i]);
            views.add(image);
        }
    }

    private void initViewPager() {
        viewPager = this.findViewById(R.id.ViewPager);
        viewPager.setAdapter(new myAdapter());
    }

    private class myAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            // TODO Auto-generated method stud
            return view == object;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            // TODO Auto-generated method stud
            container.removeView(views.get(position));
        }

        @Override
        public int getItemPosition(@NonNull Object object) {
            // TODO Auto-generated method stud
            return super.getItemPosition(object);
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            container.addView(views.get(position));
            return views.get(position);
        }
    }
}
