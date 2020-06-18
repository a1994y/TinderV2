package com.example.tinderv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class Anket_class extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<String> mNameHumans = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anket_class);



    }

    public void onStart() {

        mNameHumans.add("Алена");
        mNameHumans.add("Александр");
        mNameHumans.add("Оксана");
        mNameHumans.add("Андрей");
        mNameHumans.add("Алина");

        initRecyclerView();

        super.onStart();
    }

    private void initRecyclerView(){

        recyclerView = findViewById(R.id.recyclerViewAnket);
        AnketADAPTER adapter = new AnketADAPTER(this, mNameHumans);
        recyclerView.setAdapter(adapter);
        GridLayoutManager manager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(manager);
        adapter.notifyDataSetChanged();

    }

}
