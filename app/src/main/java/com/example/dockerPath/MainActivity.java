package com.example.dockerPath;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
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

public class MainActivity extends AppCompatActivity {

        EditText email,pass;
        Button btn;
        ProgressBar progressBar;
        TextView linkclick;
        FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Login");  // provide compatibility to all the versions

        email= findViewById(R.id.emailInput);
        pass= findViewById(R.id.passInput);
        btn=findViewById(R.id.loginBtn);
        progressBar=findViewById(R.id.progressBar);
        linkclick=findViewById(R.id.clickableInput);
        fAuth=FirebaseAuth.getInstance();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email2=email.getText().toString().trim();
                String pass2=pass.getText().toString().trim();

                if (TextUtils.isEmpty(email2)) {
                    email.setError("Email is Reqiured");
                    return;
                }

                if (TextUtils.isEmpty(pass2)) {
                    pass.setError("Password is Reqiured");
                    return;
                }
                if (pass2.length()<6){
                    pass.setError("Short Password");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);

                //authenticate the user
                fAuth.signInWithEmailAndPassword(email2,pass2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){

                            Toast.makeText(MainActivity.this,"Welcome",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), Dashborad.class));
                            finish();

                        }else{

                            Toast.makeText(MainActivity.this,"Email or Password is incorrect!",Toast.LENGTH_LONG).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });

        linkclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Signup.class));
           //     finish();
            }
        });
    }

    @Override
    public void onBackPressed() {

    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
    builder.setMessage("Are you sure you want to exit ?");
    builder.setCancelable(true);

    builder.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            finish();
        }
    });

    builder.setNegativeButton( "No", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            dialog.cancel();
        }
    });

    AlertDialog alertDialog = builder.create();
    alertDialog.show();

    }

}
