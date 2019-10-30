package com.component.sample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.collection.SparseArrayCompat;

import com.component.base.BaseCWAbsModule;
import com.component.base.CWModuleContext;

public class PageNameModule extends BaseCWAbsModule {

    private Context context;
    private SparseArrayCompat<View> viewGroups;


    @Override
    public boolean init(CWModuleContext cwModuleContext, Bundle extend) {
        context = cwModuleContext.getContext();
        viewGroups = cwModuleContext.getViewGroups();
        return false;
    }

    @Override
    public void onSaveInstance(Bundle outState) {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onOrientationChanges(boolean isLandscape) {

    }

    @Override
    public void onDestory() {

    }
}
