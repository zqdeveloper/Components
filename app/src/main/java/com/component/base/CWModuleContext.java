package com.component.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.collection.SparseArrayCompat;

public class CWModuleContext
{
    private Activity context;
    private Bundle saveInstance;

    private SparseArrayCompat<View>  viewGroups = new SparseArrayCompat<View>();

    public Activity getContext() {
        return context;
    }

    public void setContext(Activity context) {
        this.context = context;
    }

    public Bundle getSaveInstance() {
        return saveInstance;
    }

    public void setSaveInstance(Bundle saveInstance) {
        this.saveInstance = saveInstance;
    }

    public SparseArrayCompat<View> getViewGroups() {
        return viewGroups;
    }

    public void setViewGroups(SparseArrayCompat<View> viewGroups) {
        this.viewGroups = viewGroups;
    }
}
