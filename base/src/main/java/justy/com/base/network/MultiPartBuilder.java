package justy.com.base.network;

import com.rx2androidnetworking.Rx2ANRequest;

import java.io.File;
import java.util.List;

import justy.com.base.utils.SecurityUtils;

/**
 * Created by Allen on 2018/8/21 0021.
 */

public class MultiPartBuilder extends Rx2ANRequest.MultiPartBuilder {

    private String mUrl;
    private StringBuilder sb = new StringBuilder();

    public MultiPartBuilder(String url) {
        super(url);
        mUrl = url;
        for (String key : Rx2HcbNetworking.getDefaultParam().keySet()) {
            addMultipartParameter(key, Rx2HcbNetworking.getDefaultParam().get(key));
        }
    }

    @Override
    public MultiPartBuilder addMultipartParameter(String key, String value) {
        if ("key".equals(key)) {
            value = SecurityUtils.getKeyMd5(value);
        }
        sb.append("&" + key + "=" + value);
        return (MultiPartBuilder) super.addMultipartParameter(key, value);
    }

    @Override
    public MultiPartBuilder addMultipartFile(String key, File file) {
        return (MultiPartBuilder) super.addMultipartFile(key, file);
    }

    @Override
    public MultiPartBuilder addMultipartFileList(String key,  List<File> files) {
        return (MultiPartBuilder) super.addMultipartFileList(key, files);
    }

    public String getUrlWithParams() {
        String u = mUrl + sb.toString();
        u = u.replaceFirst("&", "?");
        return u;
    }

}
