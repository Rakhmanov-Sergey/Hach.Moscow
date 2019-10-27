package com.example.emptytestprog;

import android.support.annotation.NonNull;

class Room {

    String id;
    String access_code;

    public Room(String id, String access_code) {
        this.id = id;
        this.access_code = access_code;
    }

    @NonNull
    @Override
    public String toString() {
        return "Room " + id + " (" + access_code + ")";
    }
}
