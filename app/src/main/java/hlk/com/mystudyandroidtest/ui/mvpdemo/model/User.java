package hlk.com.mystudyandroidtest.ui.mvpdemo.model;

import java.io.Serializable;

/**
 * Created by user on 2017/3/8.
 */

public class User implements Serializable{
    private String name;
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
