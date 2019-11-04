package com.component.base.view;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public  abstract class ModuleManagerView extends View {
    private ViewModuleManager viewModuleManager;
    public ModuleManagerView(Context context) {
        this(context, null);
    }

    public ModuleManagerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ModuleManagerView(Context context, Bundle saveInstanceState, View rootView) {
        super(context);
        viewModuleManager = new ViewModuleManager();
        viewModuleManager.initModules(saveInstanceState, (FragmentActivity)context, rootView, moduleConfig());
    }

    public void onResume() {
        if (viewModuleManager!=null) {
            viewModuleManager.onReume();
        }
    }

    public void onPause() {
        if (viewModuleManager!=null) {
            viewModuleManager.onPause();
        }
    }

    public void onStop() {
        if (viewModuleManager!=null) {
            viewModuleManager.onStop();
        }
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (viewModuleManager!=null) {
            viewModuleManager.onConfigurationChanged(newConfig);
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (viewModuleManager!=null) {
            viewModuleManager.onDestory();
        }
    }

    public abstract ArrayMap<String, ArrayList<Integer>> moduleConfig();
}
