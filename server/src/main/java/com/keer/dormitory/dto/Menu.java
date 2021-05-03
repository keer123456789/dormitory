package com.keer.dormitory.dto;

public class Menu {
    private String name;
    private String value;

    public Menu(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Menu() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
