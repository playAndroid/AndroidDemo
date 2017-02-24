package hlk.com.mystudyandroidtest.designmode.buildermode;

/**
 * builder mode
 * Created by user on 2017/2/24.
 */

public class BuilderMode {
    /**
     * Builder模式的要点就是通过一个代理来完成对象的构建过程。这个代理职责就是完成构建的各个步骤，同时它也是易扩展的。
     * <p>
     * 可以避免传参数不知道对应哪个字段、修改参数类型容易对应错的问题
     * <p>
     * 保证了一致性、灵活性的Builder对象：
     */

    public void test() {
        DoDoContact doContact = new DoDoContact.Builder("haha").setAge(12).setSex("girl").build();
    }

}
