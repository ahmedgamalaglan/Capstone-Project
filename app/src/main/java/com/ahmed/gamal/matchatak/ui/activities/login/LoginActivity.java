package com.ahmed.gamal.matchatak.ui.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ahmed.gamal.matchatak.R;
import com.ahmed.gamal.matchatak.ui.activities.main.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private static final String TAG = "LoginActivity";

    private EditText usernameEditText;
    private EditText passwordEditText;
    private ProgressBar loadingProgressBar;
    private FirebaseAnalytics firebaseAnalytics;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAnalytics = FirebaseAnalytics.getInstance(this);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        Button loginButton = findViewById(R.id.login);
        Button registerButton = findViewById(R.id.register);
        loadingProgressBar = findViewById(R.id.loading);

        loadingProgressBar.setVisibility(View.GONE);


        loginButton.setOnClickListener(v ->
                signIn(usernameEditText.getText().toString(), passwordEditText.getText().toString()));

        registerButton.setOnClickListener(v ->
                createAccount(usernameEditText.getText().toString(), passwordEditText.getText().toString()));
    }

    private boolean validate() {
        boolean res = true;
        if (TextUtils.isEmpty(usernameEditText.getText().toString()) &&
                !Patterns.EMAIL_ADDRESS.matcher(usernameEditText.getText().toString()).matches()) {
            usernameEditText.setError("invalid Email");
            res = false;
        }
        if (passwordEditText.getText().toString().equalsIgnoreCase("")) {
            passwordEditText.setError("Invalid Password");
            res = false;
        }
        return res;
    }

    // [START on_start_check_user]
    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void createAccount(String email, String password) {
        Log.d(TAG, "createAccount:" + email);
        if (!validate()) {
            return;
        }

        loadingProgressBar.setVisibility(View.VISIBLE);

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Bundle bundle = new Bundle();
                            bundle.putString(FirebaseAnalytics.Param.METHOD, "sign_up");
                            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SIGN_UP, bundle);
                            updateUI(user);
                        } else {
                            if (task.getException() != null)
                                Toast.makeText(LoginActivity.this, task.getException().getLocalizedMessage(),
                                        Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        loadingProgressBar.setVisibility(View.INVISIBLE);
                    }
                });
    }

    private void signIn(String email, String password) {

        if (!validate()) {
            return;
        }

        loadingProgressBar.setVisibility(View.VISIBLE);
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = firebaseAuth.getCurrentUser();
                            Bundle bundle = new Bundle();
                            bundle.putString(FirebaseAnalytics.Param.METHOD, "sign_up");
                            firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, bundle);
                            updateUI(user);
                        } else {
                            if (task.getException() != null)
                                Toast.makeText(LoginActivity.this, task.getException().getLocalizedMessage(),
                                        Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                        loadingProgressBar.setVisibility(View.GONE);
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        loadingProgressBar.setVisibility(View.GONE);
        if (user != null) {
            if (!user.getUid().equalsIgnoreCase("")) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("userId", user.getUid());
                startActivity(intent);
            } else
                Toast.makeText(this, "Your Email is not registered please register before try logging in", Toast.LENGTH_LONG).show();
        }
    }

}