package com.devsuperior.dsmeta.dto;


import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;
import com.devsuperior.dsmeta.repositories.projection.SummaryProjection;

public class SaleSummaryDTO {

    private String sellerName;
    private Double total;

    public SaleSummaryDTO(String sellerName, Double total) {
        this.sellerName = sellerName;
        this.total = total;
    }

    public SaleSummaryDTO() {
    }

    public SaleSummaryDTO(Sale sale) {
        sellerName = sale.getSeller().getName();
    }

    public SaleSummaryDTO(SummaryProjection summary) {
        this.sellerName = summary.getSellerName();
        this.total = summary.getTotal();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
