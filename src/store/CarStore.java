package store;

import models.Car;
import models.Employee;
import models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CarStore {
    private List<Car> cars;
    private List<Car> soldCars;
    private Employee employee;

    public CarStore(Employee employee) {
        this.cars = new ArrayList<>();
        this.soldCars = new ArrayList<>();
        this.employee = employee;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void listAvailableCars() {
        System.out.println("Доступные автомобили:");
        for (Car car : cars) {
            if (!car.isSold()) {
                System.out.println(car);
            }
        }
    }

    public void listSoldCars() {
        System.out.println("Проданные автомобили:");
        for (Car car : soldCars) {
            System.out.println(car);
        }
    }

    public void sellCar(String model, Customer buyer) {
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && !car.isSold()) {
                car.sellTo(buyer);
                soldCars.add(car);
                System.out.println("Автомобиль " + model + " продан покупателю " + buyer.getName() + "!");
                return;
            }
        }
        System.out.println("Автомобиль не найден или уже продан.");
    }

    public void showEmployeeInfo() {
        System.out.println(employee);
    }
}

