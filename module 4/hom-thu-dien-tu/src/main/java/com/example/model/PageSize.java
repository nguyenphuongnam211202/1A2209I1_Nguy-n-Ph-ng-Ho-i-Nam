package com.example.model;

public class PageSize {
    private int idPageSize;

    private int numPageSize;

    public PageSize(int idPageSize, int numPageSize) {
        this.idPageSize = idPageSize;
        this.numPageSize = numPageSize;
    }

    public int getIdPageSize() {
        return idPageSize;
    }

    public void setIdPageSize(int idPageSize) {
        this.idPageSize = idPageSize;
    }

    public int getNumPageSize() {
        return numPageSize;
    }

    public void setNumPageSize(int numPageSize) {
        this.numPageSize = numPageSize;
    }
}
