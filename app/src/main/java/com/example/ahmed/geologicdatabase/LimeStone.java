package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LimeStone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_limestone);
    }

    public void intro(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","limestone");
        intent.putExtra("value","introduction");
        startActivity(intent);
    }

    public void def(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","limestone");
        intent.putExtra("value","definition");
        startActivity(intent);
    }

    public void comp(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","limestone");
        intent.putExtra("value","composition");
        startActivity(intent);
    }

    public void types(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","limestone");
        intent.putExtra("value","types");
        startActivity(intent);
    }

    public void lime(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","limestone");
        intent.putExtra("value","lime");
        startActivity(intent);
    }

    public void mining(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","limestone");
        intent.putExtra("value","mining");
        startActivity(intent);
    }

    public void videos(View view) {
        Intent intent = new Intent(this, video.class);
        intent.putExtra("type","limestone");
        intent.putExtra("value","videos");
        startActivity(intent);
    }

    public void feasability(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","limestone");
        intent.putExtra("value","feasability study of ls quarry");
        startActivity(intent);
    }

    public void tech(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","limestone");
        intent.putExtra("value","technology");
        startActivity(intent);
    }

    public void products(View view) {
        Intent intent = new Intent(this, pdf.class);
        intent.putExtra("type","limestone");
        intent.putExtra("value","products");
        startActivity(intent);
    }
}
