package com.relayr.processor;
import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import com.relayr.model.PricingModel;


@Component
public class DBWriter implements ItemWriter<PricingModel> {


	@Override
	public void write(List<? extends PricingModel> items) throws Exception {

		for (PricingModel pricingModel : items) {
			// Records insertion
		}
	}
}
