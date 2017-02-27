package hlk.com.mystudyandroidtest.bean;

import java.util.List;

/**
 * Created by user on 2017/2/27.
 */

public class Root {
    private int count;

    private int start;

    private List<Subjects> subjects;

    private String title;

    private int total;

    public void setCount(int count){
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setStart(int start){
        this.start = start;
    }
    public int getStart(){
        return this.start;
    }
    public void setSubjects(List<Subjects> subjects){
        this.subjects = subjects;
    }
    public List<Subjects> getSubjects(){
        return this.subjects;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }
}
