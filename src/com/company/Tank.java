package com.company;

public class Tank {
    static final String name = "T-34";
    static int tanksCounter;

    private int x, y;
    private int dir;
    private int fuel;
    private int n;


    public Tank() {
        this(0, 0, 100);
    }

    public Tank(int x, int y) {
        this(x, y, 100);
    }

    public Tank(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
        n = ++tanksCounter;
    }


    public void goForward(int move) {
        if (move < 0 ) {
            if (-move > fuel) { move = -fuel; }
        } else {
            if (move > fuel) { move = fuel; }
        }
        switch (dir) {
            case 0:
                x += move;
                break;
            case 1:
                y += move;
                break;
            case 2:
                x -= move;
                break;
            case 3:
                y -= move;
                break;
        }
        fuel -= Math.abs(move);
    }


    public void printPosition() {
        System.out.println("The Tank " + name + "-" + n + " is at " + x +", " + y + " now.");
    }

    public void turnLeft() {
        dir--;
        if (dir == -1) dir = 3;
    }

    public void turnRight() {
        dir++;
        if (dir == 4) dir = 0;
    }

    public void goBackward(int i) {
        goForward(-i);
    }
}
