package com.company.sellstore.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "DETAIL", indexes = {
        @Index(name = "IDX_DETAIL_SELL_POSITION_ID", columnList = "SELL_POSITION_ID")
})
@Entity
public class Detail {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "ARTICLE", nullable = false)
    @NotNull
    private String article;

    @JoinColumn(name = "SELL_POSITION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private SellPosition sellPosition;

    public SellPosition getSellPosition() {
        return sellPosition;
    }

    public Integer returnTrue(){return 1;}

    public void setSellPosition(SellPosition sellPosition) {
        this.sellPosition = sellPosition;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}