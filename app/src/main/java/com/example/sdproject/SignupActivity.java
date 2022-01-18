package com.example.sdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sdproject.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {


    ActivitySignupBinding binding;
    private FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Shopify");
        binding = ActivitySignupBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        auth =FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        progressDialog = new ProgressDialog(SignupActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("We are creating your account");



    binding.signupbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            progressDialog.show();

            auth.createUserWithEmailAndPassword
                    (binding.signupemail.getText().toString(),binding.signuppassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    progressDialog.dismiss();
                    if(task.isSuccessful())
                    {
                        User user = new User(binding.signupname.getText().toString(),binding.signupemail.getText().toString(),binding.signuppassword.getText().toString());
                        String id = task.getResult().getUser().getUid();
                        database.getReference().child("Users").child(id).setValue(user);

                        Toast.makeText(SignupActivity.this, "User created successfully", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(SignupActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }
    });


        binding.signIntextgo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(SignupActivity.this ,SignInActivity.class);
                startActivity(intent);
            }
        });

    }
}