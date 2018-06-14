package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class modifymulti extends AppCompatActivity {
    Button add;
    String parent, ch,p,c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifymulti);
        parent = getIntent().getStringExtra("type").toString();
        ch = getIntent().getStringExtra("value").toString();
        Toast.makeText(this, c, Toast.LENGTH_SHORT).show();
        add = findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ch.equals("maps")) {
                    Intent intent = new Intent(getApplicationContext(), addImage.class);
                    intent.putExtra("type",parent);
                    intent.putExtra("value",ch);
                    startActivity(intent);
                }
                else if(ch.equals("videos"))
                {
                    Intent intent = new Intent(getApplicationContext(), insert.class);
                    intent.putExtra("type",parent);
                    intent.putExtra("value",ch);
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(getApplicationContext(), addpdf.class);
                    intent.putExtra("type",parent);
                    intent.putExtra("value",ch);
                    startActivity(intent);
                }
            }
        });
    }


    public void delete(View view) {
            Intent intent = new Intent(this, delete.class);
            intent.putExtra("type",parent);
            intent.putExtra("value",ch);
            startActivity(intent);


    }
}
