package hiber.model;

import javax.persistence.*;

@Embeddable
public class Car {

    private int series;

    private String model;



    public Car() {
    }

    public Car(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    @Override
    public String toString() {
        return "Car { " +
                " model = " + model +
                ", series = " + series + '}';
    }
}