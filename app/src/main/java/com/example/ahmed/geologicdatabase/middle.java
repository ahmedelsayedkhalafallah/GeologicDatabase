package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class middle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);
    }

    public void openGeo(View view) {
        if(getIntent().getStringExtra("input").toString().equals("lime"))
        {
            Intent intent = new Intent(this, LimeStone.class);
            startActivity(intent);
        }
        else if(getIntent().getStringExtra("input").toString().equals("gold"))
        {
            Intent intent = new Intent(this, Gold.class);
            startActivity(intent);
        }
    }
}
