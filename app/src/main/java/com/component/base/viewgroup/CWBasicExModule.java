package com.component.base.viewgroup;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.component.base.BaseCWAbsModule;
import com.component.base.CWModuleContext;

public class CWBasicExModule extends BaseCWAbsModule {


    private Activity activity;
    private View parentViewGroup;
    private View pageNameView;
    private TextView pageTitlle;

    @Override
    public boolean init(CWModuleContext cwModuleContext, Bundle extend) {
        super.init(cwModuleContext, extend);
        activity = cwModuleContext.getContext();
        parentViewGroup = cwModuleContext.getViewGroups().get(0);
        this.cwModuleContext =cwModuleContext;
        initView();

        return true;
    }

    private void initView() {

    }
}
