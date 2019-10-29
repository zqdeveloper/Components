package com.component.activity;

import android.os.Bundle;

public class BaseCWAbsModule extends CWAbsModule {
    @Override
    public boolean init(CWModuleContext cwModuleContext, Bundle extend) {
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
