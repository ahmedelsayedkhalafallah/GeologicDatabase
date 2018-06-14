package com.example.ahmed.geologicdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class modifysingle extends AppCompatActivity {

    Button done ;
    EditText editText;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifysingle);
        done = findViewById(R.id.done);
        editText = findViewById(R.id.content);
        textView = findViewById(R.id.title);
        textView.setText(getIntent().getStringExtra("value").toString());
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String parent = getIntent().getStringExtra("type").toString();
                String ch = getIntent().getStringExtra("value").toString();
                String text = editText.getText().toString();
                GeologicDatabase.modifySingle(parent,ch,text);
                finish();

            }
        });
    }
}
