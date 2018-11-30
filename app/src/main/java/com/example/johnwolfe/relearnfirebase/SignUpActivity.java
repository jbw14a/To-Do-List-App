package com.example.johnwolfe.relearnfirebase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private static final String TAG = "SignUpActivity";
    private FirebaseAuth mAuth;

    private static EditText email;
    private static EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        mAuth = FirebaseAuth.getInstance();
    }

    // Is called from onClickListener from UI
    public void createAccount(View view){
        this.email = (EditText) findViewById(R.id.EmailSignUp);
        this.password = (EditText) findViewById(R.id.PasswordSignUp);
        final String EMAIL = this.email.getText().toString();
        final String PASSWORD = this.password.getText().toString();

        mAuth.createUserWithEmailAndPassword(EMAIL, PASSWORD)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();
                            toast("Created New User");
                        } else {
                            // If sign in fails, display a message to the user.
                            if (password.length() <= 6){
                                toast("Password must be greater than 6 characters");
                            }
                            Toast.makeText(SignUpActivity.this, "Sign Up failed.", Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }
                });

    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        // And if they are, then send them back to SignIn?
        try{
            FirebaseUser currentUser = mAuth.getCurrentUser();
            Log.d(TAG, "Current User: " + currentUser.toString());
        } catch (Exception ex){
            Log.d(TAG, "Error " + ex);
        }
    }

    public void toast(String message){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
