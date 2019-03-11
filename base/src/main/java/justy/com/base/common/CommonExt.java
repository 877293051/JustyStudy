package justy.com.base.common;

import io.reactivex.annotations.Nullable;

/**
 * 公共可提取方法类
 * authot justy .
 * Date 2019/2/22 .
 * Time 11:02 AM .
 */
public class CommonExt {

    /**
     * 发送监听事件
     *
     * @param event 事件类型
     * @param o     事件传递内容
     */
    public static void sendEvent(CommonListener listenter, CommonListener.Event event, @Nullable Object o) {
        if (listenter != null) {
            listenter.event(event, o);
        }
    }

    /**
     * 获取返回参数值
     *
     * @param p 获取参数类型
     * @param o 传递内容
     */
    public static  Object getParameter(CommonListener listenter, CommonListener.Parameter p, Object o) {
        if (listenter != null) {
            return listenter.getParameter(p, o);
        }
        return null;
    }
}
