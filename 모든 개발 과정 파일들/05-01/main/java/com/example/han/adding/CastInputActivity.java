package com.example.han.adding;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CastInputActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cast_input);

    }

    public void goMenu(View view) {
        Intent
        startActivity(new Intent(this, LeftTitleActivity.class));
        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_none);
    }
}
