////////////////////////////////////////////////////////////////////
// [SIMONE] [FRANCONETTI] [1143567]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

public class MenuItem {
    private String name;
    private double price;

    public enum itemType {
        PANINI, FRITTI, BEVANDE
    }

    private itemType type;

    public MenuItem(itemType type, String name, double price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public itemType getType() {
        return type;
    }
}
