package com.example.ahmed.geologicdatabase;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class pdf extends AppCompatActivity {


    DatabaseReference mRoot;
    StorageReference s ;
    String text, name;
    File localFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf);
        final String parent = getIntent().getStringExtra("type").toString();
        final String ch = getIntent().getStringExtra("value").toString();
        mRoot = FirebaseDatabase.getInstance().getReference().child(parent).child(ch);
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

//        pdfView = findViewById(R.id.pdfView);
//        try {
//            localFile = File.createTempFile("pdf", "pdf");
//        } catch (IOException e) {
//            Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show();
//        }
////       final long MEGABYTE = 10 * 1024 * 1024;
//        final String parent = getIntent().getStringExtra("type").toString();
//        final String ch = getIntent().getStringExtra("value").toString();
//        mRoot = FirebaseDatabase.getInstance().getReference().child(parent).child(ch);
//        mRoot.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                text = dataSnapshot.getValue(String.class);
//                name = text;
//                Toast.makeText(pdf.this, name, Toast.LENGTH_SHORT).show();
//                s = FirebaseStorage.getInstance().getReference().child("pdf").child(name);
//                s.getBytes(MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>()
//                {
//                    @Override
//                    public void onSuccess(byte[] bytes) {
//                        Toast.makeText(pdf.this, "Loading", Toast.LENGTH_SHORT).show();
//                        pdfView.fromBytes(bytes);
//                        Toast.makeText(pdf.this, "Done", Toast.LENGTH_SHORT).show();
//                        // Data for "images/island.jpg" is returns, use this as needed
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        Toast.makeText(pdf.this, "failed", Toast.LENGTH_SHORT).show();
//                        // Handle any errors
//                    }
//                });
//                s.getFile(localFile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
//                        Toast.makeText(pdf.this, "loading", Toast.LENGTH_SHORT).show();
//                        pdfView.fromFile(localFile);
//                        Toast.makeText(pdf.this, "Done", Toast.LENGTH_SHORT).show();
//                        // Local temp file has been created
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception exception) {
//                        // Handle any errors
//                        Toast.makeText(pdf.this, "failed", Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });


}
}
