//package com.company;

public abstract class Player {
    public int atkP = 10;
    public int splP = 10;
    public int manaP = 100;
    public int healthP = 100;
    public int levelUpCount = 1;
    public int tribeCount = 0;


    abstract boolean manaRefill(int amount);

    public void levelUp() {
        atkP += (atkP / 2) * levelUpCount;
        splP += (splP / 2) * levelUpCount;
        manaP += (manaP / 2) * levelUpCount;
        healthP += (healthP / 2) * levelUpCount;
        levelUpCount++;
    }
}



class Warrior extends Player {

    public Warrior() {
        super();
        super.atkP += 110;
        super.splP -= 10;
        super.manaP -= 25;
        super.healthP += 25;
        super.tribeCount = 3;
    }
    @Override
    public boolean manaRefill(int amount) {
        if (manaP < 0) {
            manaP += amount;
            return true;
        } else
            return false;
    }
}

class Sorcerer extends Player {
    public Sorcerer() {
        super();
        super.atkP -= 10;
        super.splP += 110;
        super.manaP += 100;
        super.healthP += 5;
        super.tribeCount = 2;
    }
    @Override
    public boolean manaRefill(int amount) {
        if (manaP <= 0) {
            manaP += amount;
            return true;
        } else
            return false;
    }
}

class Knight extends Player {
    public Knight() {
        super();
        super.atkP += 80;
        super.splP += 10;
        super.tribeCount = 1;
    }
    @Override
    public boolean manaRefill(int amount) {
        if (manaP <= 0) {
            manaP += amount;
            return true;
        } else
            return false;
    }
}