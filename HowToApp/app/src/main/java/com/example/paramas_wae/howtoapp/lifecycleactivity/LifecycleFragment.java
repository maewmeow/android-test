package com.example.paramas_wae.howtoapp.lifecycleactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paramas_wae.howtoapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LifecycleFragment extends Fragment {

    public static LifecycleFragment newInstance() {
        return new LifecycleFragment();
    }
    public LifecycleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lifecycle, container, false);
    }

}
