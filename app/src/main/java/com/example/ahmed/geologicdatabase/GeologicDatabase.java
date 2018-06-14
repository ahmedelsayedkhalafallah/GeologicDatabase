package com.example.ahmed.geologicdatabase;

import android.app.Application;
import android.support.annotation.NonNull;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class GeologicDatabase extends Application {

    @Override
    public void onCreate() {

        super.onCreate();
    }
    public static void modifySingle(String parent, String ch, String text){

        DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference().child(parent).child(ch);
        mRoot.setValue(text);

    }
    public static void addChild(String parent, String ch, String name,String value){

        DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference().child(parent).child(ch);
        mRoot.child(name).setValue(value);

    }
    public static void updateChild(String parent, String ch, final String name, final String value,String title){
        DatabaseReference mRoot = FirebaseDatabase.getInstance().getReference().child(parent).child(ch).child(title);
        mRoot.child(name).setValue(value);


    }

}
