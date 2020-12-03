package com.example.han.adding;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.han.adding.ProjectDetailActivity.scrum_intro;
import static com.example.han.adding.ProjectDetailActivity.scrum_name;

public class ShowDialog extends Dialog {

    Context context;
    TextView scrum_title;
    TextView closeBtn;
    TextView desc;
    EditText errorMsg;
    Button downBtn;
    Button submitBtn;
    String file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_scrum);


        scrum_title = (TextView) findViewById(R.id.scrum_title);
        scrum_title.setText(scrum_name);
        closeBtn = (TextView) findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        desc = (TextView) findViewById(R.id.desc);
        desc.setText(scrum_intro);
        errorMsg = (EditText) findViewById(R.id.errorMsg);

        downBtn = (Button) findViewById(R.id.downBtn);
        downBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 다운로드 하는 동작 수행
                if (file.length() > 0) {
                    context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(file)));
                }
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

    public ShowDialog(@NonNull Context context, String file) {
        super(context);
        this.context = context;
        this.file = file;
    }
}
