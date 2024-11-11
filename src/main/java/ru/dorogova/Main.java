package ru.dorogova;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int doors = 3;
        int attempts = 1000;
        Paradox paradox = new Paradox(new HashMap<Integer, Boolean>(), new HashMap<Integer, Boolean>(), doors, attempts);
        paradox.gameStart();
    }
}