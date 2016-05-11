package tech.eightman.beginnerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView userTV = (TextView)findViewById(R.id.userTextView);

        String email = getIntent().getExtras().getString("email");

        if(email == null) {
            email = "NULL";
        }

        userTV.setText(email);
    }
}
