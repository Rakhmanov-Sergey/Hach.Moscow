package com.example.emptytestprog;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    Activity activity;
    TextView song1, song2, song3, song4;
    ImageView image1, image2, image3, image4;
    static String song1_id = "0";
    static String song2_id = "0";
    static String song3_id = "0";
    static String song4_id = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        song1 = (TextView) findViewById(R.id.textView11);
        song2 = (TextView) findViewById(R.id.textView12);
        song3 = (TextView) findViewById(R.id.textView13);
        song4 = (TextView) findViewById(R.id.textView14);
        image1 = (ImageView) findViewById(R.id.imageView11);
        image2 = (ImageView) findViewById(R.id.imageView12);
        image3 = (ImageView) findViewById(R.id.imageView13);
        image4 = (ImageView) findViewById(R.id.imageView14);
        Button refresh = (Button)findViewById(R.id.btn_refresh);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateStateTask(song1, song1_id).execute();
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateStateTask(song2, song2_id).execute();
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateStateTask(song3, song3_id).execute();
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateStateTask(song4, song4_id).execute();
            }
        });

        String room_id = Utils.DownId(this);
        new ListSongsTask(song1, song2, song3, song4, image1, image2, image3, image4, room_id).execute();

        refresh.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String room_id = Utils.DownId(this);
        new ListSongsTask(song1, song2, song3, song4, image1, image2, image3, image4, room_id).execute();
    }
}
