package es.merlinsoftware;

import es.merlinsoftware.pojo.ProductSales;
import es.merlinsoftware.pojo.ProductStock;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

    public static List<Long> sortProductsByScores(int stockWeight, int salesWeight,
                                                  List<ProductStock> productsStockInformation,
                                                  List<ProductSales> productsSalesInformation) {
        int sumWeight = stockWeight + salesWeight;
        double normalizedStockWeight = (double) stockWeight / sumWeight;
        double normalizedSalesWeight = (double) salesWeight / sumWeight;

        Map<Long, Double> weightedValues = new HashMap<>();

        productsStockInformation.forEach(ps -> weightedValues.put(ps.getProductId(), ps.getAvailableStock() * normalizedStockWeight));

        productsSalesInformation.forEach(ps -> {
                    Long productId = ps.getProductId();
                    weightedValues.put(productId, weightedValues.get(productId) + (ps.getSalesAmount() * normalizedSalesWeight));
                }
        );

        return weightedValues.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
