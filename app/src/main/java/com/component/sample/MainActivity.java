package com.component.sample;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.component.activity.ModuleManagerActivity;
import com.component.activity.R;

import java.util.ArrayList;

public class MainActivity extends ModuleManagerActivity {

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
        ArrayMap<String,ArrayList<Integer>> maps = new ArrayMap<String, ArrayList<Integer>>();
        maps.put(PageConfig.name,new ArrayList<Integer>(){{add(R.id.linearlayout);add(R.id.hello_world);}});
        return maps;
    }


}
