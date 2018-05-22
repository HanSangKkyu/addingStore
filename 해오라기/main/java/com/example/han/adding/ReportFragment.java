package com.example.han.adding;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReportFragment extends Fragment {

    TextView registerProj;

    ArrayList<String> fundList; // 임시적으로 String이라고 함
    ListView fundListView;
    ReportFundListAdapter reportFundListAdapter;


    ArrayList<String> myList; // 임시적으로 String이라고 함
    ListView myListView;
    ReportMyListAdapter reportMyListAdapter;


    public ReportFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        registerProj = (TextView) getActivity().findViewById(R.id.registerProj);
        registerProj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), ProjectRegister.class));
            }
        });


        // ListView 연결
        fundList = new ArrayList<>();
        fundListView = (ListView) getActivity().findViewById(R.id.fundListView);
        reportFundListAdapter = new ReportFundListAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, fundList);
        fundListView.setAdapter(reportFundListAdapter);

        myList = new ArrayList<>();
        myListView = (ListView) getActivity().findViewById(R.id.myListView);
        reportMyListAdapter = new ReportMyListAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, myList);
        fundListView.setAdapter(reportMyListAdapter);
    }
}
