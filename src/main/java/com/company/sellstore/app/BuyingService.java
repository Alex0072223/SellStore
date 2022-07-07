package com.company.sellstore.app;

import com.company.sellstore.entity.Buying;
import com.company.sellstore.entity.SellPosition;
import io.jmix.core.DataManager;
import io.jmix.core.Id;
import io.jmix.core.querycondition.PropertyCondition;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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

    List<Buying> loadByCondition(int gg) {
        return dataManager.load(Buying.class)
                .condition(PropertyCondition.contains("count", gg))
                .list();
    }


    public void count(int gg){
       /* dataManager.loadValues("select e from SellPosition e ");






        dataManager.loadValues("select e from SellPosition e where e.count= " + gg);
        log.info("SSSSSSSSSSSSSSSSSSS");
        log.info(String.valueOf(dataManager.loadValues("select e from SellPosition e where e.count= " + gg)));
        log.info("SSSSSSSSSSSSSSSSSSS");
        System.out.println("SSSSSSSSSSSSSSSSSS");
        System.out.println("SSSSSSSSSSSSSSSSS");*/

       /* dataManager.load(SellPosition.class)
                .query("select c from SellPosition c where c.email like :email ")
                .parameter("email", "%@company.com")
                .parameter("grade", CustomerGrade.PLATINUM)
                .list();*/
    }
}