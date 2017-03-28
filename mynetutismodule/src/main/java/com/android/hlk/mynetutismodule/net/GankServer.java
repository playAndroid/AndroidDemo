package com.android.hlk.mynetutismodule.net;

import com.android.hlk.mynetutismodule.bean.GankApiRandomInfo;
import com.android.hlk.mynetutismodule.bean.GankClassifyInfo;
import com.android.hlk.mynetutismodule.bean.GankDayInfo;
import com.android.hlk.mynetutismodule.bean.GankHistoryDayInfo;
import com.android.hlk.mynetutismodule.bean.GankHistoryInfo;
import com.android.hlk.mynetutismodule.bean.GankSearchInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Gank API Server
 * Created by user on 2017/3/22.
 */

public interface GankServer {
    @GET("/api/random/data/{client}/{count}")
    Call<GankApiRandomInfo> gankRandomData(@Path("client") String client, @Path("count") String count);

    //http://gank.io/api/search/query/listview/category/Android/count/10/page/1
    @GET("/api/search/query/listview/category/{type}/count/{counts}/page/{pages}")
    Call<GankSearchInfo> gankSerachData(@Path("type") String type, @Path("counts") int counts, @Path("pages") int page);

    /**
     * /**
     * 获取某几日干货网站数据:
     * http://gank.io/api/history/content/2/1
     * 注： 2 代表 2 个数据，1 代表：取第一页数据
     */
    @GET("/api/history/content/{count}/{page}")
    Call<GankHistoryInfo> gankHistoryData(@Path("count") int count, @Path("page") int page);

    /**
     * /**
     * 获取特定日期网站数据:
     * http://gank.io/api/history/content/day/2016/05/11
     */
//    public static final String GANK_API_HISTORY_DAY = "http://gank.io/api/history/content/day/2016/05/11";
    //2016/05/11
    @GET("/api/history/content/day/{data}")
    Call<GankHistoryDayInfo> gankHistoryDayData(@Path("data") String data);

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     * 例：
     * http://gank.io/api/data/Android/10/1
     * http://gank.io/api/data/福利/10/1
     * http://gank.io/api/data/iOS/20/2
     * http://gank.io/api/data/all/20/2
     * <p>
     * "http://gank.io/api/data/Android/10/1"
     */
    @GET("/api/data/{type}/{count}/{page}")
    Call<GankClassifyInfo> gankClassifyData(@Path("type") String type, @Path("count") int count, @Path("page") int page);

    /**
     * 每日数据： http://gank.io/api/day/年/月/日
     * 例：
     * http://gank.io/api/day/2015/08/06
     * 2015/08/06
     */
    @GET("/api/day/{data}")
    Call<GankDayInfo> gankDayData(@Path("data") String data);

}
