package com.example.han.adding;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;


/**
 * A simple {@link Fragment} subclass.
 */
public class AnalyzeFragment extends Fragment {

    Spinner spinner;
    Spinner sub;
    AdapterSpinner mainSpinner;
    AdapterSpinner subSpinner;
    ArrayList<String> mainItem;
    final String[] mainArray = {"직업군, 취미, 성별, 나이대"};
    final String[] jobArray = {"예술, 사무직, 자영업, 서비스직, 생산직, 농축산, 학생, 기타"};
    final String[] ageArray = {"10대, 20대, 30대, 40대, 5/60대"};
    final String[] favArray = {"건강, 게임, 교육, 금융, 쇼핑, 스포츠, 소셜, 미디어"};
    final String[] genderArray = {"남, 여"};
    LinearLayout job;
    LinearLayout age;
    LinearLayout fav;
    LinearLayout gender;

    int check = 0;//현재 어떠한 정보가 위에서 선택되었는지 체크하는 변수

    public AnalyzeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        init();
        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ArrayList<String> subItem;
                subItem = new ArrayList<>();
                String str = parent.getItemAtPosition(position).toString();
                switch (str) {
                    case "직업군":
                        check = 1;
                        job.setVisibility(View.VISIBLE);
                        fav.setVisibility(View.GONE);
                        age.setVisibility(View.GONE);
                        gender.setVisibility(View.GONE);

                        Collections.addAll(subItem, jobArray);
                        subSpinner = new AdapterSpinner(getActivity(), subItem);
                        sub.setAdapter(subSpinner);
                        break;
                    case "취미":
                        check = 2;
                        job.setVisibility(View.GONE);
                        fav.setVisibility(View.VISIBLE);
                        age.setVisibility(View.GONE);
                        gender.setVisibility(View.GONE);

                        Collections.addAll(subItem, favArray);
                        subSpinner = new AdapterSpinner(getActivity(), subItem);
                        sub.setAdapter(subSpinner);
                        break;
                    case "성별":
                        check = 3;
                        job.setVisibility(View.GONE);
                        fav.setVisibility(View.GONE);
                        age.setVisibility(View.GONE);
                        gender.setVisibility(View.VISIBLE);

                        Collections.addAll(subItem, genderArray);
                        subSpinner = new AdapterSpinner(getActivity(), subItem);
                        sub.setAdapter(subSpinner);
                        break;
                    case "나이대":
                        check = 4;
                        job.setVisibility(View.GONE);
                        fav.setVisibility(View.GONE);
                        age.setVisibility(View.VISIBLE);
                        gender.setVisibility(View.GONE);

                        Collections.addAll(subItem, ageArray);
                        subSpinner = new AdapterSpinner(getActivity(), subItem);
                        sub.setAdapter(subSpinner);
                        break;
                }
            }
        });
        if (sub != null) {
            sub.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String str = parent.getItemAtPosition(position).toString();
                    switch (check) {
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            break;
                    }

                }
            });
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_analyze, container, false);

    }

    private void init() {
        mainItem = new ArrayList<>();
        spinner = (Spinner) getActivity().findViewById(R.id.main);
        sub = (Spinner) getActivity().findViewById(R.id.sub);
        Collections.addAll(mainItem, mainArray);
        mainSpinner = new AdapterSpinner(getActivity(), mainItem);
        spinner.setAdapter(mainSpinner);
        job = (LinearLayout) getActivity().findViewById(R.id.job);
        age = (LinearLayout) getActivity().findViewById(R.id.age);
        fav = (LinearLayout) getActivity().findViewById(R.id.fav);
        gender = (LinearLayout) getActivity().findViewById(R.id.gender);
    }

}
