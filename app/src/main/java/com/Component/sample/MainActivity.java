package com.Component.sample;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.Component.activity.ModuleManagerActivity;
import com.Component.activity.R;

import java.util.ArrayList;

public class MainActivity extends ModuleManagerActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
        ArrayMap<String,ArrayList<Integer>> maps = new ArrayMap<String, ArrayList<Integer>>();
        maps.put(PageConfig.name,new ArrayList<Integer>(){{add(R.id.linearlayout); add(R.id.hello_world);}});
        return maps;
    }


}
