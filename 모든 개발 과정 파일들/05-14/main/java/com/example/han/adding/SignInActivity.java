package com.example.han.adding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;

public class SignInActivity extends AppCompatActivity {


    Spinner jobs; // 직업군
    Spinner favorite; // 관심분야
    ArrayList<String> jobItem;
    ArrayList<String> favoItem;
    AdapterSpinner jobAdapter;
    AdapterSpinner favoAdapter;
    final String[] jobItemArray = {"의료", "예술", "엔지니어", "교직", "관리직", "사무직", "자영업", "서비스직", "생산/노무직", "농/축/광/수산업", "학생", "주부", "무직", "퇴직/연금생활자", "기타"};
    final String[] favoItemArray = {"인문학", "사회과학", "자연과학", "공학", "의약학", "농수해양학", "예술체육", "복합학", "교약"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        init();

    }

    void init() {
        jobs = (Spinner) findViewById(R.id.jobs);
        favorite = (Spinner) findViewById(R.id.favorite);
        jobItem = new ArrayList<>();
        favoItem = new ArrayList<>();
        Collections.addAll(jobItem, jobItemArray);
        Collections.addAll(favoItem, favoItemArray);
        jobAdapter = new AdapterSpinner(this, jobItem);
        favoAdapter = new AdapterSpinner(this, favoItem);
        jobs.setAdapter(jobAdapter);
        favorite.setAdapter(favoAdapter);
    }

}
