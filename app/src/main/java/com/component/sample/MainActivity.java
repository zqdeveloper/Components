package com.component.sample;

import android.os.Build;
import android.util.ArrayMap;

import androidx.annotation.RequiresApi;

import com.component.base.activity.ModuleManagerActivity;
import com.component.base.activity.R;

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
