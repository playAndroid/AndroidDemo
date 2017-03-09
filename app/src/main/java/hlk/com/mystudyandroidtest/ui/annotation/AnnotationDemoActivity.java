package hlk.com.mystudyandroidtest.ui.annotation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;

import hlk.com.mystudyandroidtest.R;

/**
 * Created by user on 2017/3/9.
 */

public class AnnotationDemoActivity extends AppCompatActivity {

    private static final String TAG = "AnnotationDemoActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);

        testApi();
    }

    public void testApi() {
//        Method[] methods = ReqApi.class.getDeclaredMethods();
//        for (Method method :methods){
//            Annotation[] annotations = method.getAnnotations();
//            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
//        }

        ReqApi reqApi = create(ReqApi.class);
        reqApi.login("123", "456");

    }


    private <T> T create(final Class<T> reqApiClass) {

        return (T) Proxy.newProxyInstance(reqApiClass.getClassLoader(), new Class[]{reqApiClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                ReqType reqType = method.getAnnotation(ReqType.class);
                Log.e(TAG, "IReqApi---reqType->" + (reqType.reqType() == ReqType.ReqTypeEnum.POST ? "POST" : "OTHER"));
//
                ReqUrl reqUrl =  method.getAnnotation(ReqUrl.class);
                Log.e(TAG, "IReqApi---reqUrl->" + reqUrl.reqUrl());

                Type[] parameterTypes = method.getGenericParameterTypes();
                Annotation[][] parameterAnnotationsArray = method.getParameterAnnotations();//拿到参数注解
                for (int i = 0; i < parameterAnnotationsArray.length; i++) {
                    Annotation[] annotations = parameterAnnotationsArray[i];
                    if (annotations != null) {
                        ReqParam reqParam = (ReqParam) annotations[0];
                        Log.e(TAG, "reqParam---reqParam->" + reqParam.value() + "==" + args[i]);
                    }
                }
                //下面就可以执行相应的网络请求获取结果 返回结果
                String result = "";//这里模拟一个结果

                return result;
            }
        });
    }
}
