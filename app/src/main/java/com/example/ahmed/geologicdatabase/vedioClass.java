package com.example.ahmed.geologicdatabase;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class vedioClass extends RecyclerView.Adapter<vedioClass.RecyclerViewHolder>{
    private List<String> mpdfclass;
    private List<String> mmm;
    public vedioClass(List<String> mpdfclass,List<String>mmm)
    {

        this.mpdfclass = mpdfclass;
        this.mmm = mmm;
    }

    @Override
    public vedioClass.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new vedioClass.RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(vedioClass.RecyclerViewHolder holder, int position) {
        String p = mpdfclass.get(position);
        holder.t.setText(p);

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
