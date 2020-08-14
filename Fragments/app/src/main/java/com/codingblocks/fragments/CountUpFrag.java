package com.codingblocks.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CountUpFrag extends Fragment {

    View fragment_View;
    Button btnAdd;
    TextView tv ;
    int count = 0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        fragment_View = inflater.inflate(R.layout.fragment_count_up, container, false);
        btnAdd = fragment_View.findViewById(R.id.btnAdd);
        tv = fragment_View.findViewById(R.id.tvAdd);
        try {

            btnAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                    tv.setText(String.valueOf(count));

                }
            });
        }
        catch (Exception e){
            Log.e("FRAG_UP", String.valueOf(e));
        }
        return fragment_View;
    }
}