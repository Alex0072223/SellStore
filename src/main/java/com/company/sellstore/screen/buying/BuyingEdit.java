package com.company.sellstore.screen.buying;

import io.jmix.ui.screen.*;
import com.company.sellstore.entity.Buying;

@UiController("Buying.edit")
@UiDescriptor("buying-edit.xml")
@EditedEntityContainer("buyingDc")
public class BuyingEdit extends StandardEditor<Buying> {
}