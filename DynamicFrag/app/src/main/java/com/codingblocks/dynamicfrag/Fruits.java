package com.codingblocks.dynamicfrag;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Fruits extends Fragment {


    View fv;
    ListView lv;
    String[] fruits = {"Apple", "Banana", "Orange", "Kiwi", "Melon", "WaterMelon", "Manggo", "Berrry", "Grapes", "Guava", "Pear"};
    public static final String TAG = "ERROR!!!!!!";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fv = inflater.inflate(R.layout.fragment_fruits, container, false);
        lv = fv.findViewById(R.id.lvFriuts);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, fruits);

        lv.setAdapter(adapter);
        return fv;
    }
}