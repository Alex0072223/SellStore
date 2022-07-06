package com.company.sellstore.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@JmixEntity
@Table(name = "BUYING", indexes = {
        @Index(name = "IDX_BUYING_SELL_POSITION_ID", columnList = "SELL_POSITION_ID")
})
@Entity
public class Buying {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "SELL_POSITION_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private SellPosition sellPosition;

    @Column(name = "COUNT_", nullable = false)
    @NotNull
    private Integer count;

    @Column(name = "DATE_OF_BUYING", nullable = false)
    @NotNull
    private LocalDate dateOfBuying;

    public LocalDate getDateOfBuying() {
        return dateOfBuying;
    }

    public void setDateOfBuying(LocalDate dateOfBuying) {
        this.dateOfBuying = dateOfBuying;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public SellPosition getSellPosition() {
        return sellPosition;
    }

    public void setSellPosition(SellPosition sellPosition) {
        this.sellPosition = sellPosition;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}