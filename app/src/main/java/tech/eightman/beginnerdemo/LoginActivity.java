package tech.eightman.beginnerdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tech.eightman.beginnerdemo.db.LoginDataSource;

public class LoginActivity extends AppCompatActivity {

    LoginDataSource mDataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDataSource = new LoginDataSource(this);
        mDataSource.open();

        final Button loginButton = (Button)findViewById(R.id.loginButton);
        final EditText emailEditText = (EditText)findViewById(R.id.loginEmail);
        final EditText passwordEditText = (EditText)findViewById(R.id.loginPassword);
        final Button signupButton = (Button)findViewById(R.id.loginSignupButton);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();

                boolean isValid = true;
                if (email == null || email.isEmpty()) {
                    isValid = false;
                    Toast.makeText(LoginActivity.this, "Email is empty", Toast.LENGTH_LONG).show();
                }

                if (password == null || password.isEmpty()) {
                    isValid = false;
                    Toast.makeText(LoginActivity.this, "Password is empty", Toast.LENGTH_LONG).show();
                }

                if (isValid) {
                    if(mDataSource.checkLogin(email,password)){
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
                        emailEditText.setText("");
                        passwordEditText.setText("");
                        Intent intent = new Intent(LoginActivity.this, WelcomeActivity.class);
                        intent.putExtra("email",email);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
