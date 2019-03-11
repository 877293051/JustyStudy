package justy.com.base.network;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;

/**
 * Created by Allen on 2018/8/10 0010.
 */

public class BackgroundTask {
    private static HandlerThread mThread;
    private static Handler mHandler;

    public static void startBackgroundTask() {
        if (mThread == null) {
            mThread = new HandlerThread("BackgroundTask", Process.THREAD_PRIORITY_BACKGROUND);
            mThread.start();
            mHandler = new Handler(mThread.getLooper());
        }
    }

    public static void stopBackgroundTask() {
        if (mThread != null) {
            mThread.quit();
            mThread = null;
            mHandler = null;
        }
    }

    public static void post(final Runnable r) {
        if (mHandler != null) {
            mHandler.post(r);
        } else {
            startBackgroundTask();
            post(r);
        }
    }

}
