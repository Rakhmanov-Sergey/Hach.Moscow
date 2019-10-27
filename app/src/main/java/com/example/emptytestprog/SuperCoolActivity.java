package com.example.emptytestprog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class SuperCoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_cool);

        RecyclerView horizontalRecyclerView = (RecyclerView) findViewById(R.id.horizontalRecyclerView);
        RecyclerView verticalRecyclerView = (RecyclerView) findViewById(R.id.verticalRecyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        horizontalRecyclerView.setLayoutManager(llm);

        LinearLayoutManager vertllm = new LinearLayoutManager(this);
        verticalRecyclerView.setLayoutManager(vertllm);
    }
}
