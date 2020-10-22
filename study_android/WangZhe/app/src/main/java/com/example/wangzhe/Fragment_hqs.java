package com.example.wangzhe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_hqs extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.hqs, container, false);
        // R.layout.hqs 为碎片的 XML 布局文件
        // container 存放 Fragment 的 Layout 的 ViewGroup
        // 布尔数据表示是否在创建 Fragment 的 layout 文件夹期间，把 layout 文件夹附加到 container 上 （在这个例子中，因为系统已经把 layout 文件插入 container 中了，所以布尔数据的值为 false，如果值为 true 会导致在最终的 layout 文件夹中创建多余的 ViewGroup）
    }
}
