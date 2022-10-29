package com.platzi.platzimarket.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


public class Category {

    private int categoryId;

    private String category;

    private boolean active;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
