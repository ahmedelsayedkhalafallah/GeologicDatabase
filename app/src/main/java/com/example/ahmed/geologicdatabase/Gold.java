package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Gold extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gold);
    }

    public void intro(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","gold");
        intent.putExtra("value","introduction");
        startActivity(intent);
    }

    public void physical(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","gold");
        intent.putExtra("value","physical");
        startActivity(intent);
    }

    public void origin(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","gold");
        intent.putExtra("value","origin");
        startActivity(intent);
    }

    public void structure(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","gold");
        intent.putExtra("value","structure");
        startActivity(intent);
    }

    public void maps(View view) {
        Intent intent = new Intent(this, multi.class);
        intent.putExtra("type","gold");
        intent.putExtra("value","maps");
        startActivity(intent);
    }

    public void lectures(View view) {
        Intent intent = new Intent(this, multi.class);
        intent.putExtra("type","gold");
        intent.putExtra("value","lectures");
        startActivity(intent);
    }

    public void videos(View view) {
        Intent intent = new Intent(this, video.class);
        intent.putExtra("type","gold");
        intent.putExtra("value","videos");
        startActivity(intent);
    }

    public void occurences(View view) {
        Intent intent = new Intent(this, multi.class);
        intent.putExtra("type","gold");
        intent.putExtra("value","occurences");
        startActivity(intent);
    }
}
