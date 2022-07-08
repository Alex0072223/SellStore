package com.company.sellstore.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@JmixEntity
@Table(name = "SELL_POSITION", indexes = {
        @Index(name = "IDX_SELLPOSITION_RETAILER_ID", columnList = "RETAILER_ID"),
        @Index(name = "IDX_SELLPOSITION_DETAIL_ID", columnList = "DETAIL_ID"),
})
@Entity
public class SellPosition {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @JoinColumn(name = "RETAILER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Retailer retailer;

    @JoinColumn(name = "DETAIL_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Detail detail;

    @Positive(message = "{msg://com.company.sellstore.entity/SellPosition.cost.validation.Positive}")
    @Column(name = "COST", nullable = false)
    @NotNull
    private Integer cost;

    @PositiveOrZero
    @Column(name = "COUNT_", nullable = false)
    @NotNull
    private Integer count;

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    public Retailer getRetailer() {
        return retailer;
    }

    public void setRetailer(Retailer retailer) {
        this.retailer = retailer;
    }

   /* @DependsOnProperties({"retailer", "cost"})
    @Transient
    @JmixProperty
    public String getDett() {
        StringBuilder sbb = new StringBuilder();
        if(retailer != null){
            sbb.append("[").append(cost).append("]");
        }
        sbb.append(cost);
        return sbb.toString();
    }*/

    /*@DependsOnProperties({"retailer", "detail"})
    @JmixProperty
    public String getCaption() {

        StringBuilder sb = new StringBuilder();
        if(detail != null){
            sb.append("[").append(detail.getName()).append("]");
        }
        sb.append(retailer);
        return sb.toString();
    }*/

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}