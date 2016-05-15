
package tech.eightman.beginnerdemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity implements ServiceConnection {
    private static final String TAG = ServiceActivity.class.getSimpleName();

    Button mRandomizeButton;
    IRandomService mService = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        
        mRandomizeButton = (Button)findViewById(R.id.getRandomNumButton);
        mRandomizeButton.setEnabled(false);
        mRandomizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mService != null) {
                    int fromNum = Integer.parseInt(((EditText)findViewById(R.id.fromEditText)).getText().toString());
                    int toNum = Integer.parseInt(((EditText)findViewById(R.id.toEditText)).getText().toString());
                    try {
                        int randomNum = mService.getRandomInt(fromNum, toNum);
                        ((TextView)findViewById(R.id.randomNumTextView)).setText(String.valueOf(randomNum));
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent serviceIntent = new Intent();
        serviceIntent.setComponent(
                new ComponentName("tech.eightman.beginnerdemo",
                "tech.eightman.beginnerdemo.RandomNumberService"));

        if (!super.bindService(serviceIntent, this, BIND_AUTO_CREATE)) {
            Log.w(TAG, "Failed to bind to service");
        }
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        this.mService = IRandomService.Stub.asInterface(service);
        this.mRandomizeButton.setEnabled(true);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        this.mService = null;
        this.mRandomizeButton.setEnabled(false);

    }
}
