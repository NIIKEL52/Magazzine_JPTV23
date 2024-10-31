
import models.Car;
import models.Employee;
import models.Customer;
import store.CarStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee("Иван Иванов", "Менеджер по продажам");
        CarStore carStore = new CarStore(employee);

        // Добавляем несколько машин в магазин
        carStore.addCar(new Car("Nissan Silvia", 30000));
        carStore.addCar(new Car("Land Cruiser 300", 28000));
        carStore.addCar(new Car("Mercedes AMG G63", 40000));

        while (true) {
            System.out.println("\n--- Магазин Автомобилей ---");
            System.out.println("1. Список доступных машин");
            System.out.println("2. Покупка машины");
            System.out.println("3. Список проданных машин");
            System.out.println("4. Информация о сотруднике");
            System.out.println("5. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            switch (choice) {
                case 1:
                    carStore.listAvailableCars();
                    break;
                case 2:
                    System.out.print("Введите модель машины для покупки: ");
                    String model = scanner.nextLine();

                    System.out.print("Введите имя покупателя: ");
                    String customerName = scanner.nextLine();

                    System.out.print("Введите контактные данные покупателя: ");
                    String contactInfo = scanner.nextLine();

                    Customer buyer = new Customer(customerName, contactInfo);
                    carStore.sellCar(model, buyer);
                    break;
                case 3:
                    carStore.listSoldCars();
                    break;
                case 4:
                    carStore.showEmployeeInfo();
                    break;
                case 5:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
                    break;
            }
        }
    }
}

