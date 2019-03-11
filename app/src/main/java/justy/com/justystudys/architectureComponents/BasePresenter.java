package justy.com.justystudys.architectureComponents;

/**
 * authot justy .
 * Date 2019/2/25 .
 * Time 8:36 PM .
 */
public interface BasePresenter<T> {
    void attachView(T view);

    void detachView();
}
