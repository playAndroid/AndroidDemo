package hlk.com.mystudyandroidtest.ui.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * http://www.cnblogs.com/whoislcj/p/5671622.html
 * Created by user on 2017/3/9.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ReqType {
    /**
     * 请求方式枚举
     *
     */
    enum ReqTypeEnum{ GET,POST,DELETE,PUT};

    /**
     * 请求方式
     * @return
     */
    ReqTypeEnum reqType() default ReqTypeEnum.POST;
}
