/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.floormasteryproject.DTO;

import java.util.Objects;

/**
 *
 * @author apprentice
 */
public class Order {
    private Product product = new Product();
    private Tax taxes = new Tax();
    
    private String orderNumber = "0";
    private String customerName;
    private double area;
    private double laborCost;
    private double taxesTotal;
    private double materialCost;
    private double total;

       
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Tax getTaxes() {
        return taxes;
    }

    public void setTaxes(Tax taxes) {
        this.taxes = taxes;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public double getTaxesTotal() {
        return taxesTotal;
    }

    public void setTaxesTotal(double taxesTotal) {
        this.taxesTotal = taxesTotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        this.materialCost = materialCost;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.product);
        hash = 79 * hash + Objects.hashCode(this.taxes);
        hash = 79 * hash + Objects.hashCode(this.orderNumber);
        hash = 79 * hash + Objects.hashCode(this.customerName);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.area) ^ (Double.doubleToLongBits(this.area) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.laborCost) ^ (Double.doubleToLongBits(this.laborCost) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.taxesTotal) ^ (Double.doubleToLongBits(this.taxesTotal) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.materialCost) ^ (Double.doubleToLongBits(this.materialCost) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.total) ^ (Double.doubleToLongBits(this.total) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.product, other.product)) {
            return false;
        }
        if (!Objects.equals(this.taxes, other.taxes)) {
            return false;
        }
        if (!Objects.equals(this.orderNumber, other.orderNumber)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (Double.doubleToLongBits(this.area) != Double.doubleToLongBits(other.area)) {
            return false;
        }
        if (Double.doubleToLongBits(this.laborCost) != Double.doubleToLongBits(other.laborCost)) {
            return false;
        }
        if (Double.doubleToLongBits(this.taxesTotal) != Double.doubleToLongBits(other.taxesTotal)) {
            return false;
        }
        if (Double.doubleToLongBits(this.materialCost) != Double.doubleToLongBits(other.materialCost)) {
            return false;
        }
        if (Double.doubleToLongBits(this.total) != Double.doubleToLongBits(other.total)) {
            return false;
        }
        return true;
    }
    
    
}
