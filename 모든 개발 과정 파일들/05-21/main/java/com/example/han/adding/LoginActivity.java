package com.example.han.adding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    static public UserInfo user;
    EditText email;
    EditText pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.email);
        pw = (EditText) findViewById(R.id.pw);

        // 만약 email과 pw가 데이터베이스 안에 있다면

        //user = new UserInfo(String email, String pw, String name, int age, int gender, String job, String favorite);
    }

    public void goCast(View view) {
        Intent intent = new Intent(this, Collect.class);
        intent.putExtra("menu", "cast");
        startActivity(intent);
        finish();
    }
}
