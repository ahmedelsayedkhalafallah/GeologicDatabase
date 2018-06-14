package com.example.ahmed.geologicdatabase;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.io.File;

public class viewpdf extends AppCompatActivity {

    DatabaseReference mRoot;
    StorageReference s ;
    String text, name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        String parent = getIntent().getStringExtra("type").toString();
        String ch = getIntent().getStringExtra("value").toString();
        String son = getIntent().getStringExtra("son").toString();
        mRoot = FirebaseDatabase.getInstance().getReference().child(parent).child(ch).child(son);
        mRoot.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                text = dataSnapshot.child("url").getValue(String.class);
                name = dataSnapshot.child("name").getValue(String.class);
                File file = new File("/storage/sdcard0/Download", name);
                if(file.exists())
                {
                    Uri path = Uri.fromFile(file);
                    Intent pdfOpenintent = new Intent(Intent.ACTION_VIEW);
                    pdfOpenintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    pdfOpenintent.setDataAndType(path, "application/pdf");
                    try {
                        startActivity(pdfOpenintent);
                    }
                    catch (ActivityNotFoundException e) {
                        Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                    }
                }

                else{
                    file = new File("/storage/emulated/0/Download", name);
                    if(file.exists())
                    {
                        Uri path = Uri.fromFile(file);
                        Intent pdfOpenintent = new Intent(Intent.ACTION_VIEW);
                        pdfOpenintent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        pdfOpenintent.setDataAndType(path, "application/pdf");
                        try {
                            startActivity(pdfOpenintent);
                        }
                        catch (ActivityNotFoundException e) {
                            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {
                        Uri uri = Uri.parse(text);
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                        finish();
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
