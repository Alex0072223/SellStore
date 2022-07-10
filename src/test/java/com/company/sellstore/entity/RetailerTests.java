package com.company.sellstore.entity;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;

public class RetailerTests {
    private String address = "addr";
    private String phone = "00112233445566778899";
    private User name = mock(User.class);
    private Retailer retailer = new Retailer();

    @Test
    void nameTest() {
        retailer.setName(name);
        assertThat(retailer.getName()).isEqualTo(name);
    }

    @Test
    void addressTest() {
        retailer.setAdress(address);
        assertThat(retailer.getAdress()).isEqualTo(address);
    }
    @Test
    void phoneTest() {
        retailer.setPhone(phone);
        assertThat(retailer.getPhone()).isEqualTo(phone);
    }
}
