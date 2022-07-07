package com.company.sellstore.screen.buying;

import com.company.sellstore.app.BuyingService;
import com.company.sellstore.entity.Detail;
import com.company.sellstore.entity.SellPosition;
import io.jmix.core.DataManager;
import io.jmix.core.FluentValuesLoader;
import io.jmix.ui.Dialogs;
import io.jmix.ui.action.DialogAction;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.*;
import com.company.sellstore.entity.Buying;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.IntrospectionException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@UiController("Buying.edit")
@UiDescriptor("buying-edit.xml")
@EditedEntityContainer("buyingDc")
public class BuyingEdit extends StandardEditor<Buying> {
    private static final Logger log = LoggerFactory.getLogger(BuyingEdit.class);

    @Autowired
    private DataManager dataManager;
    @Autowired
    private BuyingService buyingService;
    @Autowired
    private Dialogs dialogs;
    int countOfDetailsFromRetailer, countOfDetailsFromCustomer;
    UUID f;






    @Subscribe(id = "buyingDc", target = Target.DATA_CONTAINER)
    public void onBuyingDcItemChange(InstanceContainer.ItemChangeEvent<Buying> event) {

        //sellPositionsDl.load();

    }


    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {


        if (countOfDetailsFromCustomer > countOfDetailsFromRetailer) {
            dialogs.createOptionDialog()
                    .withCaption("Error!")
                    .withMessage("Нельзя купить больше деталей чем имеется!")
                    .withActions(
                            /*new DialogAction(DialogAction.Type.OK).withHandler(e -> {
                                event.resume();
                            }),*/
                            new DialogAction(DialogAction.Type.OK)
                    )
                    .show();
            event.preventCommit();
        }
        else {
            buyingService.updateAfterBuy(countOfDetailsFromCustomer, f);
            log.info("sssiy");
        }
    }

    @Subscribe("countField")
    public void onCountFieldValueChange(HasValue.ValueChangeEvent<Integer> event) {


        countOfDetailsFromCustomer =  event.getValue();

        /*buyingService.getCountFrom(event.getValue());
        System.out.println( buyingService.getCountFrom(event.getValue()));
        System.out.println("asdasdasdsa"+j);
        System.out.println("asdasdasdsa"+k);*/




       /*buyingService.loadByFullQuery(event.getValue());
        System.out.println(buyingService.loadByFullQuery(event.getValue()).get(event.getValue()));
        log.info(String.valueOf(buyingService.loadByFullQuery(event.getValue()).get(event.getValue())));
        System.out.println(buyingService.loadByFullQuery(event.getValue()).get(event.getValue()));
        log.info("qqqqqqqqqqqqqqqqqqqq");
        log.info("qqqqqqqqqqqqqqqqqqqq");*/

       // buyingService.count(event.getValue());

        /*log.info(String.valueOf(dataManager.loadValues("select e from SellPosition e where e.count=" + event.getValue())));
        log.info("qqqqqqqqqqqqqqqqqqqq");

        log.info("qqqqqqqqqqqqqqqqqqqq");*/

        //FluentValuesLoader q = dataManager.loadValues("select e from Buying e where e.sellPosition.count=" + event.getValue());
       /* int foo = Integer.parseInt(String.valueOf(q));

        if(event.getValue() < foo){
            log.info("qqqqqqqqqqqqqqqqqqqq");
            log.info("qqqqqqqqqqqqqqqqqqqq");
            log.info("qqqqqqqqqqqqqqqqqqqq");
            log.info("qqqqqqqqqqqqqqqqqqqq");
            log.info("qqqqqqqqqqqqqqqqqqqq");
            System.out.println("qqqqqqqqqqqqqqqqqqqq");
            System.out.println("qqqqqqqqqqqqqqqqqqqq");
            System.out.println("qqqqqqqqqqqqqqqqqqqq");
            System.out.println("qqqqqqqqqqqqqqqqqqqq");

        }*/





    }

    @Subscribe("sellPositionField")
    public void onSellPositionFieldValueChange(HasValue.ValueChangeEvent<SellPosition> event) {
       // buyingService.getCountFrom(event.getValue().getRetailer().getId());
        f = Objects.requireNonNull(event.getValue()).getId();
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPP");

        System.out.println(f);
        System.out.println(event.getValue().getId());
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPP");

        log.info(String.valueOf(f));
        log.info(String.valueOf(event.getValue().getId()));
        System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPPP");

        countOfDetailsFromRetailer = buyingService.getCountFrom(event.getValue().getCount());


        //System.out.println( buyingService.getCountFrom(event.getValue().getCount()));


      //  buyingService.count(event.getValue());
       //log.info(String.valueOf(event.getValue()));

    }
}