package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.Parcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeliveryCostTest {
    @Test
    void calculateDeliveryCost() {
        Parcel standartParcel = new StandardParcel("description", 10,
                "deliveryAddress");
        Parcel fragileParcel = new FragileParcel("description", 10,
                "deliveryAddress");
        Parcel perishableParcel = new PerishableParcel("description", 10,
                "deliveryAddress", 2);
        assertEquals(20, standartParcel.calculateDeliveryCost());
        assertEquals(40, fragileParcel.calculateDeliveryCost());
        assertEquals(30, perishableParcel.calculateDeliveryCost());
    }
}
