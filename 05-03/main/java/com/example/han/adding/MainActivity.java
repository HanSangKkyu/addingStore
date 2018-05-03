package com.example.han.adding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goCast(View view) {
        Intent intent = new Intent(this, Collect.class);
        intent.putExtra("menu", "cast");
        startActivity(intent);
    }

    public void goFund(View view) {
        Intent intent = new Intent(this, Collect.class);
        intent.putExtra("menu", "fund");
        startActivity(intent);
    }
}
