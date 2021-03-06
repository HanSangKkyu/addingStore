package com.example.han.adding;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaFunctionException;
import com.amazonaws.mobileconnectors.lambdainvoker.LambdaInvokerFactory;
import com.amazonaws.regions.Regions;
import com.squareup.picasso.Picasso;

public class ProjectDetailActivity extends AppCompatActivity {
    static final int COUNT = 15;//자바 상수 선언
    Button[] bt1;
    Button[] bt2;
    Button[] bt3;

    RatingBar reviewPoint;
    EditText reviewText;
    Button reviewButton;
    ProgressBar progressBar;

    TextView kind;
    TextView pname;
    ImageView img;
    TextView intro;
    TextView deadline;
    TextView current;
    TextView fundgoal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_detail);


        reviewPoint = (RatingBar) findViewById(R.id.reviewPoint);
        reviewText = (EditText) findViewById(R.id.reviewText);
        reviewButton = (Button) findViewById(R.id.reviewButton);
        progressBar = (ProgressBar) findViewById(R.id.progress);


        kind = (TextView) findViewById(R.id.kind);
        pname = (TextView) findViewById(R.id.pName);
        img = (ImageView) findViewById(R.id.img);
        intro = (TextView) findViewById(R.id.intro);
        deadline = (TextView) findViewById(R.id.deadline);
        current = (TextView) findViewById(R.id.current);
        fundgoal = (TextView) findViewById(R.id.fundGoal);


        progressBar.setProgress(25);

        // 평가, 댓글에 작성하기 기능 구현

        initButton();

        Intent intent = getIntent();
        int projNum = intent.getIntExtra("projNum", -1);
        if (projNum != -1) {
            CognitoCachingCredentialsProvider cognitoProvider = new CognitoCachingCredentialsProvider(
                    getApplicationContext(),
                    "ap-northeast-2:a03da40d-6e0a-40f9-9510-6a5fb5c4a37a", // 자격 증명 풀 ID
                    Regions.AP_NORTHEAST_2 // 리전
            );
            LambdaInvokerFactory factory = new LambdaInvokerFactory(this.getApplicationContext(),
                    Regions.AP_NORTHEAST_2, cognitoProvider);

            final ShowingProjectDetailInterface showingProjectDetailInterface = factory.build(ShowingProjectDetailInterface.class);

            ProjectDetailRequestClass request = new ProjectDetailRequestClass(projNum);

            new AsyncTask<ProjectDetailRequestClass, Void, ProjectDetailResponseClass>() {
                @Override
                protected ProjectDetailResponseClass doInBackground(ProjectDetailRequestClass... params) {
                    // invoke "echo" method. In case it fails, it will throw a
                    // LambdaFunctionException.
                    try {
                        return showingProjectDetailInterface.addingShowProjectDetail(params[0]);
                    } catch (LambdaFunctionException lfe) {
                        Log.e("Tag", "Failed to invoke echo", lfe);
                        return null;
                    }
                }

                @Override
                protected void onPostExecute(ProjectDetailResponseClass result) {
                    if (result == null) {
                        return;
                    }

                    if (result.isState()) {
                        kind.setText(result.getCategory());
                        pname.setText(result.getPname());
                        Picasso.with(getApplicationContext())
                                .load(result.getImage())
                                .into(img);
                        intro.setText(result.getIntroduction());
                        deadline.setText("프로젝트 마감일 : " + result.getDeadline());
                        current.setText("현재 모금액 : " + result.getCurrent());
                        fundgoal.setText("목표 모금액 : " + result.getFundgoal());

                    } else {
                        Toast.makeText(getApplicationContext(), result.getStr(), Toast.LENGTH_LONG).show();
                    }
                }
            }.execute(request);
        }


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
