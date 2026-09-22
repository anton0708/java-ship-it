package ru.yandex.practicum.delivery;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PerishableParcelTest {

    @Test
    void isExpiredTest() {
        PerishableParcel perishableParcel = new PerishableParcel("description", 10,
                "deliveryAddress", 4);
        assertFalse(perishableParcel.isExpired(2));
        assertTrue(perishableParcel.isExpired(5));
    }


}