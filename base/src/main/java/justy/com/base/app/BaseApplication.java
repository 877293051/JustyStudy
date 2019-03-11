package justy.com.base.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * authot justy .
 * Date 2019/3/4 .
 * Time 8:35 PM .
 */
public class BaseApplication extends Application {

    private boolean isDebugARouter = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (isDebugARouter){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }
}
