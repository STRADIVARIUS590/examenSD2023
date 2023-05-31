/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author cdsi2
 */
public class User {
    private int id;
    private String name;
    private String role;
    
    public User(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getRole() {
        return role;
    }
    
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", role=" + role + "]";
    }
}