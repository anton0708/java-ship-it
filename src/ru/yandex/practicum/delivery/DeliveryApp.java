package ru.yandex.practicum.delivery;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<FragileParcel> fragileReportList = new ArrayList<>();

    public static ParcelBox standartBox = new ParcelBox();
    public static ParcelBox fragileBox = new ParcelBox();
    public static ParcelBox perishableBox = new ParcelBox();


    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    showBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Отследить посылку");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Укажите тип посылки(1 - стандартная, 2 - хрупкая, 3 - скоропортящаяся):");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Укажите описание посылки:");
        String description = scanner.nextLine();

        System.out.println("Укажите вес посылки:");
        int weight = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Укажите адрес доставки посылки:");
        String address = scanner.nextLine();

        if(type == 1) {
            StandardParcel standardParcel = new StandardParcel(description, weight, address);
            allParcels.add(standardParcel);
            standartBox.addParcel(standardParcel);
        } else if (type == 2) {
            FragileParcel fragileParcel = new FragileParcel(description, weight, address);
            allParcels.add(fragileParcel);
            fragileReportList.add(fragileParcel);
            fragileBox.addParcel(fragileParcel);
        } else if (type == 3) {
            System.out.println("Укажите срок хранения:");
            int timeToLive = scanner.nextInt();
            scanner.nextLine();

            PerishableParcel perishableParcel = new PerishableParcel(description, weight, address, timeToLive);
            allParcels.add(perishableParcel);
            perishableBox.addParcel(perishableParcel);
        } else if (type == 4) {
            System.out.println("Укажите новую локацию:");
            String newLocation = scanner.nextLine();
        }
        System.out.println(allParcels);

    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for(Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        int allCost = 0;
        // Посчитать общую стоимость всех доставок и вывести на экран
        for(Parcel parcel : allParcels) {
            allCost = allCost + parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок равна: " + allCost);
    }

    private static void reportStatus() {
        System.out.println("Введите новую локацию:");
        String newLocation = scanner.nextLine();
        for(FragileParcel fragile : fragileReportList) {
            fragile.reportStatus(newLocation);
        }
    }

    private static void showBox() {
        System.out.println("Укажите какую коробку хоитте посмотреть(1 - стандартная, " +
                "2 - хрупкая, 3 - скоропортящаяся):");
        int boxShow = scanner.nextInt();
        scanner.nextLine();

        switch (boxShow) {
            case 1:
                System.out.println(standartBox.getAllParcels());
                break;
            case 2:
                System.out.println(fragileBox.getAllParcels());
                break;
            case 3:
                System.out.println(perishableBox.getAllParcels());
                break;

        }
    }

}