package justy.com.base.network;


import com.rx2androidnetworking.Rx2ANRequest;

import java.util.HashMap;

/**
 * Created by Allen on 2018/7/19 0019.
 */

public class Rx2HcbNetworking {
    private static HashMap<String, String> mDefaultParam = new HashMap<>();

    public static void setDefaultBodyParameters(HashMap<String, String> mDefaultParam) {
        Rx2HcbNetworking.mDefaultParam = mDefaultParam;
    }

    public static HashMap<String, String> getDefaultParam() {
        return mDefaultParam;
    }

    /**
     * private constructor to prevent instantiation of this class
     */
    private Rx2HcbNetworking() {
    }

    /**
     * Method to make GET request
     *
     * @param url The url on which request is to be made
     * @return The GetRequestBuilder
     */
    public static Rx2ANRequest.GetRequestBuilder get(String url) {
        return new Rx2ANRequest.GetRequestBuilder(url);
    }

    /**
     * Method to make HEAD request
     *
     * @param url The url on which request is to be made
     * @return The HeadRequestBuilder
     */
    public static Rx2ANRequest.HeadRequestBuilder head(String url) {
        return new Rx2ANRequest.HeadRequestBuilder(url);
    }

    /**
     * Method to make POST request
     *
     * @param url The url on which request is to be made
     * @return The PostRequestBuilder
     */
    public static PostRequestBuilder post(String url) {
        return new PostRequestBuilder(url);
    }

    /**
     * Method to make PUT request
     *
     * @param url The url on which request is to be made
     * @return The PutRequestBuilder
     */
    public static Rx2ANRequest.PutRequestBuilder put(String url) {
        return new Rx2ANRequest.PutRequestBuilder(url);
    }

    /**
     * Method to make DELETE request
     *
     * @param url The url on which request is to be made
     * @return The DeleteRequestBuilder
     */
    public static Rx2ANRequest.DeleteRequestBuilder delete(String url) {
        return new Rx2ANRequest.DeleteRequestBuilder(url);
    }

    /**
     * Method to make PATCH request
     *
     * @param url The url on which request is to be made
     * @return The PatchRequestBuilder
     */
    public static Rx2ANRequest.PatchRequestBuilder patch(String url) {
        return new Rx2ANRequest.PatchRequestBuilder(url);
    }

    /**
     * Method to make download request
     *
     * @param url      The url on which request is to be made
     * @param dirPath  The directory path on which file is to be saved
     * @param fileName The file name with which file is to be saved
     * @return The DownloadBuilder
     */
    public static Rx2ANRequest.DownloadBuilder download(String url, String dirPath, String fileName) {
        return new Rx2ANRequest.DownloadBuilder(url, dirPath, fileName);
    }

    /**
     * Method to make upload request
     *
     * @param url The url on which request is to be made
     * @return The MultiPartBuilder
     */
    public static MultiPartBuilder upload(String url) {
        return new MultiPartBuilder(url);
    }
}
