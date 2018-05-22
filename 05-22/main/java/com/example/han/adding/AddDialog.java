package com.example.han.adding;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by S on 2018-05-20.
 */

public class AddDialog extends Dialog {

    final String[] state = {"개발전", "개발중", "개발후"};
    Spinner stateSpinner; // 직업군
    ArrayList<String> stateItem;
    AdapterSpinner1 stateAdapter;
    TextView closeBtn;
    EditText title;
    EditText desc;
    Button reset;
    Button exec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_scrum);

        stateSpinner = (Spinner) findViewById(R.id.state);
        stateItem = new ArrayList<>();
        Collections.addAll(stateItem, state);
        stateAdapter = new AdapterSpinner1(getContext(), stateItem);
        stateSpinner.setAdapter(stateAdapter);

        closeBtn = (TextView) findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        title = (EditText) findViewById(R.id.title);
        desc = (EditText) findViewById(R.id.desc);
        reset = (Button) findViewById(R.id.resetBtn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title.setText("");
                desc.setText("");
            }
        });
        exec = (Button) findViewById(R.id.execBtn);
        exec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 서버에 서브 프로젝트 정보적용하기
            }
        });
    }

    public AddDialog(@NonNull Context context) {
        super(context);
    }


}