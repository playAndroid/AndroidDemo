package hlk.com.mystudyandroidtest.designmode.buildermode;

/**
 * Created by user on 2017/2/24.
 */

public class DoDoContact {
    private String name;
    private int age;
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private DoDoContact(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static class Builder {
        private String name;
        private int age;
        private String sex;

        public Builder(String name) {
            this.name = name;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public DoDoContact build() {

            return new DoDoContact(this);
        }
    }
}
