package com.company.sellstore.app;

import com.company.sellstore.entity.Buying;
import com.company.sellstore.entity.SellPosition;
import io.jmix.core.DataManager;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BuyingService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(BuyingService.class);
    @Autowired
    private DataManager dataManager;

/*

    public  List<SellPosition> loadByFullQuery(int gg) {
        log.info("SSSSSSSSSSSSSSSSSSSSSSSS");
        return dataManager.load(SellPosition.class)
                .query("select c from SellPosition c where c.count = " + gg)
                .list().;
    }
*/

   /* public List<SellPosition> loadByCondition(int gg) {
        log.info(String.valueOf(dataManager.load(SellPosition.class)
                .condition(PropertyCondition.contains("count", gg))
                .list()));
        log.info("SSSSSSSSSSSSSSSSSSSSSSSS");
        return dataManager.load(SellPosition.class)
                .condition(PropertyCondition.contains("count", gg))
                .list();
    }*/


    /*public SellPosition count(SellPosition gg){


       *//* dataManager.loadValues("select e from SellPosition e ");


        dataManager.loadValues("select e from SellPosition e where e.count= " + gg);
        log.info("SSSSSSSSSSSSSSSSSSS");
        log.info(String.valueOf(dataManager.loadValues("select e from SellPosition e where e.count= " + gg)));
        log.info("SSSSSSSSSSSSSSSSSSS");
        System.out.println("SSSSSSSSSSSSSSSSSS");
        System.out.println("SSSSSSSSSSSSSSSSS");*//*

        dataManager.load(SellPosition.class)
                .query("select c.count from SellPosition c where c.retailer=" + gg)
                .list();
        return dataManager.loadValues("select e.count from SellPosition e where e.retailer= " + gg);
    }*/

    public List<SellPosition> fetchSell(){
        List<SellPosition> cache = dataManager.load(SellPosition.class).all().fetchPlan("sellPosition-fetch-plan").list();
        List<SellPosition> positionList = cache.stream().map(cach -> {
            SellPosition stat = dataManager.create(SellPosition.class);
            stat.setId(cach.getId());
            stat.setRetailer(cach.getRetailer());
            stat.setCount(cach.getCount());
            return stat;
        }).collect(Collectors.toList());
        return positionList;
    }

    public Integer getCountFrom(Integer gg){
        return dataManager.loadValue("select e.count from SellPosition e " +
                "where e.count = :cc", Integer.class)
                .parameter("cc", gg)
                .one();

    }

    public void updateAfterBuy(Integer ggg, UUID gggg){

        SellPosition sp = dataManager.load(SellPosition.class).id(gggg).one();
        sp.setCount(sp.getCount() - ggg);
        dataManager.save(sp);

        /*SellPosition sp = dataManager.load(SellPosition.class).query("select r from SellPosition r where r.retailer = :idd", UUID.class)
                        .parameter("idd", gggg)
                        .one();*/
/*
        System.out.println(sp.getCount());
        System.out.println(ggg);

        sp.setCount(sp.getCount()-ggg);
        System.out.println(sp.getCount());

        dataManager.save(sp);*/

        /*dataManager.load(SellPosition.class).query("update SellPosition c  set c.count = c.count - :ggg where c.retailer.id = :gggg",
                        Integer.class, UUID.class)
                .parameter("ggg", ggg)
                .parameter("gggg", gggg)
                .one();*/
        /*dataManager.save( dataManager.load(SellPosition.class).query("update SellPosition c  set c.count = c.count - :ggg where c.retailer = :gggg",
                        Integer.class, UUID.class)
                .parameter("ggg", ggg)
                .parameter("gggg", gggg)
                .one());*/
    }


   /* public List<SellPosition> count(SellPosition gg){

   ///////////////
   return dataManager.loadValue("select e.count from SellPosition e " +
                "where e.count = :cc", Integer.class)
                .parameter("cc", gg)
                .one();
                //////


        return dataManager.load(SellPosition.class)
                .query("select c.count from SellPosition c where c.retailer=" + gg)
                .list();
        *//*return dataManager.loadValues("select e.count from SellPosition e where e.retailer= " + gg);*//*
    }*/
}