package com.example.han.adding;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class ProjectRegister extends AppCompatActivity {

    final int SELECT_IMAGE = 10;


    Spinner favorite; // 관심분야
    ArrayList<String> favoItem;
    AdapterSpinner favoAdapter;
    final String[] favoItemArray = {"건강/운동", "게임", "교육", "금융", "날씨", "뉴스/잡지", "쇼핑", "도구", "스포츠", "음악,동영상", "소셜", "사진", "지도/내비게이션"};


    String kind; // 분야
    EditText pName;
    ImageView pimg;
    EditText pIntro;
    CalendarView date;
    EditText fundGoal;

    int myear;
    int mmonth;
    int mdayOfMonth;

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
        pimg = (ImageView) findViewById(R.id.selectImg);
        pimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkAppPermission(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE})) { //예전에 권한을 얻었다면 갤러리 화면으로 이동
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                    intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, SELECT_IMAGE);
                } else {
                    askPermission(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, SELECT_IMAGE); // 예전에 권한을 얻지 않았다면 권한요구
                }

            }
        });


        pIntro = (EditText) findViewById(R.id.pIntro);
        date = (CalendarView) findViewById(R.id.date);
        date.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                myear = year;
                mmonth = month + 1; // 월은 가져올 때 1을 더해준다.
                mdayOfMonth = dayOfMonth;
            }
        });
        fundGoal = (EditText) findViewById(R.id.fundGoal);

    }

    public void plusSub(View view) {
        // 서브 프로젝트 등록 페이지 로드
        AddDialog addDialog = new AddDialog(this);
        addDialog.show();
    }


    public void register(View view) {
        // 여기서 아마존 람다함수로 서버에 넣어주기
        // kind;
        pName.getText();
        pIntro.getText();
        Log.v("aa", myear + " : " + mmonth + " : " + mdayOfMonth);

        fundGoal.getText();

    }

    void askPermission(String[] requestPermission, int REQ_PERMISSION) { // Manifest에 등록된 권한들의 배열을 requestPermission이라고 한다. requestPermission중 전화 권한인 callRequest(프로그래먼가 만들어준 수)를 넘겨준다.
        ActivityCompat.requestPermissions( // 권한요청 코드
                this,
                requestPermission,
                REQ_PERMISSION // 전화 권한요청 코드
        );
    }


    boolean checkAppPermission(String[] requestPermission) {
        boolean[] requestResult = new boolean[requestPermission.length];
        for (int i = 0; i < requestResult.length; i++) {
            requestResult[i] = (ContextCompat.checkSelfPermission(this,
                    requestPermission[i]) == PackageManager.PERMISSION_GRANTED);
            if (!requestResult[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) { // 권한 요청에 대한 질문이 끝났을 때 자동으로 호출된다.
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case SELECT_IMAGE: // 갤러리픽 권한에 대한 내용을 평가해준다.
                if (checkAppPermission(permissions)) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType(android.provider.MediaStore.Images.Media.CONTENT_TYPE);
                    intent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, SELECT_IMAGE);
                } else {
                    Toast.makeText(getApplicationContext(), "권한 획득에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE) {
            if (resultCode == Activity.RESULT_OK) {
                pimg.setImageURI(data.getData()); // getData로 넘어오는 정보를 바로 지정해준다.
                Log.v("asdf", data.getData() + "");
            }
        }
    }


}

