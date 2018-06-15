package com.example.han.adding;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnalActivity extends AppCompatActivity {
    Button x;
    Button analyze;
    Button scrum;
    Fragment analyzeFragment;
    Fragment scrumFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anal);
        x = (Button)findViewById(R.id.x);
        analyze = (Button)findViewById(R.id.analyze);
        scrum = (Button)findViewById(R.id.scrum);
        analyzeFragment = new Fragment();
        scrumFragment = new Fragment();
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        analyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment, analyzeFragment, "analyze").commit();

            }
        });
        scrum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment, scrumFragment, "scrum").commit();
            }
        });

    }
}
