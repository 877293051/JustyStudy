package justy.com.android.architectureComponents;

/**
 * authot justy .
 * Date 2019/2/26 .
 * Time 7:10 PM .
 */
public interface BaseViewModel<T> {
    T loadData();
    void clearData();
}
