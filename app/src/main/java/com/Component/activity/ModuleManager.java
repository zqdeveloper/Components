package com.Component.activity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;


import androidx.annotation.RequiresApi;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class ModuleManager {
    private ArrayMap<String, ArrayList<Integer>> modules = new ArrayMap<String, ArrayList<Integer>>();
    protected ArrayMap<String, CWAbsModule> allmodules = new ArrayMap<>();

    protected final ArrayMap<String, ArrayList<Integer>> getModules()
    {
        return modules;
    }

    public void moduleConfig(ArrayMap<String, ArrayList<Integer>>  modules){
        this.modules = modules;
    }
    public CWAbsModule getModuleByNames(String name) {
        if (!allmodules.isEmpty()) {
            return allmodules.get(name);
        }
        return null;
    }



    public void onReume() {
        for (CWAbsModule module: allmodules.values()) {
           if (module!=null) {
               module.onResume();
           }
        }
    }

    public void onPause() {
        for (CWAbsModule module: allmodules.values()) {
            if (module!=null) {
                module.onPause();
            }
        }
    }

    public void onStop()
    {
        for (CWAbsModule module: allmodules.values()) {
            if (module!=null) {
                module.onStop();
            }
        }
    }

    public void onConfigurationChanged(Configuration newConfig) {
        for (CWAbsModule module:allmodules.values()) {
            if (module!=null) {
                module.onOrientationChanges(newConfig.orientation==Configuration.ORIENTATION_LANDSCAPE);
            }
        }
    }

    public void onDestory() {
        for (CWAbsModule module: allmodules.values()) {
            if (module!=null) {
                module.onDestory();
            }
        }
    }

    public void onSaveInstanceState(Bundle outState){
        for (CWAbsModule module : allmodules.values()) {
            if (module != null) {
                module.onSaveInstance(outState);
            }
        }
    }
}
