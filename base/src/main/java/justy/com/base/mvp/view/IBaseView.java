package justy.com.base.mvp.view;

/**
 * Created by Allen on 2018/7/10 0010.
 */

public interface IBaseView {

    void showLoading(String message);

    void hideLoading();

    void showToast(String message);

    void showDialogComfirm(String message);

    void showDialogComfirmAndCancel(String tips, Object onComfirm, String comfirtText, String cancelText);
}
