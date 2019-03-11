package justy.com.base.network;

import android.app.Activity;
import android.app.Dialog;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import justy.com.base.Config;

/**
 * Created by Allen on 2018/7/24 0024.
 */

public class BaseObserver<T> implements Observer<T> {
    protected PostRequestBuilder requestBuilder;
    protected Activity actBase;
    protected String loading;
    protected Dialog dialog;
    protected boolean mCancelable = false;

    public BaseObserver() {
    }

    public BaseObserver(Activity activity) {
        this(activity, "");
    }

    public BaseObserver(Activity activity, String loading) {
        this.actBase = activity;
        this.loading = loading;
    }

    public void setLoading(String loading) {
        this.loading = loading;
    }

    public void setCancelable(boolean mCancelable) {
        this.mCancelable = mCancelable;
    }

    public void dismissLoading(){
        if (actBase != null && !actBase.isDestroyed() && dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {
        if (actBase != null && !actBase.isDestroyed()) {
        }
    }

    @Override
    public void onNext(T o) {
//        Logger.d(o);
    }

    @Override
    public void onError(Throwable e) {
        if (requestBuilder != null) {
        }
        dismissLoading();
    }

    public String getErrorMsg(Throwable e){
        if (Config.isDebug) {
            return  e.getMessage();
        }
        return "";
    }
    @Override
    public void onComplete() {
        if (requestBuilder != null) {
        }
        dismissLoading();
    }

    public PostRequestBuilder getRequestBuilder() {
        return requestBuilder;
    }

    public void setRequestBuilder(PostRequestBuilder requestBuilder) {
        this.requestBuilder = requestBuilder;
    }
}
