package hlk.com.mystudyandroidtest.net.retrofittest;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * retrofit demo
 * Created by user on 2017/2/24.
 * https://github.com/hehonghui/android-tech-frontier/tree/master/issue-7/Retrofit%E5%BC%80%E5%8F%91%E6%8C%87%E5%8D%97
 */

public interface GitApi {
    @GET("/users/{user}")
    public void getString(@Path("user") String path, Callback<Gitmodel> callback);
}
