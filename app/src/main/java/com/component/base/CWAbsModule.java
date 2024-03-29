package com.component.base;

import android.os.Bundle;

import com.component.base.CWModuleContext;

public abstract class CWAbsModule {
    public abstract boolean init(CWModuleContext cwModuleContext, Bundle extend);

    public abstract void onSaveInstance(Bundle outState);

    public abstract void onResume();

    public abstract void onPause();

    public abstract void onStop();

    public abstract void onOrientationChanges(boolean isLandscape);

    public abstract void onDestory();

    public abstract void onStart();
}
