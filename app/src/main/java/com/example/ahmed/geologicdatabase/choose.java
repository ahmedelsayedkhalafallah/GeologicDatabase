package com.example.ahmed.geologicdatabase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class choose extends AppCompatActivity {

    Spinner types,ele ;
    String Tlist[],Glist[],Llist[],TAlist[],Nlist[],TIlist[],TUlist[],Ulist[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        types = findViewById(R.id.type);
        ele = findViewById(R.id.ele);
        Tlist = new String[]{"gold","limestone","tantalum","niabium","tin","tungesten","uranium"};
        Glist = new String[]{"introduction","physical","origin","structure","maps","lectures","videos","occurences"};
        Llist = new String[]{"introduction","definition","composition","types","limestone in egypt","mining","videos","feasability study of ls quarry","technology of production","products"};
        TAlist = new String[]{"geology","mineralogy","geochemistry","physical","industrial","economics","lectures","videos"};
        Nlist = new String[]{"geology","mineralogy","geochemistry","physical","industrial","economics","lectures","videos"};
        TIlist = new String[]{"geology","mineralogy","geochemistry","physical","industrial","economics","lectures","videos"};
        TUlist = new String[]{"geology","mineralogy","geochemistry","physical","industrial","economics","lectures","videos"};
        Ulist = new String[]{"geology","mineralogy","geochemistry","physical","industrial","economics","lectures","videos"};
        ArrayAdapter typesAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,Tlist);
        types.setAdapter(typesAdapter);




       types.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               if(types.getSelectedItem().equals("gold"))
               {
                   ArrayAdapter goldAdapter = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Glist);
                   ele.setAdapter(goldAdapter);
               }
               else if(types.getSelectedItem().equals("limestone"))
               {
                   ArrayAdapter goldAdapter = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Llist);
                   ele.setAdapter(goldAdapter);
               }
               else if(types.getSelectedItem().equals("tantalum"))
               {
                   ArrayAdapter goldAdapter = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,TAlist);
                   ele.setAdapter(goldAdapter);
               }
               else if(types.getSelectedItem().equals("niabium"))
               {
                   ArrayAdapter goldAdapter = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Nlist);
                   ele.setAdapter(goldAdapter);
               }
               else if(types.getSelectedItem().equals("tin"))
               {
                   ArrayAdapter goldAdapter = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,TIlist);
                   ele.setAdapter(goldAdapter);
               }
               else if(types.getSelectedItem().equals("tungesten"))
               {
                   ArrayAdapter goldAdapter = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,TUlist);
                   ele.setAdapter(goldAdapter);
               }
               else if(types.getSelectedItem().equals("uranium"))
               {
                   ArrayAdapter goldAdapter = new ArrayAdapter(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Ulist);
                   ele.setAdapter(goldAdapter);
               }
           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView) {

           }
       });

    }

    public void modify(View view) {
        String firstselected = types.getSelectedItem().toString();
        String secondselected = ele.getSelectedItem().toString();
        if(firstselected =="gold"&&(secondselected=="introduction"||secondselected =="physical"||secondselected =="origin"||secondselected == "structure"))
        {
            Intent intent = new Intent(this, modifypdf.class);
            intent.putExtra("type",firstselected);
            intent.putExtra("value",secondselected);
            startActivity(intent);
        }
        else
        {
            if(firstselected=="gold") {
                Intent intent = new Intent(this, modifymulti.class);
                intent.putExtra("type", firstselected);
                intent.putExtra("value", secondselected);
                startActivity(intent);
            }
        }
        if(firstselected=="limestone"&&(secondselected =="introduction"||secondselected =="definition"))
        {
            Intent intent = new Intent(this, modifypdf.class);
            intent.putExtra("type",firstselected);
            intent.putExtra("value",secondselected);
            startActivity(intent);
        }
        else if(firstselected=="limestone"&&secondselected=="videos")
        {
            Intent intent = new Intent(this, modifymulti.class);
            intent.putExtra("type",firstselected);
            intent.putExtra("value",secondselected);
            startActivity(intent);
        }
        else
        {
            if(firstselected == "limestone") {
                Intent intent = new Intent(this, modifypdf.class);
                intent.putExtra("type", firstselected);
                intent.putExtra("value", secondselected);
                startActivity(intent);
            }
        }
        if((firstselected =="tantalum"||firstselected=="niabium"||firstselected=="tin"||firstselected=="tungesten"||firstselected=="uranium"))
        {
            if(secondselected =="physical"||secondselected=="economics")
            {
                Intent intent = new Intent(this, modifypdf.class);
                intent.putExtra("type",firstselected);
                intent.putExtra("value",secondselected);
                startActivity(intent);
            }
            else if(secondselected =="lectures"||secondselected=="videos")
            {
                Intent intent = new Intent(this, modifymulti.class);
                intent.putExtra("type",firstselected);
                intent.putExtra("value",secondselected);
                startActivity(intent);
            }
            else
            {
                Intent intent = new Intent(this, modifypdf.class);
                intent.putExtra("type",firstselected);
                intent.putExtra("value",secondselected);
                startActivity(intent);
            }
        }
    }
}
