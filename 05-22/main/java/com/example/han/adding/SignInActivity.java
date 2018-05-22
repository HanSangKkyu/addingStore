package com.example.han.adding;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

import com.amazonaws.mobileconnectors.lambdainvoker.*;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;



public class SignInActivity extends AppCompatActivity {


    Spinner jobs; // 직업군
    Spinner favorite; // 관심분야
    ArrayList<String> jobItem;
    ArrayList<String> favoItem;
    AdapterSpinner jobAdapter;
    AdapterSpinner favoAdapter;
    final String[] jobItemArray = {"의료", "예술", "엔지니어", "교직", "관리직", "사무직", "자영업", "서비스직", "생산/노무직", "농/축/광/수산업", "학생", "주부", "무직", "퇴직/연금생활자", "기타"};
    final String[] favoItemArray = {"건강/운동", "게임", "교육", "금융", "날씨", "뉴스/잡지", "쇼핑", "도구", "스포츠", "음악,동영상", "소셜", "사진", "지도/내비게이션"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        init();

        CognitoCachingCredentialsProvider cognitoProvider = new CognitoCachingCredentialsProvider(
                getApplicationContext(),
                "ap-northeast-2:a03da40d-6e0a-40f9-9510-6a5fb5c4a37a", // 자격 증명 풀 ID
                Regions.AP_NORTHEAST_2 // 리전
        );
        LambdaInvokerFactory factory = new LambdaInvokerFactory(this.getApplicationContext(),
                Regions.AP_NORTHEAST_2, cognitoProvider);

        final CreatingAccountInterface creatingAccountInterface = factory.build(CreatingAccountInterface.class);

        AccountClass request = new AccountClass("kkyu67@konkuk.ac.kr", "1234", "한상규", 22, 0, "엔지니어", 0, "안드로이", false, null);

        new AsyncTask<AccountClass, Void, BasicResponseClass>() {
            @Override
            protected BasicResponseClass doInBackground(AccountClass... params) {
                // invoke "echo" method. In case it fails, it will throw a
                // LambdaFunctionException.
                try {
                    return creatingAccountInterface.addingCreateAccount(params[0]);
                } catch (LambdaFunctionException lfe) {
                    Log.e("Tag", "Failed to invoke echo", lfe);
                    return null;
                }
            }

            @Override
            protected void onPostExecute(BasicResponseClass result) {
                if (result == null) {
                    return;
                }

                if (result.isState()) {
                    Toast.makeText(getApplicationContext(), "가입 성공", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), result.getStr(), Toast.LENGTH_LONG).show();
                }
            }
        }.execute(request);

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

    public void goCast(View view) {
        Intent intent = new Intent(this, Collect.class);
        intent.putExtra("menu", "cast");
        startActivity(intent);
        finish();
    }


    public void fundThisProj(View view) {

        // 프로젝트 투자 화면으로 넘어가기
    }


}
