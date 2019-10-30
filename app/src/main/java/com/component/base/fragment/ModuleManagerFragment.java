package com.component.base.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public abstract class ModuleManagerFragment extends Fragment {

    private FragmentModuleManager fragmentModuleManager;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentModuleManager = new FragmentModuleManager();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentModuleManager.initModules(savedInstanceState,getActivity(),view,moduleConfig());
    }

    @Override
    public void onStart() {
        super.onStart();
        fragmentModuleManager.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        fragmentModuleManager.onReume();
    }

    @Override
    public void onPause() {
        super.onPause();
        fragmentModuleManager.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentModuleManager.onDestory();
    }

    @Override
    public void onStop() {
        super.onStop();
        fragmentModuleManager.onStop();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        fragmentModuleManager.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        fragmentModuleManager.onSaveInstanceState(outState);
    }

    public abstract ArrayMap<String, ArrayList<Integer>> moduleConfig();
}
