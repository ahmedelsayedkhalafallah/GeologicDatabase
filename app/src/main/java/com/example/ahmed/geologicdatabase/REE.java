package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class REE extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ree);
    }

    public void openN(View view) {
        Intent intent = new Intent(this, elements.class);
        intent.putExtra("element","niabium");
        startActivity(intent);
    }

    public void openTa(View view) {
        Intent intent = new Intent(this, elements.class);
        intent.putExtra("element","tantalum");
        startActivity(intent);
    }

    public void openTi(View view) {
        Intent intent = new Intent(this, elements.class);
        intent.putExtra("element","tin");
        startActivity(intent);
    }

    public void openTu(View view) {
        Intent intent = new Intent(this, elements.class);
        intent.putExtra("element","tungesten");
        startActivity(intent);
    }

    public void openU(View view) {
        Intent intent = new Intent(this, elements.class);
        intent.putExtra("element","uranium");
        startActivity(intent);
    }
}
