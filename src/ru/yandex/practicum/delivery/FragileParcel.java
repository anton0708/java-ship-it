package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {

    private static final int COST = 4;

    public FragileParcel(String description, int weight, String deliveryAddress){
        super.description = description;
        super.weight = weight;
        super.deliveryAddress = deliveryAddress;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        System.out.println("Посылка " + description + " упакована");
    }

    @Override
    public int getCost(){
        return COST;
    }

    @Override
    public String toString() {
        return "FragileParcel{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + deliveryAddress + " изменила местоположение на " + newLocation);
    };
}
