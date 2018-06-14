package com.example.ahmed.geologicdatabase;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class text extends AppCompatActivity {
    String text ;
    DatabaseReference mRoot;
    TextView textView , ti;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        textView = findViewById(R.id.content);
        ti = findViewById(R.id.title);
        text = "";
        final String parent = getIntent().getStringExtra("type").toString();
        final String ch = getIntent().getStringExtra("value").toString();
        ti.setText(ch);
        mRoot = FirebaseDatabase.getInstance().getReference().child(parent).child(ch);
        mRoot.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text = dataSnapshot.getValue(String.class);
                textView.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
