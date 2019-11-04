package com.component.sample;

import android.os.Build;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.component.base.activity.R;
import com.component.base.fragment.ModuleManagerFragment;
import com.component.base.view.ModuleManagerView;

import java.util.ArrayList;
@RequiresApi(api = Build.VERSION_CODES.KITKAT)
public class ModuleExampleFragment extends ModuleManagerFragment {
    private ModuleManagerView moduleManagerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=super.onCreateView(inflater,container,savedInstanceState);
        moduleManagerView = new ModuleManagerView(getActivity(),savedInstanceState,view.findViewById(R.id.page_view)) {
            @Override
            public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
                ArrayMap<String, ArrayList<Integer>> map = new ArrayMap<String, ArrayList<Integer>>();
                return map;
            }
        };
        return view;
    }

    @Override
    public ArrayMap<String, ArrayList<Integer>> moduleConfig() {
        return null;
    }

    @Override
    public void onStop() {
        super.onStop();
        if (moduleManagerView!=null) {
            moduleManagerView.onStop();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (moduleManagerView!=null) {
            moduleManagerView.onPause();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (moduleManagerView!=null) {
            moduleManagerView.onResume();
        }
    }
}
