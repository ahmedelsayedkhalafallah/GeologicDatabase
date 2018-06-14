package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class elements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elements);
    }

    public void geo(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type",getIntent().getStringExtra("element").toString());
        intent.putExtra("value","geology");
        startActivity(intent);
    }

    public void mineralogy(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type",getIntent().getStringExtra("element").toString());
        intent.putExtra("value","mineralogy");
        startActivity(intent);
    }

    public void geochemistry(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type",getIntent().getStringExtra("element").toString());
        intent.putExtra("value","geochemistry");
        startActivity(intent);
    }

    public void physical(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type",getIntent().getStringExtra("element").toString());
        intent.putExtra("value","physical");
        startActivity(intent);
    }

    public void industrial(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type",getIntent().getStringExtra("element").toString());
        intent.putExtra("value","industrial");
        startActivity(intent);
    }

    public void economics(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type",getIntent().getStringExtra("element").toString());
        intent.putExtra("value","economics");
        startActivity(intent);
    }

    public void lectures(View view) {
        Intent intent = new Intent(this, multi.class);
        intent.putExtra("type",getIntent().getStringExtra("element").toString());
        intent.putExtra("value","lectures");
        startActivity(intent);
    }

    public void videos(View view) {
        Intent intent = new Intent(this, multi.class);
        intent.putExtra("type",getIntent().getStringExtra("element").toString());
        intent.putExtra("value","videos");
        startActivity(intent);
    }
}
