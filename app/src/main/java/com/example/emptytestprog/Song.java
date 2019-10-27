package com.example.emptytestprog;

import android.support.annotation.NonNull;

class Song {

    String id;
    String room_id;
    String service_id;
    int state;

    public Song(String id, String room_id, String service_id, int state) {
        this.id = id;
        this.room_id = room_id;
        this.service_id = service_id;
        this.state = state;
    }

    @NonNull
    @Override
    public String toString() {
        return "Song " + id + " (" + service_id + ")";
    }
}


