package tech.eightman.beginnerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tech.eightman.beginnerdemo.db.LoginDataSource;
import tech.eightman.beginnerdemo.model.Registration;

public class SignupActivity extends AppCompatActivity {
    LoginDataSource datasource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        datasource = new LoginDataSource(this);
        datasource.open();

        final Button signupButton = (Button)findViewById(R.id.signupButton);
        final EditText emailEditText = (EditText)findViewById(R.id.signupEmail);
        final EditText passwordEditText = (EditText)findViewById(R.id.signupPassword);
        final EditText mobileEditText = (EditText)findViewById(R.id.signupMobile);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                String mobile = mobileEditText.getText().toString();

                boolean isValid = true;
                if(email == null || email.isEmpty()) {
                    isValid = false;
                    Toast.makeText(getApplicationContext(), "Email is empty", Toast.LENGTH_LONG).show();
                }

                if(password == null || password.isEmpty()) {
                    isValid = false;
                    Toast.makeText(getApplicationContext(), "Password is empty", Toast.LENGTH_LONG).show();
                }

                if(mobile == null || mobile.isEmpty()) {
                    isValid = false;
                    Toast.makeText(getApplicationContext(), "Mobile is empty", Toast.LENGTH_LONG).show();
                }

                if(isValid) {
                    Registration registration = new Registration();
                    registration.setEmail(email);
                    registration.setPassword(password);
                    registration.setMobile(mobile);

                    registration = datasource.create(registration);
                    if(registration.getRegID() != -1) {
                        Toast.makeText(getApplicationContext(), "Signup Successful", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Signup Error", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
