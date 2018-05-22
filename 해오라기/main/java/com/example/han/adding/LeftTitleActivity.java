package com.example.han.adding;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.han.adding.LoginActivity.user;

public class LeftTitleActivity extends AppCompatActivity {

    RelativeLayout notLogin;
    RelativeLayout login;
    TextView userName;
    TextView currnetCash;
    Button logoutBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.left_title);

        checkLogin();


    }

    private void checkLogin() {
        notLogin = (RelativeLayout) findViewById(R.id.notLogin);
        login = (RelativeLayout) findViewById(R.id.login);

        if (user.getEmail() == null) { // 로그인이 안됐다면
            notLogin.setVisibility(View.VISIBLE);
            login.setVisibility(View.INVISIBLE);
        } else { // 로그인 됐다면
            notLogin.setVisibility(View.INVISIBLE);
            login.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.anim_none, R.anim.anim_slide_in_right);

    }

    public void goback(View view) {
        onBackPressed();
    }

    public void goCash(View view) {
        Intent intent = new Intent(this, Collect.class);
        intent.putExtra("menu", "cash");
        setResult(RESULT_OK, intent);
        onBackPressed();
    }


    public void goCast(View view) {
        Intent intent = new Intent(this, Collect.class);
        intent.putExtra("menu", "cast");
        setResult(RESULT_OK, intent);
        onBackPressed();
    }

    public void goFund(View view) {
        Intent intent = new Intent(this, Collect.class);
        intent.putExtra("menu", "fund");
        setResult(RESULT_OK, intent);
        onBackPressed();
    }

    public void goReport(View view) {
        Intent intent = new Intent(this, Collect.class);
        intent.putExtra("menu", "report");
        setResult(RESULT_OK, intent);
        onBackPressed();
    }

    public void goSetting(View view) {
        Intent intent = new Intent(this, Collect.class);
        intent.putExtra("menu", "setting");
        setResult(RESULT_OK, intent);
        onBackPressed();
    }

    public void goLogin(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

    public void goSignin(View view) {
        startActivity(new Intent(this, SignInActivity.class));
    }

}
