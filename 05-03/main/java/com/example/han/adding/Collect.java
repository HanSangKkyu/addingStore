package com.example.han.adding;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Collect extends AppCompatActivity {

    TextView castText;
    TextView fundText;
    TextView reportText;
    TextView settingText;

    CastFragment castFragment;
    FundFragment fundFragment;
    ReportFragment reportFragment;
    CashFragment cashFragment;
    final int SELECTED_ITEM = 123;

    LinearLayout seleckBar;
    int layoutWidth;
    int layoutHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);

        seleckBar = (LinearLayout) findViewById(R.id.select_bar);

        castFragment = new CastFragment();
        fundFragment = new FundFragment();
        reportFragment = new ReportFragment();
        cashFragment = new CashFragment();


        castText = (TextView) findViewById(R.id.cast);
        fundText = (TextView) findViewById(R.id.fund);
        reportText = (TextView) findViewById(R.id.report);
        settingText = (TextView) findViewById(R.id.setting);

        Intent intent = getIntent();
        String menu = intent.getStringExtra("menu");
        if (menu.equals("cast")) {
            goCast(new View(getApplicationContext()));
        } else if (menu.equals("fund")) {
            goFund(new View(getApplicationContext()));
        }


    }

    public void goMenu(View view) {
        startActivityForResult(new Intent(this, LeftTitleActivity.class), SELECTED_ITEM);
        overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_none);

    }

    public void goCast(View view) {
        initTextColor();
        castText.setTextColor(Color.parseColor("#000000"));

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, castFragment).commit();
    }

    public void goFund(View view) {
        initTextColor();
        fundText.setTextColor(Color.parseColor("#000000"));

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, fundFragment).commit();
    }

    public void goReport(View view) {
        initTextColor();
        reportText.setTextColor(Color.rgb(0, 0, 0));

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, reportFragment).commit();
        fragmentTransaction.setCustomAnimations(R.anim.anim_slide_in_left, R.anim.anim_slide_in_left);
    }

    public void goSetting(View view) {
        initTextColor();
        reportText.setTextColor(Color.rgb(0, 0, 0));

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, castFragment).commit();
        fragmentTransaction.setCustomAnimations(R.anim.anim_slide_in_left, R.anim.anim_slide_in_left);
    }

    public void initTextColor() {
        if (layoutWidth != 0)
            seleckBar.setLayoutParams(new LinearLayout.LayoutParams(layoutWidth, layoutHeight));

        castText.setTextColor(Color.parseColor("#848484"));
        fundText.setTextColor(Color.parseColor("#848484"));
        reportText.setTextColor(Color.parseColor("#848484"));
        settingText.setTextColor(Color.parseColor("#848484"));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECTED_ITEM) {
            if (resultCode == Activity.RESULT_OK) {
                switch (data.getStringExtra("menu")) {
                    case "cast":
                        goCast(new View(getApplicationContext()));
                        break;
                    case "fund":
                        goFund(new View(getApplicationContext()));
                        break;
                    case "report":
                        goReport(new View(getApplicationContext()));
                        break;
                    case "setting":
                        goSetting(new View(getApplicationContext()));
                        break;
                    case "cash":
                        layoutWidth = seleckBar.getWidth();
                        layoutHeight = seleckBar.getHeight();
                        seleckBar.setLayoutParams(new LinearLayout.LayoutParams(layoutWidth, 0));
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment, cashFragment).commit();
                        fragmentTransaction.setCustomAnimations(R.anim.anim_slide_in_left, R.anim.anim_slide_in_left);
                        break;
                }

            }
        }
    }
}
