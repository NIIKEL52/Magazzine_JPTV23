package models;

public class Car {
    private String model;
    private double price;
    private boolean isSold;
    private Customer buyer; // Поле для хранения покупателя

    public Car(String model, double price) {
        this.model = model;
        this.price = price;
        this.isSold = false;
        this.buyer = null;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }

    public Customer getBuyer() {
        return buyer;
    }

    public void sellTo(Customer buyer) {
        this.isSold = true;
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "Модель: " + model + ", Цена: " + price + ", Статус: " + (isSold ? "Продано покупателю " + buyer.getName() : "В наличии");
    }
}

