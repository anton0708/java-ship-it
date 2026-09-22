package ru.yandex.practicum.delivery;

public abstract class Parcel {

    public String description;
    public int weight;
    public String deliveryAddress;
    public static int sendDay;

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public abstract int calculateDeliveryCost();


}
