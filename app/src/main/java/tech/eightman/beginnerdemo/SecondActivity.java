package tech.eightman.beginnerdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    final static String TAG = SecondActivity.class.getSimpleName();

    EditText mURI = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Lesson 12 Demo 4
        mURI = (EditText)findViewById(R.id.uriET);
        mURI.setText(getIntent().getStringExtra("uri"));

        // Lesson 12 Demo 3
        Button openButton = (Button)findViewById(R.id.openButton);
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(mURI.getText().toString()));
                startActivity(i);
            }
        });

        // Lesson 12 Demo 10
        Context context = getApplicationContext();
        SharedPreferences pref = context.getSharedPreferences("some_file_name", MODE_PRIVATE);
        ((TextView)findViewById(R.id.helloUserTV)).setText(pref.getString("user_name","NULL"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }
}
