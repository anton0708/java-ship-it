package ru.yandex.practicum.delivery;

public abstract class Parcel {

    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected static int sendDay;

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public abstract int getCost();

    public int calculateDeliveryCost() {
        return weight * getCost();
    }


}
