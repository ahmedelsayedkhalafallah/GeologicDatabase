package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmed.geologicdatabase.adapter.RecyclerAdapter;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class video extends AppCompatActivity {

    RecyclerView r;
    RecyclerView.Adapter mAdapter;
    String parent, ch,son;
    List<String> mpdf = new ArrayList<>();
    List<String> mmm = new ArrayList<>();
    DatabaseReference mRoot;
    LinearLayoutManager mLayoutManager;
    TextView t ;
    HashMap<Integer,String> h = new HashMap<Integer, String>();
    public static int c=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        r = findViewById(R.id.list);

        parent = getIntent().getStringExtra("type").toString();
        ch = getIntent().getStringExtra("value").toString();
        mRoot = FirebaseDatabase.getInstance().getReference().child(parent).child(ch);
        mLayoutManager = new LinearLayoutManager(this);
        r.setHasFixedSize(true);
        r.setLayoutManager(mLayoutManager);
        mAdapter = new vedioClass(mpdf,mmm);
        r.setAdapter(mAdapter);

        r.addOnItemTouchListener(
                new RecyclerItemClickListener(this, r ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        son = h.get(position);
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(son)));

                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
        mRoot.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                String p = dataSnapshot.getValue(String.class);
                String n = dataSnapshot.getKey();
                mpdf.add(n);
                son =p;
                c++;
                h.put(c,p);
                Toast.makeText(getApplicationContext(),son, Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
