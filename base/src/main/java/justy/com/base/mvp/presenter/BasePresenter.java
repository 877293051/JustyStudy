package justy.com.base.mvp.presenter;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import justy.com.base.mvp.view.IBaseView;

/**
 * Created by Allen on 2018/7/10 0010.
 */

public class BasePresenter<T extends IBaseView> implements IBasePresenter<T> {
    protected T mView;
    private CompositeDisposable disposables;

    @Override
    public void attachView(T view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView = null;
        if (disposables != null) {
            disposables.clear();
        }
    }

    @Override
    public void addRxDisposable(Disposable disposable) {
        if (disposables == null) {
            disposables = new CompositeDisposable();
        }
        disposables.add(disposable);
    }
}
