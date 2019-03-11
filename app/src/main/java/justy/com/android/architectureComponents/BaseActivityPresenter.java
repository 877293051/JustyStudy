package justy.com.android.architectureComponents;

/**
 * authot justy .
 * Date 2019/2/25 .
 * Time 8:35 PM .
 */
public interface BaseActivityPresenter extends BasePresenter{

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

}
