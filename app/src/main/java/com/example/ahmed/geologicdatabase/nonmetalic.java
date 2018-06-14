package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class nonmetalic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonmetalic);
    }

    public void openlime(View view) {
        Intent intent = new Intent(this, middle.class);
        intent.putExtra("input","lime");
        startActivity(intent);
    }
}
