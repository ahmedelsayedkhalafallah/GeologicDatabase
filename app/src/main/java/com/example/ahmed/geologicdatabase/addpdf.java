package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.Random;

public class addpdf extends AppCompatActivity {
    TextView t;
    StorageReference mpdf;
    StorageReference dp;
    EditText title;
    String tt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpdf);
        t = findViewById(R.id.path);
        title = findViewById(R.id.title);
        mpdf = FirebaseStorage.getInstance().getReference();
    }
    public void choose(View view) {

        Intent gallary = new Intent();
        gallary.setAction(Intent.ACTION_GET_CONTENT);
        gallary.setType("application/pdf");
        startActivityForResult(gallary,1212);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1212:
                if (resultCode == RESULT_OK) {
                    String FilePath = data.getDataString();
                    t.setText(FilePath);
                    Uri pdfuri = data.getData();
                    final String name = random() + ".pdf";
                    dp = mpdf.child("pdf").child(name);
                    UploadTask uploadTask = dp.putFile(pdfuri);
                    Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                        @Override
                        public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                            if (!task.isSuccessful()) {
                                throw task.getException();
                            }

                            // Continue with the task to get the download URL
                            return dp.getDownloadUrl();
                        }
                    }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                        @Override
                        public void onComplete(@NonNull Task<Uri> task) {
                            if (task.isSuccessful()) {
                                tt = title.getText().toString();
                                Uri downloadUri = task.getResult();
                                String download_url = downloadUri.toString();
                                String parent = getIntent().getStringExtra("type").toString();
                                String ch = getIntent().getStringExtra("value").toString();
                                GeologicDatabase.updateChild(parent, ch, "url",download_url,tt);
                                GeologicDatabase.updateChild(parent,ch,"name",name,tt);
                                GeologicDatabase.updateChild(parent,ch,"title",tt,tt);
                                Toast.makeText(addpdf.this, download_url, Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                // Handle failures
                                // ...
                            }
                        }
                    });

                }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public static String random() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}
