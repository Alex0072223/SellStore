package com.company.sellstore.screen.retailer;

import io.jmix.ui.screen.*;
import com.company.sellstore.entity.Retailer;

@UiController("Retailer.edit")
@UiDescriptor("retailer-edit.xml")
@EditedEntityContainer("retailerDc")
public class RetailerEdit extends StandardEditor<Retailer> {
}