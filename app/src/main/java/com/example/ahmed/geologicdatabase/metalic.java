package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class metalic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metalic);
    }

    public void openGold(View view) {
        Intent intent = new Intent(this, middle.class);
        intent.putExtra("input","gold");
        startActivity(intent);
    }

    public void openREE(View view) {
        Intent intent = new Intent(this, REE.class);
        startActivity(intent);
    }
}
