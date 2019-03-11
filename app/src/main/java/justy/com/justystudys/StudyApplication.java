package justy.com.justystudys;

import android.app.Application;

/**
 * authot justy .
 * Date 2019/2/25 .
 * Time 10:35 AM .
 */
public class StudyApplication extends Application {

    private static StudyApplication mApp;

    public static synchronized StudyApplication getIns(){
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApp=this;
    }
}
