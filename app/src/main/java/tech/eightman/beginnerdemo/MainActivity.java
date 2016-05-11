package tech.eightman.beginnerdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    final static int SEND_TEXT_RESULT = 1;
    final static String TAG = SecondActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG,"onCreate");

        setContentView(R.layout.activity_main);

        // Lesson 12 Demo 1
        Button startNewActivity = (Button)findViewById(R.id.startNewActivityButton);
        startNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Lesson 12 Demo 10
                Context context = getApplicationContext();
                SharedPreferences pref = context.getSharedPreferences("some_file_name", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putString("user_name", ((TextView)findViewById(R.id.userNameTV)).getText().toString());
                editor.commit();

                // Lesson 12 Demo 2
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // Lesson 12 Demo 4
                intent.putExtra("uri","http://developer.android.com/reference/android/content/Intent.html");
                // Lesson 12 Demo 2
                startActivity(intent);
            }
        });

        // Lesson 12 Demo 5
        Button sendButton = (Button)findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,"This was coming from a Send Action");

                // Lesson 12 Demo 5
                startActivity(intent);

                // Lesson 12 Demo 6
                startActivityForResult(intent, SEND_TEXT_RESULT);
            }
        });
    }

    // Lesson 12 Demo 6
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(TAG,"onActivityResult: " + requestCode);
        // Check which request we're responding to
        if (requestCode == SEND_TEXT_RESULT) {

        }
    }
}
