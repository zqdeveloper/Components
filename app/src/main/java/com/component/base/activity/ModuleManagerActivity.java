package com.component.base.activity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public abstract class ModuleManagerActivity extends AppCompatActivity {
    private ActivityModuleManager moduleManager;

    @Override
    protected final void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        if (moduleManager == null){
            moduleManager = new ActivityModuleManager();
            moduleManager.initModules(savedInstanceState,ModuleManagerActivity.this,moduleConfig());
        }
    }

    public abstract int getContentView();

    public abstract ArrayMap<String, ArrayList<Integer>> moduleConfig();

    @Override
    protected void onStart() {
        super.onStart();
        moduleManager.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        moduleManager.onReume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        moduleManager.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        moduleManager.onStop();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        moduleManager.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moduleManager.onDestory();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        moduleManager.onSaveInstanceState(outState);
    }
}
