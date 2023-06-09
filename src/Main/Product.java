/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author cdsi2
 */
public class Product {
    private int id;
    private String name;
    private String brand;
    private double price;
    
    public Product(int id, String name, String brand, double price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }    
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", brand=" + brand + ", price=" + price +"]";
    }
}