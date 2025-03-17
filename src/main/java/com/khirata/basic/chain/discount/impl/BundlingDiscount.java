package com.khirata.basic.chain.discount.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.khirata.basic.chain.discount.Discount;
import com.khirata.basic.chain.discount.models.Item;
import com.khirata.basic.chain.discount.models.PriceEstimate;

public class BundlingDiscount implements Discount {

    private Discount next;

    public double calculateDiscount(PriceEstimate priceEstimate) {
        boolean hasPencil = hasItem("PENCIL", priceEstimate);
        boolean hasPen = hasItem("PEN", priceEstimate);

        if (hasPen && hasPencil) {
            return 1.00;
        }
        return next.calculateDiscount(priceEstimate);
    }

    public void setDiscount(Discount next) {
        this.next = next;
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
