package com.budget.personalfinancetracking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {
    private EditText email, password,confirmPassword;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirmPassword=findViewById(R.id.confirmPassword);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

    }

    public void directTologin(View view) {
        Intent i= new Intent(RegistrationActivity.this,LoginActivity.class);
        startActivity(i);
    }

    public void regiter(View view) {

        String emailString=email.getText().toString();
        String passwordString=password.getText().toString();
        String confirmPasswordString=confirmPassword.getText().toString();
        if(!passwordString.equals(confirmPasswordString)){
            Toast.makeText(RegistrationActivity.this,"Password Mismatch", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(emailString)){
            email.setError("Email is required");
        }
        else if (TextUtils.isEmpty(passwordString)){
            password.setError("Password is required");
        }
        else{
            progressDialog.setMessage("registration in progress");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(emailString,passwordString).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        progressDialog.dismiss();
                    }else {
                        Toast.makeText(RegistrationActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }

                }
            });

        }
    }
}