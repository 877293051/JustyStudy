package justy.com.base.network;

import com.rx2androidnetworking.Rx2ANRequest;
import justy.com.base.utils.SecurityUtils;

/**
 * Created by Allen on 2018/7/19 0019.
 */

public class PostRequestBuilder extends Rx2ANRequest.PostRequestBuilder {
    private StringBuilder sb = new StringBuilder();
    private String url;

    public PostRequestBuilder(String url) {
        super(url);
        this.url = url;
        addHeaders("Content-Type", "text/html; charset=UTF-8");
        for (String key : Rx2HcbNetworking.getDefaultParam().keySet()) {
            addBodyParameter(key, Rx2HcbNetworking.getDefaultParam().get(key));
        }
    }

    @Override
    public PostRequestBuilder addBodyParameter(String key, String value) {
        if ("key".equals(key)) {
            value = SecurityUtils.getKeyMd5(value);
        }
        sb.append("&" + key + "=" + value);
        return (PostRequestBuilder) super.addBodyParameter(key, value);
    }

    public String getUrlWithParams() {
        String u = url + sb.toString();
        u = u.replaceFirst("&", "?");
        return u;
    }

    @Override
    public PostRequestBuilder addHeaders(String key, String value) {
        return (PostRequestBuilder) super.addHeaders(key, value);
    }
}
