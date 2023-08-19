package com.example.app_networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {
    private ArrayList<Mountains> mountain = new ArrayList<Mountains>();
    private RecyclerViewAdapter adapter;

    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
    private final String JSON_File = "mountains.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new JsonTask(this).execute(JSON_URL);
    }
    @Override
    public void onPostExecute(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountains>>() {}.getType();

        mountain = gson.fromJson(json, type);
        Log.d( "==>", json);

        // type cast from ArrayList<Mountain> to ArrayList<RecyclerViewItem>
        ArrayList<RecyclerViewItem> items = new ArrayList<>();
        for(Mountains m : mountain ){
            items.add(new RecyclerViewItem(m.getName()));
            Log.d("ITEMS_INMOUNTAIN", "" + items.get(items.size()-1).getName());
        }

        adapter = new RecyclerViewAdapter(this, items, new RecyclerViewAdapter.OnClickListener() {
            @Override
            public void onClick(RecyclerViewItem item) {
            }
        });

        adapter.refreshItems(items);
        adapter.notifyDataSetChanged();

        RecyclerView recycler_view = findViewById(R.id.recyclerView);
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(adapter);
    }
}