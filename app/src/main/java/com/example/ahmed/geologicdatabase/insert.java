package com.example.ahmed.geologicdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class insert extends AppCompatActivity {
    Button done ;
    EditText editText , editText2;
    String parent,ch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        editText = findViewById(R.id.editText);
        editText2 = findViewById(R.id.editText2);
        Toast.makeText(this, parent, Toast.LENGTH_SHORT).show();
        Toast.makeText(this, ch, Toast.LENGTH_SHORT).show();
    }

    public void add(View view) {
        parent = getIntent().getStringExtra("type").toString();
        ch = getIntent().getStringExtra("value").toString();
        String name = editText.getText().toString();
        String value = editText2.getText().toString();
        GeologicDatabase.addChild(parent,ch,name,value);
        finish();
    }
}
