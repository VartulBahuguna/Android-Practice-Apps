package com.codingblocks.fragments;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Fruit extends Fragment {

   View frag_view ;
   ListView lv;
   String[] fruits = {"Apple", "Banana", "Orange", "Kiwi", "Melon", "WaterMelon", "Manggo", "Berrry", "Grapes", "Guava", "Pear"};
   public static final String ERR = "ERROR!!!!!!";

    public static final String TAG = "FRUIT";
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "FRUIT ATTACHED");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "FRUIT CREATED");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        try {
            frag_view = inflater.inflate(R.layout.fragment_fruit, container, false);
        }
        catch (Exception e)
        {
            Log.e(TAG, "onCreateView", e);
            throw e;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, fruits);

        lv = frag_view.findViewById(R.id.lvFruits);

        lv.setAdapter(adapter);

        return frag_view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "FRUIT ACTIVITY_CREATED");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "FRUIT STARTED");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "FRUIT RESUMED");
    }



    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "FRUIT PAUSED");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "FRUIT STOPPED");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "FRUIT DESTROYED_VIEW");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "FRUIT DESTROYED");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "FRUIT DETACHED");
    }
}