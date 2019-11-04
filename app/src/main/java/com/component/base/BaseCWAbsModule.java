package com.component.base;

import android.app.Activity;
import android.os.Bundle;

public abstract class BaseCWAbsModule extends CWAbsModule {
    protected Activity context;
    protected CWModuleContext cwModuleContext;
    @Override
    public boolean init(CWModuleContext cwModuleContext, Bundle extend) {
        this.context = cwModuleContext.getContext();
        this.cwModuleContext = cwModuleContext;
        return false;
    }

    @Override
    public void onSaveInstance(Bundle outState) {

    }

    @Override
    public void onStart() {

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
