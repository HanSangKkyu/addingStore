package com.example.han.adding;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ShowDialog extends Dialog {


    TextView scrum_title;
    TextView closeBtn;
    TextView desc;
    EditText errorMsg;
    Button downBtn;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_scrum);


        scrum_title = (TextView) findViewById(R.id.scrum_title);
        closeBtn = (TextView) findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        desc = (TextView) findViewById(R.id.desc);
        errorMsg = (EditText) findViewById(R.id.errorMsg);

        downBtn = (Button) findViewById(R.id.downBtn);
        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다운로드 하는 동작 수행
            }
        });

        submitBtn = (Button) findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 오류 보고 하기
                errorMsg.getText();
            }
        });
    }

    public ShowDialog(@NonNull Context context) {
        super(context);
    }
}
