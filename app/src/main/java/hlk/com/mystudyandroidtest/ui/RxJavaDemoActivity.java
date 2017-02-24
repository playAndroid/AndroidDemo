package hlk.com.mystudyandroidtest.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import hlk.com.mystudyandroidtest.R;
import hlk.com.mystudyandroidtest.utils.LogUtil;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 被观察者  - 观察者 - 订阅 - 事件
 * Created by hlk on 2017/2/23.
 * 学习文章
 * http://gank.io/post/560e15be2dca930e00da1083
 */

public class RxJavaDemoActivity extends AppCompatActivity {
    @BindView(R.id.text_title)
    TextView mTitle;
    private Subscriber<String> subscriber;

    private final String TAG = "rxjava";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_demo);
        ButterKnife.bind(this);
//        createObserver();
        //调用方式一
//        createSubObserver();
//        createObservable();
        //调用方式2
        createAndWorkSubobserver();
    }

    private void createAndWorkSubobserver() {
        Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("haha");
                subscriber.onNext("houhou");
                subscriber.onNext("good");
                subscriber.onCompleted();
            }
        }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                LogUtil.d("rxjava", "onNext+连续调用" + s);
            }
        });

    }

    /**
     * 创建观察者
     */
    private void createObserver() {
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                LogUtil.d("rxjava", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.d("rxjava", "onError");
            }

            @Override
            public void onNext(String s) {
                LogUtil.d("rxjava", "onNext:" + s);
            }
        };
    }

    private void createSubObserver() {
        //observer 扩展类 增加start方法 可用于 在执行之前做准备工作
        subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                LogUtil.d("rxjava", "subscriber---onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.d("rxjava", "subscriber---onError");
            }

            @Override
            public void onNext(String s) {
                LogUtil.d("rxjava", "subscriber---onNext:" + s);
            }

            @Override
            public void onStart() {
                super.onStart();
                //observer 扩展类 增加start方法 可用于 在执行之前做准备工作
                LogUtil.d("rxjava", "subscriber---onStart");
            }

        };

        if (subscriber.isUnsubscribed()) {
            subscriber.unsubscribe();//取消观察
        }
    }

    /**
     * 创建被观察者
     */
    private void createObservable() {
        rx.Observable<String> observable = rx.Observable.create(
                new rx.Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext("hello");
                        subscriber.onNext("world");
                        subscriber.onNext("hehe");
                        subscriber.onCompleted();
                    }
                }
        );
        //方法2
//        Observable<String> observable1 = Observable.just("hi", "hello", "world");
        //方法3
//        String[] data = {"hi", "hello"};
//        Observable<String> observable2 = Observable.from(data);

        //订阅
        observable.subscribe(subscriber);

        //不完整定义  相当于将 next completed 包装好 传给observable

        Action1<String> onNextAction = new Action1<String>() {
            // onNext()
            @Override
            public void call(String s) {
                LogUtil.d("rxjava", s);
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            // onError()
            @Override
            public void call(Throwable throwable) {
                // Error handling
            }
        };
        Action0 onCompletedAction = new Action0() {
            // onCompleted()
            @Override
            public void call() {
                LogUtil.d("rxjava", "completed");
            }
        };

// 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
//        observable.subscribe(onNextAction);
// 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
//        observable.subscribe(onNextAction, onErrorAction);
// 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
//        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);
    }

    /**
     * 异步订阅
     */
    private void asyObserver() {
        Observable.just(1, 2, 3, 4)
                .subscribeOn(Schedulers.io())//IO线程执行   指定的是 订阅(subscribe)此被观察者(Observable)的订阅者(subscribe)
                .observeOn(AndroidSchedulers.mainThread())//主线程执行   指定的是Observable中的Observer的线程
                .subscribe(new Action1<Integer>() {
                    @Override
                    public void call(Integer number) {
                        LogUtil.d("rxjava", "call" + number);
                    }
                });
    }

    private void changeObserver() {
        //变换序列中的对象  或者对整个序列进行加工
        Observable.just("image/logo.png")
                .map(new Func1<String, Drawable>() {
                    @Override
                    public Drawable call(String path) {
                        return getBitMap(path);
                    }
                }).subscribe(new Action1<Drawable>() {
            @Override
            public void call(Drawable drawable) {
//                showDrabable(drawable);
            }
        });
    }


    private void flatMapExample() {
        //将传入的参数  转化为 另一个对象返回出去
        //参数转化之后返回另一个对象
        Student[] student = {new Student(), new Student(), new Student()};

        Observer<Student> observer = new Observer<Student>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Student student) {

                LogUtil.d("rxjava", "onNext: " + student.getName());
                ArrayList<Course> list = student.getList();
                for (int i = 0; i < list.size(); i++) {
                    LogUtil.d("rxjava", "onNext: " + list.get(i).courseName);
                }
            }
        };

        Observable.from(student).subscribe(observer);


        //如果要打学生的课程 不使用 for循环呢 就需要将课程直接传过去呢?
        //使用flatMap  flat : 平面
        Observer<Course> courseObserver = new Observer<Course>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Course course) {
                LogUtil.d(TAG, "onNext: " + course.courseName);
            }
        };

        Observable.from(student).flatMap(new Func1<Student, Observable<Course>>() {
            @Override
            public Observable<Course> call(Student student) {
                return Observable.from(student.getList());
            }
        }).throttleFirst(500, TimeUnit.MILLISECONDS).subscribe(courseObserver);
        //事件拆分 转换为两次 事件 交给观察者
        //throttleFirst 防抖动
    }

    private void compatExmaple() {
        /**
         * public class LiftAllTransformer implements Observable.Transformer<Integer, String> {
        @Override public Observable<String> call(Observable<Integer> observable) {
        return observable
        .lift1()
        .lift2()
        .lift3()
        .lift4();
        }
        }
         ...
         Transformer liftAll = new LiftAllTransformer();
         observable1.compose(liftAll).subscribe(subscriber1);
         observable2.compose(liftAll).subscribe(subscriber2);
         observable3.compose(liftAll).subscribe(subscriber3);
         observable4.compose(liftAll).subscribe(subscriber4);
         */
    }

    private void throttleFirstExmaple() {
//        RxView.clickEvents(button);
        /**
         throttleFirst(): 在每次事件触发后的一定时间间隔内丢弃新的事件。常用作去抖动过滤，例如按钮的点击监听器：
         RxView.clickEvents(button) // RxBinding 代码，后面的文章有解释 .throttleFirst(500, TimeUnit.MILLISECONDS)
         // 设置防抖间隔为 500ms .subscribe(subscriber);
         *
         */

    }

    /**
     * 仅做事例使用
     *
     * @param path
     * @return
     */
    private Drawable getBitMap(String path) {

        return null;
    }


    class Student {

        String name;
        ArrayList<Course> list = new ArrayList<>();

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Course> getList() {
            return list;
        }

        public void setList(ArrayList<Course> list) {
            this.list = list;
        }
    }

    class Course {
        String courseName;

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }
    }
}
