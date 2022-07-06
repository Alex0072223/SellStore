package com.company.sellstore.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "RETAILER", indexes = {
        @Index(name = "IDX_RETAILER_NAME_ID", columnList = "NAME_ID")
})
@Entity
public class Retailer {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @NotNull
    @JoinColumn(name = "NAME_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User name;

    @Column(name = "ADRESS", nullable = false)
    @NotNull
    private String adress;

    @Column(name = "PHONE", length = 20)
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public User getName() {
        return name;
    }

    public void setName(User name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}