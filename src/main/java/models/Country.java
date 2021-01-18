/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author psn
 */
public class Country {
    
    private String name;
    private String ISO;

    public Country() {
    }

    public Country(String name, String ISO) {
        this.name = name;
        this.ISO = ISO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISO() {
        return ISO;
    }

    public void setISO(String ISO) {
        this.ISO = ISO;
    }

    @Override
    public String toString() {
        return "" + name + " : " + ISO;
    }

    
    
    
}
