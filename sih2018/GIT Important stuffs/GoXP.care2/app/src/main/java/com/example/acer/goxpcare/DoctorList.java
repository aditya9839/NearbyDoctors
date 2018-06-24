package com.example.acer.goxpcare;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorList extends Fragment {

    RecyclerView recyclerView;
    List<Doctors> doctorsList;

    public DoctorList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_doctor_list, container, false);
        doctorsList = new ArrayList<>();

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        doctorsList = new ArrayList<>();
        //adding some items to our list
        doctorsList.add(
                new Doctors(
                        1,
                        "Aamod Rao",
                        "Available on Monday",
                        4.3,
                        500,
                        R.drawable.doc1));
        doctorsList.add(
                new Doctors(
                        1,
                        "Sanjay Borude",
                        "Available today",
                        3.7,
                        300,
                        R.drawable.doc2));
        doctorsList.add(
                new Doctors(
                        1,
                        "Ramneek Mahajan",
                        "Available today",
                        4.2,
                        400,
                        R.drawable.doc3));

        //creating recyclerview adapter
        DoctorAdapter adapter = new DoctorAdapter(getActivity(), doctorsList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
        return v;
    }

}
