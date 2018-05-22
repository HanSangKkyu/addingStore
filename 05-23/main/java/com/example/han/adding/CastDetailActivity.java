package com.example.han.adding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CastDetailActivity extends AppCompatActivity {

    TextView title;
    TextView date;
    ImageView image;
    TextView content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_detail);

        title = (TextView) findViewById(R.id.title);
        date = (TextView) findViewById(R.id.date);
        image = (ImageView) findViewById(R.id.image);
        content = (TextView) findViewById(R.id.content);


        Intent intent = getIntent();
        int castNum = intent.getIntExtra("castNum", -1);
        if (castNum != -1) {
            // 서버에서 가져와서 내용 불러오기

        }
    }
}
