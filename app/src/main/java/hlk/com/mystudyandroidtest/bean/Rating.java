package hlk.com.mystudyandroidtest.bean;

/**
 * Created by user on 2017/2/27.
 */

public class Rating {
    private double average;

    private int max;

    private int min;

    private String stars;

    public void setAverage(double average){
        this.average = average;
    }
    public double getAverage(){
        return this.average;
    }
    public void setMax(int max){
        this.max = max;
    }
    public int getMax(){
        return this.max;
    }
    public void setMin(int min){
        this.min = min;
    }
    public int getMin(){
        return this.min;
    }
    public void setStars(String stars){
        this.stars = stars;
    }
    public String getStars(){
        return this.stars;
    }
}
