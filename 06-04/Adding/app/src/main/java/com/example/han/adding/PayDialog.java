package com.example.han.adding;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PayDialog extends Dialog {


    TextView closeBtn;
    TextView nowCash;
    TextView chargeCash;
    TextView resultCash;

    EditText payPrice;
    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alert_pay);


        closeBtn = (TextView) findViewById(R.id.closeBtn);
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        nowCash = (TextView) findViewById(R.id.nowCash);
        chargeCash = (TextView) findViewById(R.id.chargeCash);
        resultCash = (TextView) findViewById(R.id.resultCash);
        payPrice = (EditText) findViewById(R.id.payPrice);
        confirmBtn = (Button) findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 이 프로젝트의 모금액 +payPrice.getText();
            }
        });

    }

    public PayDialog(@NonNull Context context) {
        super(context);
    }
}
