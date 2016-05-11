package tech.eightman.beginnerdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class RandomNumberService extends Service {
    private IRandomServiceImpl mService;

    public void onCreate() {
        super.onCreate();
        this.mService = new IRandomServiceImpl();  // The actual Service
    }

    // This is the IBinder object which is returned through ServiceConnection interface
    // It is used in the client to communicate with this service (IRandomServiceImpl)
    @Override
    public IBinder onBind(Intent intent) {
        return mService;
    }

    // This service can also be started using a startService method call
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // For started services, there are two additional major modes of
        // operation they can decide to run in, depending on the value
        // they return from onStartCommand():
        // - START_STICKY is used for services that are explicitly started and stopped as needed
        // - START_NOT_STICKY or START_REDELIVER_INTENT are used for services that should only
        //   remain running while processing any commands sent to them.
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        this.mService = null;
        super.onDestroy();
    }
}
