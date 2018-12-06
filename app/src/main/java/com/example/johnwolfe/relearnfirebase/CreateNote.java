package com.example.johnwolfe.relearnfirebase;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreateNote extends AppCompatActivity {

    private static Button submitNote;
    private static EditText noteText;

    private FirebaseDatabase mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        submitNote = (Button) findViewById(R.id.submitNote);
        noteText = (EditText) findViewById(R.id.noteText);

        // Must be signed in to use
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference();

        submitNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitNoteToDb(view);
            }
        });
    }

    public void submitNoteToDb(View view){
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null){
            //yourmom
        }

    }

    public void toast(String message){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
