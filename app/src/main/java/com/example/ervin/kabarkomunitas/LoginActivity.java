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

import static com.example.ervin.kabarkomunitas.R.id.pb_signin_loading;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail;
    private FirebaseAuth mAuth;
    private EditText etPassword;
    private ProgressBar pbLoading;
    private Button btnLogin;
    private Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btn_login_signin);
        btnSignup = (Button) findViewById(R.id.btn_login_signup);
        etEmail = (EditText) findViewById(R.id.et_login_email);
        etPassword = (EditText) findViewById(R.id.et_login_password);
        pbLoading = (ProgressBar) findViewById(pb_signin_loading);
        mAuth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signin();
            }
        });
    }

    private void signin() {
        pbLoading.setVisibility(View.VISIBLE);
        String stremail = etEmail.getText().toString().trim();
        String strpassword = etPassword.getText().toString().trim();

        if (isDataInvalid(stremail, strpassword)) return;

        mAuth.signInWithEmailAndPassword(stremail, strpassword)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        pbLoading.setVisibility(View.GONE);
                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pbLoading.setVisibility(View.GONE);
                        Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
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
