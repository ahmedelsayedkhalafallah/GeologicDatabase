package com.example.ahmed.geologicdatabase.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ahmed.geologicdatabase.R;
import com.example.ahmed.geologicdatabase.pdfclass;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahmed on 24/05/18.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>{
    private List<pdfclass> mpdfclass;
    public RecyclerAdapter(List<pdfclass> mpdfclass)
    {

        this.mpdfclass = mpdfclass;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        pdfclass p = mpdfclass.get(position);
        holder.t.setText(p.getTitle());
        holder.n.setText(p.getName());
        holder.u.setText(p.getUrl());
    }

    @Override
    public int getItemCount() {
        return mpdfclass.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        public TextView t ,n,u;
        public RecyclerViewHolder(View view)
        {

            super(view);
            t = view.findViewById(R.id.rr);
            n = view.findViewById(R.id.name);
            u = view.findViewById(R.id.url);
        }
    }

}
