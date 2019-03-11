package justy.com.base.network;

import com.rx2androidnetworking.Rx2ANRequest;
import org.json.JSONObject;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import justy.com.base.Config;
import okhttp3.OkHttpClient;

/**
 * Created by Allen on 2018/8/13 0013.
 */

public class BaseNetworkApi {
    public static PostRequestBuilder getBuilder(HashMap<String, String> map) {
        return getBuilder(map, Config.server_addr);
    }

    public static PostRequestBuilder getBuilder(HashMap<String, String> map, String host, long timeOut) {
        PostRequestBuilder builder = getBuilder(map, host);
        builder.setOkHttpClient(new OkHttpClient().newBuilder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .build());
        return builder;
    }

    public static PostRequestBuilder getBuilder(HashMap<String, String> map, String host) {
        PostRequestBuilder builder = Rx2HcbNetworking.post(host);
        for (String key : map.keySet()) {
            builder.addBodyParameter(key, map.get(key) == null ? "" : map.get(key));
        }
        return builder;
    }

    public static MultiPartBuilder getMultiPartBuilder(HashMap<String, String> map, String host){
        MultiPartBuilder builder = Rx2HcbNetworking.upload(host);
        for (String key : map.keySet()) {
            builder.addMultipartParameter(key, map.get(key));
        }
        return builder;
    }

    public static Rx2ANRequest subscribe(PostRequestBuilder builder, BaseObserver observer) {
        observer.setRequestBuilder(builder);
        Rx2ANRequest rx2ANRequest=  builder.build();
        commonPost(rx2ANRequest).subscribe(observer);
        return  rx2ANRequest;
    }

    public static void subscribe(HashMap<String, String> map, BaseObserver observer) {
        PostRequestBuilder builder = getBuilder(map);
        subscribe(builder, observer);
    }

    public static void subscribe(HashMap<String, String> map, String host, BaseObserver observer) {
        PostRequestBuilder builder = BaseNetworkApi.getBuilder(map, host);
        subscribe(builder, observer);
    }

    public static void subscribe(HashMap<String, String> map, Observable observable, BaseObserver observer) {
        PostRequestBuilder builder = BaseNetworkApi.getBuilder(map);
        subscribe(builder, observable, observer);
    }

    public static void subscribe(PostRequestBuilder builder, Observable observable, BaseObserver observer) {
        observer.setRequestBuilder(builder);
        observable.subscribe(observer);
    }

    public static void subscribe(HashMap<String, String> map, File file, BaseObserver observer) {
        commonUpload(map, file).subscribe(observer);
    }

    public static void subscribe(HashMap<String, String> map, File file, Observable observable, BaseObserver observer) {
        commonUpload(map, file).subscribe(observer);
    }

    public static Observable<JSONObject> commonPost(HashMap<String, String> map) {
        PostRequestBuilder builder = getBuilder(map);
        return commonPost(builder);
    }

    public static Observable<JSONObject> commonPost(Rx2ANRequest rx2ANRequest) {
        return  rx2ANRequest
                .getJSONObjectObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public static Observable<JSONObject> commonPost(Rx2ANRequest.PostRequestBuilder builder) {
        return builder
                .build()
                .getJSONObjectObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static void subscribeReturnWithString(PostRequestBuilder builder, BaseObserver observer) {
        observer.setRequestBuilder(builder);
        commonPostReturnWithString(builder).subscribe(observer);
    }

    public static void subscribeReturnWithString(MultiPartBuilder builder, BaseObserver observer) {
        configMultiPartBuilder(builder).subscribe(observer);
    }

    public static Observable<String> commonPostReturnWithString(Rx2ANRequest.PostRequestBuilder builder) {
        return builder
                .build()
                .getStringObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable<JSONObject> commonUpload(HashMap<String, String> map, File file) {
        return commonUpload(map, Config.server_addr, file);
    }

    public static Observable<JSONObject> commonUploadFileList(HashMap<String, String> map,String host,List<File> files) {
        MultiPartBuilder builder = Rx2HcbNetworking.upload(host);
        for (String key : map.keySet()) {
            builder.addMultipartParameter(key, map.get(key));
        }
        builder.addMultipartFileList("file[]", files);
        return configBuilder(builder);
    }

    public static Observable<JSONObject> commonUpload(HashMap<String, String> map, String host, File file) {
        MultiPartBuilder builder = Rx2HcbNetworking.upload(host);
        for (String key : map.keySet()) {
            builder.addMultipartParameter(key, map.get(key));
        }
        builder.addMultipartFile("file", file);
        return configBuilder(builder);
    }

    public static Observable<JSONObject> configBuilder(MultiPartBuilder builder){
        builder.setOkHttpClient(new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(200, TimeUnit.SECONDS)
                .writeTimeout(200, TimeUnit.SECONDS)
                .build());
        return builder.build()
                .getJSONObjectObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

    public static Observable<String> configMultiPartBuilder(MultiPartBuilder builder){
        builder.setOkHttpClient(new OkHttpClient().newBuilder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(200, TimeUnit.SECONDS)
                .writeTimeout(200, TimeUnit.SECONDS)
                .build());
        return builder.build()
                .getStringObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }
}
