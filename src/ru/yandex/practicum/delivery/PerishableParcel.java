package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel{

    private int timeToLive;
    private static final int COST = 3;

    public PerishableParcel(String description, int weight, String deliveryAddress, int timeToLive){
        super.description = description;
        super.weight = weight;
        super.deliveryAddress = deliveryAddress;
        this.timeToLive = timeToLive;
    }

    @Override
    public String toString() {
        return "PerishableParcel{" +
                "timeToLive=" + timeToLive +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }

    @Override
    public int getCost(){
        return COST;
    }

    public boolean isExpired(int currentDay){
        if (this.sendDay + timeToLive >= currentDay) {
            return false;
        }
        else {
            return true;
        }

    }
}
