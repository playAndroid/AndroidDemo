package hlk.com.mystudyandroidtest.net.retrofittest;

import hlk.com.mystudyandroidtest.bean.MoveEntity;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by user on 2017/2/27.
 */

public interface MoveServer {
//    @GET("top250")
//    Call<MoveEntity> getTopMove(@Query("start") int start, @Query("count") int count);
    @GET("top250")
    Observable<MoveEntity> getTopMove(@Query("start") int start, @Query("count") int count);

//    @GET("top250")
//    Observable getTop(@Query("start") int start, @Query("count") int count);
}
