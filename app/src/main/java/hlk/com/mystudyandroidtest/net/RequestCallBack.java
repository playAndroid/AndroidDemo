package hlk.com.mystudyandroidtest.net;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 网络访问接口
 * Created by user on 2017/2/22.
 */

public abstract class RequestCallBack<T> {
    public abstract void onResponse(Response response);

    public abstract void onFailure(Call call, Exception e);
}
