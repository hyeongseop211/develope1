package com.boot.dto;

public class WishlistCriteriaDTO {
    private int page = 1;
    private int amount = 10;

    public int getStartRow() {
        return (page - 1) * amount;
    }

    //getter, setter
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page <= 0 ? 1 : page; }
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }
}
