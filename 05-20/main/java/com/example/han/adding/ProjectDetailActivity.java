package com.example.han.adding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class ProjectDetailActivity extends AppCompatActivity {

    RatingBar reviewPoint;
    EditText reviewText;
    Button reviewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);


        reviewPoint = (RatingBar) findViewById(R.id.reviewPoint);
        reviewText = (EditText) findViewById(R.id.reviewText);
        reviewButton = (Button) findViewById(R.id.reviewButton);

        // 평가, 댓글에 작성하기 기능 구현

    }
}
