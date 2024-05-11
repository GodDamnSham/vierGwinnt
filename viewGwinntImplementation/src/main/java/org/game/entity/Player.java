package org.game.entity;

public class Player {
    String name;
    char c;

    public Player(String name, char c) {
        this.name = name;
        this.c=c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }
}
