package com.example.johnwolfe.relearnfirebase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class ToDoHome extends AppCompatActivity {
    private static final String TAG = "ToDoHome";
    private static final int NUM_COLUMNS = 2;

    ArrayList<String> noteImages = new ArrayList<>();
    ArrayList<String> noteTitles = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CreateNote.class);
                startActivity(intent);
            }
        });

        initImageBitmaps();
    }

    public void initImageBitmaps(){
        noteImages.add("https://image.winudf.com/v2/image/Y29tLnBvcnRpZXJpYWhtYWQuQmFsaUlzbGFuZC5CYWxpSW5kb25lc2lhLkJhbGkuQmFsaVdhbGxwYXBlcl9zY3JlZW5fOV9pZ3dneGlxbA/screen-9.jpg?h=355&fakeurl=1&type=.jpg");
        noteImages.add("https://www.exceptionalvillas.com/blog/wp-content/uploads/2018/09/weather-in-the-dominican-republic.jpg");
        noteImages.add("https://cdn-image.travelandleisure.com/sites/default/files/styles/1600x1000/public/1460561776/valley-dawn-ElCapitan0416.jpg?itok=viLhgKap");
        noteImages.add("https://cdn.japantimes.2xx.jp/wp-content/uploads/2017/10/n-tokyo-a-20171013-870x581.jpg");
        noteImages.add("https://media-cdn.tripadvisor.com/media/photo-s/04/b0/45/d5/fountains-at-waterway.jpg");

        noteTitles.add("Bali");
        noteTitles.add("Dominican Republic");
        noteTitles.add("El Capitan");
        noteTitles.add("Tokyo");
        noteTitles.add("The Woodlands");

        initRecyclerView();
    }

    public void initRecyclerView() {
        // Inside content_to_do_home
        RecyclerView recyclerView = findViewById(R.id.list_note);
        Adapter adapter = new Adapter(noteImages, noteTitles, this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }
}
