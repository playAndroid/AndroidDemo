package hlk.com.mystudyandroidtest.bean;

/**
 * Created by user on 2017/2/27.
 */

public class Directors {
    private String alt;

    private Avatars avatars;

    private String id;

    private String name;

    public void setAlt(String alt){
        this.alt = alt;
    }
    public String getAlt(){
        return this.alt;
    }
    public void setAvatars(Avatars avatars){
        this.avatars = avatars;
    }
    public Avatars getAvatars(){
        return this.avatars;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getId(){
        return this.id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
}
