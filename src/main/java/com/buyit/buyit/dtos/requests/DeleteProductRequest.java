package com.buyit.buyit.dtos.requests;

public class DeleteProductRequest {

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    private Long productId;
}
