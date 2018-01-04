package com.example.ervin.kabarkomunitas;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText etEmail;
    private EditText etPassword;
    private ProgressBar pbLoading;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_signup);
        btnSignup = (Button) findViewById(R.id.btn_signup_signup);
        etEmail = (EditText) findViewById(R.id.et_signup_email);
        etPassword = (EditText) findViewById(R.id.et_signup_password);
        pbLoading = (ProgressBar) findViewById(R.id.pb_signup_loading);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void signup() {
        pbLoading.setVisibility(View.VISIBLE);
        String stremail = etEmail.getText().toString().trim();
        String strpassword = etPassword.getText().toString().trim();

        if (isDataInvalid(stremail, strpassword)) return;

        mAuth.createUserWithEmailAndPassword(stremail, strpassword)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                pbLoading.setVisibility(View.GONE);
                startActivity(new Intent(SignupActivity.this, MainActivity.class));
                finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pbLoading.setVisibility(View.GONE);
                Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isDataInvalid(String stremail, String strpassword) {
        boolean isInvalid = stremail.equals("") || strpassword.equals("");
        if (isInvalid) {
            Toast.makeText(this, "Authentication Failed.", Toast.LENGTH_SHORT).show();
            pbLoading.setVisibility(View.GONE);
        }

        return isInvalid;
    }

}
