package es.merlinsoftware.pojo;

public class ProductSales {
    Long productId;
    Double salesAmount;

    public ProductSales(Long productId, Double salesAmount) {
        this.productId = productId;
        this.salesAmount = salesAmount;
    }

    public Long getProductId() {
        return productId;
    }

    public Double getSalesAmount() {
        return salesAmount;
    }
}
