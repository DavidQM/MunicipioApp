package com.example.viper2.municipioapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A simple {@link Fragment} subclass.
 */
//public class HotelUnoFragment extends Fragment implements View.OnClickListener {
    public class HotelUnoFragment extends Fragment {

    public HotelUnoFragment() {
        // Required empty public constructor

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel_uno, container, false);
    }


}


