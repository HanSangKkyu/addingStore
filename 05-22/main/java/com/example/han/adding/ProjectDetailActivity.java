package com.example.han.adding;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;

public class ProjectDetailActivity extends AppCompatActivity {
    static final int COUNT = 15;//자바 상수 선언
    Button[] bt1;
    Button[] bt2;
    Button[] bt3;

    RatingBar reviewPoint;
    EditText reviewText;
    Button reviewButton;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);


        reviewPoint = (RatingBar) findViewById(R.id.reviewPoint);
        reviewText = (EditText) findViewById(R.id.reviewText);
        reviewButton = (Button) findViewById(R.id.reviewButton);
        progressBar = (ProgressBar) findViewById(R.id.progress);

        progressBar.setProgress(25);

        // 평가, 댓글에 작성하기 기능 구현

        initButton();

    }

    private void initButton() {


        // 개발할 기능
        bt1 = new Button[COUNT];
        bt1[0] = (Button) findViewById(R.id.bt1_1);
        bt1[1] = (Button) findViewById(R.id.bt1_2);
        bt1[2] = (Button) findViewById(R.id.bt1_3);
        bt1[3] = (Button) findViewById(R.id.bt1_4);
        bt1[4] = (Button) findViewById(R.id.bt1_5);
        bt1[5] = (Button) findViewById(R.id.bt1_6);
        bt1[6] = (Button) findViewById(R.id.bt1_7);
        bt1[7] = (Button) findViewById(R.id.bt1_8);
        bt1[8] = (Button) findViewById(R.id.bt1_9);
        bt1[9] = (Button) findViewById(R.id.bt1_10);
        bt1[10] = (Button) findViewById(R.id.bt1_11);
        bt1[11] = (Button) findViewById(R.id.bt1_12);
        bt1[12] = (Button) findViewById(R.id.bt1_13);
        bt1[13] = (Button) findViewById(R.id.bt1_14);
        bt1[14] = (Button) findViewById(R.id.bt1_15);

        for (int i = 0; i < COUNT; i++) {
            bt1[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowDialog showDialog = new ShowDialog(v.getContext());
                    showDialog.show();
                }
            });
        }


        // 개발 중인 기능
        bt2 = new Button[COUNT];
        bt2[0] = (Button) findViewById(R.id.bt2_1);
        bt2[1] = (Button) findViewById(R.id.bt2_2);
        bt2[2] = (Button) findViewById(R.id.bt2_3);
        bt2[3] = (Button) findViewById(R.id.bt2_4);
        bt2[4] = (Button) findViewById(R.id.bt2_5);
        bt2[5] = (Button) findViewById(R.id.bt2_6);
        bt2[6] = (Button) findViewById(R.id.bt2_7);
        bt2[7] = (Button) findViewById(R.id.bt2_8);
        bt2[8] = (Button) findViewById(R.id.bt2_9);
        bt2[9] = (Button) findViewById(R.id.bt2_10);
        bt2[10] = (Button) findViewById(R.id.bt2_11);
        bt2[11] = (Button) findViewById(R.id.bt2_12);
        bt2[12] = (Button) findViewById(R.id.bt2_13);
        bt2[13] = (Button) findViewById(R.id.bt2_14);
        bt2[14] = (Button) findViewById(R.id.bt2_15);


        for (int i = 0; i < COUNT; i++) {
            bt2[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowDialog showDialog = new ShowDialog(v.getContext());
                    showDialog.show();

                }
            });

        }


        // 개발한 기능
        bt3 = new Button[COUNT];
        bt3[0] = (Button) findViewById(R.id.bt3_1);
        bt3[1] = (Button) findViewById(R.id.bt3_2);
        bt3[2] = (Button) findViewById(R.id.bt3_3);
        bt3[3] = (Button) findViewById(R.id.bt3_4);
        bt3[4] = (Button) findViewById(R.id.bt3_5);
        bt3[5] = (Button) findViewById(R.id.bt3_6);
        bt3[6] = (Button) findViewById(R.id.bt3_7);
        bt3[7] = (Button) findViewById(R.id.bt3_8);
        bt3[8] = (Button) findViewById(R.id.bt3_9);
        bt3[9] = (Button) findViewById(R.id.bt3_10);
        bt3[10] = (Button) findViewById(R.id.bt3_11);
        bt3[11] = (Button) findViewById(R.id.bt3_12);
        bt3[12] = (Button) findViewById(R.id.bt3_13);
        bt3[13] = (Button) findViewById(R.id.bt3_14);
        bt3[14] = (Button) findViewById(R.id.bt3_15);

        for (int i = 0; i < COUNT; i++) {
            bt3[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ShowDialog showDialog = new ShowDialog(v.getContext());
                    showDialog.show();

                }
            });
        }


    }


    public void fundThisProj(View view) {
        PayDialog payDialog = new PayDialog(this);
        payDialog.show();
    }
}
