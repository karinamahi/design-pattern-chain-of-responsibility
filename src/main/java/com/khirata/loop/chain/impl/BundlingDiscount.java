package com.khirata.loop.chain.impl;

import com.khirata.loop.chain.Discount;
import com.khirata.loop.chain.models.Item;
import com.khirata.loop.chain.models.PriceEstimate;

import java.util.List;
import java.util.stream.Collectors;

public class BundlingDiscount implements Discount {

    public double calculateDiscount(PriceEstimate priceEstimate) {
        boolean hasPencil = hasItem("PENCIL", priceEstimate);
        boolean hasPen = hasItem("PEN", priceEstimate);

        if (hasPen && hasPencil) {
            return 1.00;
        }
        return 0.0;
    }

    private boolean hasItem(String itemName, PriceEstimate priceEstimate) {
        List<Item> list = priceEstimate
				.getItens()
					.stream()
					.filter(item -> itemName.equalsIgnoreCase(item.getName()))
					.collect(Collectors.toList());

        if (list == null || list.size() == 0) return false;
        return true;
    }
}
