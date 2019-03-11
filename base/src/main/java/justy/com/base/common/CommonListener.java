package justy.com.base.common;

/**
 * 公共可共用监听
 * authot justy .
 * Date 2019/2/22 .
 * Time 10:55 AM .
 */
public interface CommonListener {

    void event(Event event, Object o);

    Object getParameter(Parameter p, Object o);

    enum Event {
        CHECK_TIPS_FUWUQU,CHANGE_PHONE,CHANGE_PASSWORD,QUIT
    }

    enum Parameter {
        DIFF_DIS
    }

}
