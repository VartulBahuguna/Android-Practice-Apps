package com.codingblocks.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the factory method to
 * create an instance of this fragment.
 */
public class Vegetables extends Fragment {

    View frag_view ;
    ListView lv;
    String[] Veg = {"Potato", "Tomato", "Onion", "Spinach", "LadyFinger", "Radish", "Carrot", "Broccoli", "Baby-corn", "Beans", "Beetroot"};
    public static final String ERR = "ERROR!!!!!!";

    public static final String TAG = "VEG";
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "VEG ATTACHED");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "VEG CREATED");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "VEG CREATED_VIEW");
        // Inflate the layout for this fragment
        frag_view = inflater.inflate(R.layout.fragment_vegetables, container, false);

        lv = frag_view.findViewById(R.id.lvVeg);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Veg);

        lv.setAdapter(adapter);
        return frag_view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "VEG ACTIVITY_CREATED");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "VEG STARTED");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "VEG RESUMED");
    }



    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "VEG PAUSED");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "VEG STOPPED");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "VEG DESTROYED_VIEW");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "VEG DESTROYED");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "VEG DETACHED");
    }
}