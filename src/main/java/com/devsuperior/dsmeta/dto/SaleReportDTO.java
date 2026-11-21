package com.devsuperior.dsmeta.dto;


import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SaleReportDTO {

    private Long id;
    private LocalDate date;
    private Double amount;
    private String sellerName;

    public SaleReportDTO(Double amount, LocalDate date, Long id, String sellerName) {
        this.amount = amount;
        this.date = date;
        this.id = id;
        this.sellerName = sellerName;
    }

    public SaleReportDTO() {
    }

    public SaleReportDTO(Sale sale) {
        id = sale.getId();
        date = sale.getDate();
        amount = sale.getAmount();
        sellerName = sale.getSeller().getName();
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
