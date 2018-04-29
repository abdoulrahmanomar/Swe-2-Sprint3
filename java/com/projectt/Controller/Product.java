/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectt.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    int ProductID;
    String Name;
    int price;
    String Category;
    boolean add_by_owner;
    int num_of_view;
    int num_of_buy;

    public Product(Integer id, int ProductID, String Name, int price, String Category, boolean add_by_owner, int num_of_view, int num_of_buy) {
        this.id = id;
        this.ProductID = ProductID;
        this.Name = Name;
        this.price = price;
        this.Category = Category;
        this.add_by_owner = add_by_owner;
        this.num_of_view = num_of_view;
        this.num_of_buy = num_of_buy;
    }

    public int getNum_of_buy() {
        return num_of_buy;
    }

    public void setNum_of_buy(int num_of_buy) {
        this.num_of_buy = num_of_buy;
    }

    public Product() {
        id = null;
        ProductID = 0;
        Name = null;
        price = 0;
        Category = null;
        add_by_owner = false;
        num_of_view = 0;
        num_of_buy = 0;

    }

    public int getNum_of_view() {
        return num_of_view;
    }

    public void setNum_of_view(int num_of_view) {
        this.num_of_view = num_of_view;
    }

    public boolean getAdd_by_owner() {
        return add_by_owner;
    }

    public void setAdd_by_owner(boolean add_by_owner) {
        this.add_by_owner = add_by_owner;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }
}
