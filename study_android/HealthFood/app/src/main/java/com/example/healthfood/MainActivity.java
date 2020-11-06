package com.example.healthfood;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.fragment.GourmetFragment;
import com.example.fragment.HomeFragment;
import com.example.fragment.PersonalCenter;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;                                        // 单选按钮组
    private RadioButton rbutton1, rbutton2, rbutton3, rbutton4;                // 四个单选按钮
    private Resources res;
    private Drawable icon_home_true, icon_home_false, icon_me_true,
            icon_me_false, icon_order_true, icon_order_false,
            icon_community_true, icon_community_false;             // 四个单选按钮选中和未选中时的文字颜色
    private int fontColor_false, fontColor_true;                            // 四个单选按钮选中和未选中时的文字颜色
    private FragmentManager fgm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fgm = this.getFragmentManager();
        initView();                                 // 调用此方法实现初始化组件的功能
        navigation();                               // 调用此方法实现设置单选按钮组选项改变监听事件的功能从而实现导航功能
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void initView() {
        // 通过 ID 找到 UI 中的单选按钮组
        radioGroup = this.findViewById(R.id.main_radioGroup);
        rbutton1 = this.findViewById(R.id.main_radio0);
        rbutton2 = this.findViewById(R.id.main_radio1);
        rbutton3 = this.findViewById(R.id.main_radio2);
        rbutton4 = this.findViewById(R.id.main_radio3);
        res = getResources();                                               // 得到 Resources 对象，通过它获取存于系统的资源
        // 找到图片 icon_home_true, 用于设置当“首页”选项被选中时的图片
        icon_home_true = res.getDrawable(R.mipmap.icon_home_true);
        // 找到图片 icon_home_false, 用于设置当“首页”选项未被选中时的图片
        icon_home_false = res.getDrawable(R.mipmap.icon_home_false);
        // 找到图片 iocn_community_true, 用于设置当“吃货驾到”选项被选中时的图片
        icon_community_true = res.getDrawable(R.mipmap.icon_community_true);
        // 找到图片 icon_community_false, 用于设置当“吃货驾到”选项未被选中时的图片
        icon_community_false = res.getDrawable(R.mipmap.icon_community_false);
        // 找到图片 icon_me_true, 用于设置当“个人中心”选项被选中时的图片
        icon_me_true = res.getDrawable(R.mipmap.icon_me_true);
        // 找到图片 icon_me_false, 用于设置当“个人中心”选项未被选中时的图片
        icon_me_false = res.getDrawable(R.mipmap.icon_me_false);
        // 找到图片 icon_order_true, 用于设置当“我的订单”选项被选中时的图片
        icon_order_true = res.getDrawable(R.mipmap.icon_order_true);
        // 找到图片 icon_order_false, 用于设置当“我的订单”选项未被选中时的图片
        icon_order_false = res.getDrawable(R.mipmap.icon_order_false);
        // 找到颜色 navigation_false, 用于设置当选项未被选中时的文字颜色
        fontColor_false = res.getColor(R.color.navigation_false);
        // 找到颜色 public_green, 用于设置当选项被选中时的文字颜色
        fontColor_true = res.getColor(R.color.public_green);
        FragmentTransaction transaction = fgm.beginTransaction();           // 开启 Fragment 事务
        transaction.replace(R.id.main_frameLayout, new HomeFragment());    // 替换碎片内容
        transaction.commit();                                               // 提交事务
    }

    private void setAllColor() {
        rbutton1.setTextColor(fontColor_false);
        rbutton2.setTextColor(fontColor_false);
        rbutton3.setTextColor(fontColor_false);
        rbutton4.setTextColor(fontColor_false);
    }

    private void setAllImage() {
        // 设置“首页”选项图片为未被选中时的图片
        rbutton1.setCompoundDrawablesWithIntrinsicBounds(null, icon_home_false, null, null);
        // 设置“吃货驾到”选项图片为未被选中时的图片
        rbutton2.setCompoundDrawablesWithIntrinsicBounds(null, icon_community_false, null, null);
        // 设置“我的订单”选项图片为未被选中时的图片
        rbutton3.setCompoundDrawablesWithIntrinsicBounds(null, icon_order_false, null, null);
        // 设置“个人中心”选项图片为未被选中时的图片
        rbutton4.setCompoundDrawablesWithIntrinsicBounds(null, icon_me_false, null, null);
    }

    private void navigation() {
        // TODO Auto-generated method stub
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = fgm.beginTransaction();
                // 调用此方法用于在每次切换选项时将所有选项的文字颜色复位为未被选中的字体颜色
                setAllColor();
                // 调用此方法用于在每次切换选项时将所有选项的图片复位为未被选中的图片
                setAllImage();

                switch (checkedId) {
                    // 当“首页”选项被选中时，设置选项在被选中状态下的文字及图片
                    case R.id.main_radio0 :
                        rbutton1.setTextColor(fontColor_true);
                        rbutton1.setCompoundDrawablesWithIntrinsicBounds(null, icon_home_true, null, null);
                        transaction.replace(R.id.main_frameLayout, new HomeFragment()); // 替换碎片内容
                        break;
                    // 当“吃货驾到”选项被选中时，设置选项在被选中状态下的文字及图片
                    case R.id.main_radio1 :
                        rbutton2.setTextColor(fontColor_true);
                        rbutton2.setCompoundDrawablesWithIntrinsicBounds(null, icon_community_true, null, null);
//                        transaction.replace(R.id.main_frameLayout, new GourmetFragment()); // 替换碎片内容
                        break;
                    // 当“我的订单”选项被选中时，设置选项在被选中状态下的文字及图片
                    case R.id.main_radio2 :
                        rbutton3.setTextColor(fontColor_true);
                        rbutton3.setCompoundDrawablesWithIntrinsicBounds(null, icon_order_true, null, null);
                        Toast.makeText(MainActivity.this, "我的订单", Toast.LENGTH_SHORT).show();
                        break;
                    // 当“个人中心”选项被选中时，设置选项在被选中状态下的文字及图片
                    case R.id.main_radio3 :
                        rbutton4.setTextColor(fontColor_true);
                        rbutton4.setCompoundDrawablesWithIntrinsicBounds(null, icon_me_true, null, null);
                        transaction.replace(R.id.main_frameLayout, new PersonalCenter());
                        break;
                }
                transaction.commit();
            }
        });
    }
}
