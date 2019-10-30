package com.component.sample;

import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.component.base.activity.R;
import com.component.base.fragment.ModuleManagerFragment;

import java.util.ArrayList;

public class MineFragment extends ModuleManagerFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main,container,false);
    }

    @Override
    public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
        return null;
    }
}
