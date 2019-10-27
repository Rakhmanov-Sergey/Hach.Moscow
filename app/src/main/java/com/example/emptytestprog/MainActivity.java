package com.example.emptytestprog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.audiofx.BassBoost;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class MainActivity extends AppCompatActivity{

    Button connect, add, add_song, list_songs, btn_playlist;
    public static TextView resutTexeView;
    Button scan_btn;
    Activity activity;
    Handler myHandler = null;
    ImageView qr;
    public static String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connect =(Button)findViewById(R.id.btn_connect);
        add =(Button)findViewById(R.id.btn_add);
        add_song =(Button)findViewById(R.id.btn_add_song);
        list_songs =(Button)findViewById(R.id.btn_list_songs);
        resutTexeView =(TextView)findViewById(R.id.result_text);
        scan_btn =(Button)findViewById(R.id.btn_QR);
        btn_playlist =(Button)findViewById(R.id.btn_playlist);
        qr = (ImageView)findViewById(R.id.image_qr);
        activity = this;

        scan_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getApplicationContext(),ScanQRCode.class),1);
                qr.setVisibility(View.INVISIBLE);
            }
        });

        btn_playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(getApplicationContext(),Playlist.class));
                Intent intent = new Intent(activity, Playlist.class);
                startActivity(intent);
                qr.setVisibility(View.INVISIBLE);
            }
        });


        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ConnectTask(resutTexeView, url, activity).execute();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AddTask(resutTexeView, qr, activity).execute();
            }
        });

//        add_song.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String room_id = Utils.DownId(activity);
//                new AddSongTask(resutTexeView, room_id).execute();
//                qr.setVisibility(View.INVISIBLE);
//            }
//        });


        list_songs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String room_id = Utils.DownId(activity);
//                new ListSongsTask(resutTexeView, room_id).execute();

                Intent intent = new Intent(activity, ListActivity.class);
                startActivity(intent);
                qr.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String url=data.getStringExtra("url");
                                new ConnectTask(resutTexeView, url, this).execute();
            }

        }
    }
}
