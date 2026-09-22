package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private final List<T> parcels;
    private int currentWeight;
    private int maxWeight = 50;

    public ParcelBox() {
        this.parcels = new ArrayList<>();
        this.currentWeight = 0;
    }

    public int getCurrentWeight(){
        return currentWeight;
    }

    public boolean isFull(Parcel parcel){
        if (currentWeight + parcel.weight > maxWeight) {
            System.out.println(
                    "Предупреждение: Не удалось добавить посылку! " +
                            "Превышен максимальный вес коробки. " +
                            "Текущий вес: " + currentWeight + ", " +
                            "Вес посылки: " + parcel.weight + ", " +
                            "Лимит: " + maxWeight
            );
            return true;
        }
        else {
            return false;
        }
    }

    public void addParcel(T parcel) {
        if(isFull(parcel)) {
            return;
        }

        parcels.add(parcel);
        currentWeight += parcel.weight;
        parcels.add(parcel);
        System.out.println("Посылка успешно добавлена. Новый общий вес: " + currentWeight);
    }

    public List<T> getAllParcels() {
        return parcels;
    }

    public int getMaxWeight(){
        return maxWeight;
    }
}
