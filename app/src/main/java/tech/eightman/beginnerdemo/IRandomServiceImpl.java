package tech.eightman.beginnerdemo;

import android.os.RemoteException;

import java.util.Random;

public class IRandomServiceImpl extends IRandomService.Stub {
    @Override
    public int getRandomInt(int min, int max) throws RemoteException {
        if(max < min) {
            return min;
        }

        Random rand = new Random();
        return rand.nextInt(max-min+1)+min;
    }
}
