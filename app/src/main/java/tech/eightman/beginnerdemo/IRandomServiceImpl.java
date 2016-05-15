package tech.eightman.beginnerdemo;

import android.os.RemoteException;

public class IRandomServiceImpl extends IRandomService.Stub {
    @Override
    public int getRandomInt(int from, int to) throws RemoteException {
        return getRandomIntNative(from, to);
    }

    static {
        System.loadLibrary("random-jni");
    }

    private native int getRandomIntNative(int from, int to);
}
