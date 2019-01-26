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

    ArrayList<String> noteTitles = new ArrayList<>();
    ArrayList<String> noteBodies = new ArrayList<>();

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

        setNote();
    }

    public void setNote(){

        noteBodies.add("Paleo occupy flexitarian venmo cloud bread gentrify selfies. Green juice hoodie meditation readymade waistcoat single-origin coffee truffaut hexagon bicycle rights post-ironic freegan selfies snackwave vinyl williamsburg. ");
        noteBodies.add("Knausgaard brunch mustache twee, sriracha scenester cliche pug iPhone green juice jean shorts lumbersexual. ");
        noteBodies.add("Letterpress intelligentsia ugh microdosing sartorial small batch. Cold-pressed jean shorts coloring book gluten-free kale chips trust fund.");
        noteBodies.add("Vinyl edison bulb cardigan locavore banh mi, photo booth deep v normcore thundercats. Narwhal celiac try-hard next level viral. Pickled heirloom keffiyeh banh mi palo santo try-hard artisan bespoke. Kickstarter pour-over migas, marfa bushwick listicle brooklyn before they sold out affogato tofu fashion axe. ");
        noteBodies.add("Hot chicken poke synth trust fund tumeric. Portland 3 wolf moon biodiesel, crucifix put a bird on it vice yr craft beer gastropub ugh irony palo santo meggings. ");


        noteTitles.add("Bali");
        noteTitles.add("Dominicana");
        noteTitles.add("El Capitan");
        noteTitles.add("Tokyo");
        noteTitles.add("The Woodlands");

        initRecyclerView();
    }

    public void initRecyclerView() {
        // Inside content_to_do_home
        RecyclerView recyclerView = findViewById(R.id.list_note);
        Adapter adapter = new Adapter(noteTitles, noteBodies, this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
    }
}
