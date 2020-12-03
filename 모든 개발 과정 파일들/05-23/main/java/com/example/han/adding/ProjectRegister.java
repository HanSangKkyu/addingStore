package com.example.han.adding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;

public class ProjectRegister extends AppCompatActivity {


    Spinner favorite; // 관심분야
    ArrayList<String> favoItem;
    AdapterSpinner favoAdapter;
    final String[] favoItemArray = {"건강/운동", "게임", "교육", "금융", "날씨", "뉴스/잡지", "쇼핑", "도구", "스포츠", "음악,동영상", "소셜", "사진", "지도/내비게이션"};


    String kind; // 분야
    EditText pName;
    EditText pIntro;
    CalendarView date;
    EditText fundGoal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_register);

        // 스피너 연결
        favorite = (Spinner) findViewById(R.id.kind);
        favoItem = new ArrayList<>();
        Collections.addAll(favoItem, favoItemArray);
        favoAdapter = new AdapterSpinner(this, favoItem);
        favorite.setAdapter(favoAdapter);


        favorite.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                kind = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                kind = parent.getItemAtPosition(0).toString();

            }
        });

        pName = (EditText) findViewById(R.id.pName);
        pIntro = (EditText) findViewById(R.id.pIntro);
        date = (CalendarView) findViewById(R.id.date);
        fundGoal = (EditText) findViewById(R.id.fundGoal);

    }

    public void plusSub(View view) {
        // 서브 프로젝트 등록 페이지 로드
        AddDialog addDialog = new AddDialog(this);
        addDialog.show();
    }


    public void register(View view) {
    }
}
