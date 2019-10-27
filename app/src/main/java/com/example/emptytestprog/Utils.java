package com.example.emptytestprog;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;




public class Utils {


    public static ArrayList<Song> requestSongsList(String room_id) {
        String server = "http://vladazavr.pythonanywhere.com/";
        String url = server + "/get_songs/" + room_id;

        try {
            String jsonStringResponse = (new HttpHandler()).makeServerCall(url);
            if (jsonStringResponse != null) {

                JSONObject jsonObject = new JSONObject(jsonStringResponse);
                JSONArray songs = jsonObject.getJSONArray("songs");

                ArrayList<Song> songs_array = new ArrayList<>();

                for (int i = 0; i < songs.length(); i++) {
                    String song_id = songs.getJSONObject(i).getString("id");
                    String service_id = songs.getJSONObject(i).getString("service_id");
                    String song_room_id = songs.getJSONObject(i).getString("room_id");
                    int state = Integer.parseInt(songs.getJSONObject(i).getString("state"));

                    Song song_mode = new Song(song_id, song_room_id, service_id, state);
                    songs_array.add(song_mode);
                }
                return songs_array;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static Room addRoom() {
        String server = "http://vladazavr.pythonanywhere.com/";
        String url = server + "/add_room/";

        try {
            String jsonStringResponse = (new HttpHandler()).makeServerCall(url);
            if (jsonStringResponse != null) {

                JSONObject jsonObject = new JSONObject(jsonStringResponse);
                String room_id = jsonObject.getString("room_id");
                String access_code = jsonObject.getString("access_code");

                Room room = new Room(room_id, access_code);

                return room;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void changeState(String song_id, int new_state) {
        String server = "http://vladazavr.pythonanywhere.com";
        String url = server + "/update_state/" + song_id + "/" + String.valueOf(new_state);
        String jsonStringResponse = (new HttpHandler()).makeServerCall(url);
    }

    public static Room connect(String url) {
        String server = "http://vladazavr.pythonanywhere.com/";


        Log.e("MTS", "!!");
        try {
            String jsonStringResponse = (new HttpHandler()).makeServerCall(url);
            Log.e("MTS", jsonStringResponse);
            if (jsonStringResponse != null) {

                JSONObject jsonObject = new JSONObject(jsonStringResponse);
                String result_room_id = jsonObject.getString("room_id");
                String result_access_code = jsonObject.getString("access_code");

                Room room = new Room(result_room_id, result_access_code);

                return room;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean suggest(String room_id, String service_id) {
        String server = "http://vladazavr.pythonanywhere.com/";
        String url = server + "/suggest/" + room_id + "/" + service_id;

        String jsonStringResponse = (new HttpHandler()).makeServerCall(url);
        if (jsonStringResponse != null) {
            return true;
        }

        return false;
    }


    public static void SaveId(String id, Context context){
        SharedPreferences sharedPref = context.getSharedPreferences(
                "MTS_Music", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("room_id", id);
        editor.apply();
    }
    public static String  DownId( Context context){

        SharedPreferences sharedPref = context.getSharedPreferences(
                "MTS_Music", Context.MODE_PRIVATE);

        return sharedPref.getString("room_id", "6");
    }

}