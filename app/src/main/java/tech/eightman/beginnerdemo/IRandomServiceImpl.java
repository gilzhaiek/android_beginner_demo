package tech.eightman.beginnerdemo;

import android.os.RemoteException;

import java.util.Random;

public class IRandomServiceImpl extends IRandomService.Stub {
    @Override
    public int getRandomInt(int from, int to) throws RemoteException {
        if(to < from) {
            return from;
        }

        Random rand = new Random();
        return rand.nextInt(to-from+1)+from;
    }
}
