package lr7.task7;

import java.io.Serializable;
import java.util.Objects;

public class Cars implements Serializable {
    private String model;

    private int price;

    private boolean isAutomatic;

    public Cars(String model, int price, boolean isAutomatic) {
        this.model = model;
        this.price = price;
        this.isAutomatic = isAutomatic;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "model='" + model + '\'' +
                ", price=" + price +
                ", isAutomatic=" + isAutomatic +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return price == cars.price && isAutomatic == cars.isAutomatic && Objects.equals(model, cars.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, price, isAutomatic);
    }
}