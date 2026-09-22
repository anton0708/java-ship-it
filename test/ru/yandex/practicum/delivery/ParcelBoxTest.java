package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParcelBoxTest {

    @Test
    public void testAddParcel_WhenWeightExceedsLimit_ParcelIsNotAdded() {

        ParcelBox<Parcel> box = new ParcelBox<>();

        Parcel heavyParcel1 = new StandardParcel("description1", 15,  "deliveryAddress");
        Parcel heavyParcel2 = new StandardParcel("description2", 45,  "deliveryAddress");

        int initialCount = box.getAllParcels().size();
        double initialWeight = box.getCurrentWeight();

        box.addParcel(heavyParcel1);

        assertEquals(15, box.getCurrentWeight());

        assertTrue(box.isFull(heavyParcel2));
    }

}