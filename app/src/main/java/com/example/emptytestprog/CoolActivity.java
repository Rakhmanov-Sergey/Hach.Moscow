package com.example.emptytestprog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class CoolActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        RecyclerView horizontalRecyclerView = (RecyclerView) findViewById(R.id.horizontalRecyclerView);
        RecyclerView verticalRecyclerView = (RecyclerView) findViewById(R.id.verticalRecyclerView);

        LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        horizontalRecyclerView.setLayoutManager(llm);

        LinearLayoutManager vertllm = new LinearLayoutManager(this);
        horizontalRecyclerView.setLayoutManager(vertllm);

//        val adapterH = Adapter(this,Type.HORIZONTAL,  DiffUtil())
//        adapterH.submitList(getHorizontalElements())
//        horizontalRecyclerView.adapter = adapterH

//        val adapterV = Adapter(this,Type.VERTICAL,  DiffUtil())
//        adapterV.submitList(getVerticalElements())
//        verticalRecyclerView.adapter = adapterV
    }


//private fun getHorizontalElements(): List<Item> {
//        return mutableListOf(
//        Item("Вечеринка", "#D9F812"),
//        Item("Ночной Deep", "#B312F8"),
//        Item("Trap Music", "#1287F8")
//        )
//        }
//
//private fun getVerticalElements(): List<Item> {
//        return mutableListOf(
//        Item("Популярные хиты", "#F85E12"),
//        Item("Новая музыка", "#B312F8"),
//        Item("Музыка из фильмов", "#9812F8"),
//        Item("Музыка из сериалов", "#12BCF8")
//        )
//        }
//        }
}