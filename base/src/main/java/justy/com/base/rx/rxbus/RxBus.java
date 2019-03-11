package justy.com.base.rx.rxbus;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;

/**
 * Created by amitshekhar on 06/02/17.
 */

public class RxBus {
    static private RxBus rxBus;

    private RxBus() {
    }

    public static RxBus getIns() {
        if (rxBus == null) {
            rxBus = new RxBus();
        }
        return rxBus;
    }

    private PublishSubject<Object> bus = PublishSubject.create();

    public void send(Object o) {
        bus.onNext(o);
    }

    public Observable<Object> toObservable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }
}
