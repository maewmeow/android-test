package com.example.paramas_wae.myviewpager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {
    TextView textView1;

    public static TwoFragment newInstance() {
        TwoFragment fragment = new TwoFragment();
        return fragment;
    }

    public TwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_two, container, false);
        textView1 = (TextView) rootView.findViewById(R.id.textView1);
        return rootView;
    }

    public String getMyText() {
        return textView1.getText().toString();
    }

}
