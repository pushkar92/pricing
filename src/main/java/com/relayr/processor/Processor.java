package com.relayr.processor;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.relayr.model.PricingModel;

@Component
public class Processor implements ItemProcessor<PricingModel, PricingModel> {

    @Override
    public PricingModel process(PricingModel payment) throws Exception {
        return payment;
    }
}
