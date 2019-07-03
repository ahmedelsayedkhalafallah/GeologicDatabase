package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

public class multi extends AppCompatActivity {

    RecyclerView r;
    RecyclerView.Adapter mAdapter;
    String parent, ch,son;
    List<pdfclass> mpdf = new ArrayList<>();
    DatabaseReference mRoot;
    LinearLayoutManager mLayoutManager;
    HashMap<Integer,String> h = new HashMap<Integer, String>();
    public static int c=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi);
        r = findViewById(R.id.list);
        parent = getIntent().getStringExtra("type").toString();
        ch = getIntent().getStringExtra("value").toString();
        mRoot = FirebaseDatabase.getInstance().getReference().child(parent).child(ch);
        mLayoutManager = new LinearLayoutManager(this);
        r.setHasFixedSize(true);
        r.setLayoutManager(mLayoutManager);
        mAdapter = new RecyclerAdapter(mpdf);
        r.setAdapter(mAdapter);
        r.addOnItemTouchListener(
                new RecyclerItemClickListener(this, r ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        son = h.get(position);
                        if(ch.equals("maps"))
                        {
                            Intent intent = new Intent(getApplicationContext(), image.class);
                            intent.putExtra("type", parent);
                            intent.putExtra("value", ch);
                            intent.putExtra("son", son);
                            startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent(getApplicationContext(), viewpdf.class);
                            intent.putExtra("type", parent);
                            intent.putExtra("value", ch);
                            intent.putExtra("son", son);
                            startActivity(intent);
                        }
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );
        mRoot.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                pdfclass p = dataSnapshot.getValue(pdfclass.class);
                mpdf.add(p);
                son =p.getTitle();
                c++;
                h.put(c,son);
                Toast.makeText(multi.this,son, Toast.LENGTH_SHORT).show();
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
    public void load()
    {

    }
}
