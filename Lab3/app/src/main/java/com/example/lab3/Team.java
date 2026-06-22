package com.example.lab3;

import java.io.Serializable;

public class Team implements Serializable {
    private String name;
    private String postalCode;
    private String drawableName;

    public Team(String name, String postalCode, String drawableName) {
        this.name = name;
        this.postalCode = postalCode;
        this.drawableName = drawableName;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getDrawableName() {
        return drawableName;
    }
}
