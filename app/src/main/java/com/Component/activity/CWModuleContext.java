package com.Component.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.collection.SparseArrayCompat;

public class CWModuleContext
{
    private Context context;
    private Bundle saveInstance;
    private SparseArrayCompat<ViewGroup>  viewGroups = new SparseArrayCompat<ViewGroup>();

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

    public SparseArrayCompat<ViewGroup> getViewGroups() {
        return viewGroups;
    }

    public void setViewGroups(SparseArrayCompat<ViewGroup> viewGroups) {
        this.viewGroups = viewGroups;
    }
}
