package com.example.dockerPath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText pseudo,email,pass;
    Button signupBtn;
    ProgressBar progressBar;
    TextView linkclick;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);// provide compatibility to all the versions
        getSupportActionBar().setTitle("SignUp");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // display back btn


        pseudo= findViewById(R.id.t1);
        email= findViewById(R.id.t2);
        pass= findViewById(R.id.t3);
        signupBtn=findViewById(R.id.signupBtn);
        progressBar=findViewById(R.id.progressBar);
        linkclick=findViewById(R.id.clickableInput);
        fAuth=FirebaseAuth.getInstance();

        //If the user is already logged in or created an account(we take him directly ot the new act)
        if (fAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(), Dashborad.class));
            finish();
        }

        signupBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String mail=email.getText().toString().trim();
                String passw=pass.getText().toString().trim();
                String psd=pseudo.getText().toString().trim();

                if (TextUtils.isEmpty(psd)) {
                    pseudo.setError("Pseudo is Reqiured");
                    return;
                }

                if (TextUtils.isEmpty(mail)) {
                    email.setError("Email is Reqiured");
                    return;
                }

                if (TextUtils.isEmpty(passw)) {
                    pass.setError("Password is Reqiured");
                    return;
                }
                if (passw.length()<6){
                    pass.setError("Short Password");
                    return;
                }


                progressBar.setVisibility(View.VISIBLE);
                //Register the user in Firebase
                fAuth.createUserWithEmailAndPassword(mail,passw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            Toast.makeText(Signup.this,"Account Created",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), Dashborad.class));
                            finish();
                        }else{
                            Toast.makeText(Signup.this,"Email already registred!",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });

            }
        });

        linkclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        });
    }
}
