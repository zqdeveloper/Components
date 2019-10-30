package com.component.base.fragment;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.collection.SparseArrayCompat;
import com.component.base.CWAbsModule;
import com.component.base.CWModuleContext;
import com.component.base.CWModuleFactory;
import com.component.base.ModuleManager;

import java.util.ArrayList;
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class FragmentModuleManager extends ModuleManager {

    public void initModules(Bundle saveInstance, Activity activity,View rootView, ArrayMap<String, ArrayList<Integer>> modules) {
        if (activity==null||modules == null) return;
        moduleConfig(modules);
        initModules(saveInstance,rootView,activity);
    }

    private void initModules(Bundle saveInstance, View rootView, Activity activity) {
        if (getModules()==null) return;
        for (String moduleName: getModules().keySet()) {
            CWAbsModule module = CWModuleFactory.newModuleInstance(moduleName);
            if (module!=null) {
                CWModuleContext moduleContext = new CWModuleContext();
                moduleContext.setContext(activity);
                moduleContext.setSaveInstance(saveInstance);
                SparseArrayCompat<View> viewGroups = new SparseArrayCompat<>();
                ArrayList<Integer> mViewIds = getModules().get(moduleName);
                if (mViewIds!=null&&mViewIds.size()>0) {
                    for (int i=0; i<mViewIds.size(); i++) {
                        viewGroups.put(mViewIds.get(i), rootView.findViewById(mViewIds.get(i)));
                    }
                }
                moduleContext.setViewGroups(viewGroups);
                module.init(moduleContext,saveInstance);
                allmodules.put(moduleName,module);
            }
        }
    }
}
