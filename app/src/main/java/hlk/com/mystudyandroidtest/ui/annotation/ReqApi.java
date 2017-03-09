package hlk.com.mystudyandroidtest.ui.annotation;

/**
 * Created by user on 2017/3/9.
 */

public interface ReqApi {
    @ReqType(reqType = ReqType.ReqTypeEnum.POST)
    @ReqUrl(reqUrl = "www.xxx.com/openApi/login")
    String login(@ReqParam("name")String name,@ReqParam("password")String password);
}
