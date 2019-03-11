package justy.com.base.mvp.presenter;

import io.reactivex.disposables.Disposable;
import justy.com.base.mvp.view.IBaseView;

/**
 * Created by Allen on 2018/7/10 0010.
 */

public interface IBasePresenter<T extends IBaseView> {

    void attachView(T view);

    void detachView();

    void addRxDisposable(Disposable disposable);
}
