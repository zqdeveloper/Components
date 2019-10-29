package com.component.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import androidx.collection.SparseArrayCompat;

public class CWModuleContext
{
    private Context context;
    private Bundle saveInstance;
    private SparseArrayCompat<View>  viewGroups = new SparseArrayCompat<View>();

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
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
