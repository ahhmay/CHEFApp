package com.example.chefapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText mEmail, mPassword;
    TextView mRegisterText;
    Button loginBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail=findViewById(R.id.emailid);
        mPassword=findViewById(R.id.password_id);
        mRegisterText=findViewById(R.id.register_textview);
        loginBtn=findViewById(R.id.loginButton);
        fAuth=FirebaseAuth.getInstance();


        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, AddRestaurant.class));
            finish();
        }



        fAuth=FirebaseAuth.getInstance();
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                final String password = mPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)){
                    mEmail.setError("Invalid email address.");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password cannot be empty.");
                    return;
                }

                if(password.length()<8){
                    mPassword.setError("Invalid password.");
                    return;
                }


                //authenticate user
                fAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
//                                progressBar.setVisibility(View.GONE);
                                if (!task.isSuccessful()) {
                                    // there was an error
                                    if (password.length() < 8) {
                                        mPassword.setError("Password Incorrect");
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Email or Password Incorrect.", Toast.LENGTH_LONG).show();
                                    }
                                } else {
                                    String resPhone = getIntent().getStringExtra("resPhone");
                                    Intent intent = new Intent(LoginActivity.this, AddRestaurant.class);
                                    intent.putExtra("resPhone",resPhone);
                                    startActivity(intent);
                                    Toast.makeText(LoginActivity.this,"Login successful.",Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                            }
                        });
            }
        });

        mRegisterText.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));
            }
        });
    }
}