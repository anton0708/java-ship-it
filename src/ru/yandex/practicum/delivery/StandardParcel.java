package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{

    public static int COST = 2;

    public StandardParcel(String description, int weight, String deliveryAddress){
        super.description = description;
        super.weight = weight;
        super.deliveryAddress = deliveryAddress;
    }

    @Override
    public int calculateDeliveryCost(){
        int cost = weight * COST;
        return cost;
    }

    @Override
    public String toString() {
        return "StandardParcel{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }
}
