package com.example.han.adding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;

public class ProjectRegister extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_register);



    }

    public void plusSub(View view) {
        // 서브 프로젝트 등록 페이지 로드
        AddDialog addDialog = new AddDialog(this);
        addDialog.show();
    }
}
