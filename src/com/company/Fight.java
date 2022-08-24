package com.company;

import java.util.Random;
import java.util.Scanner;

public class Fight {
    private String[] actionArr = {"quick attack", "normal attack", "blessed attack"};
    private String[] respArr = {"But it was missed.", "A successful hit!"};
    public Player player;
    private int enemyHP;

    public Fight(Player player, int enemyHP) {
        this.player = player;
        this.enemyHP = enemyHP;
    }

    public void fightBegins() {
        System.out.println("A challenger approaches!");
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int tempHP = player.healthP;
        int tempMP = player.manaP;
        int rnJesus = -1;

        while(true) {
            int gameState = -2; //-2: Fight continues, -1: You lost, exit the game, 0: resting 1 turn, 1: You won
            gameState = checkStats();
            if(gameState == -1) {
                System.out.println("Restart the program to play again.");
                System.exit(1);
            } else if(gameState == 1) {
                System.out.println("You leveled up!");
                player.healthP = tempHP; //Refresh the health and mana after winning
                player.manaP = tempMP;
                player.levelUp(); //Level up the player
                break;
            } else if(gameState == -2) { //Continue fighting
                rnJesus = rand.nextInt(101);
                int action = -1;
                do {
                    System.out.println("What will you do?\n" +
                            "1 -> Quick Attack          2 -> Normal Attack\n" +
                            "3 -> Blessed Attack");
                    action = input.nextInt();
                    if(action < 0 || action > 3) {
                        System.out.println("Invalid Attack, try again.");
                    } else {
                        break;
                    }
                }while(action < 0 || action > 3);
                System.out.println("You used " + actionArr[action-1]);
                switch(action) {
                    case 1: //Quick attack: 80% chance of hitting 60% of the players total attack
                        //consumes 15 mana
                        player.manaP -= 15;
                        if(rnJesus < 80) {
                            System.out.println(respArr[1]);
                            enemyHP -= (player.atkP + player.splP) * 6/10;
                            System.out.println("Your enemy has " + enemyHP + " HP left.");
                        } else {
                            System.out.println(respArr[0]);
                        }
                        break;
                    case 2: //Normal attack: 60% chance of hitting 100% of the players total attack
                        //consumes 30 mana
                        player.manaP -= 30;
                        if(rnJesus < 60) {
                            System.out.println(respArr[1]);
                            enemyHP -= (player.atkP + player.splP);
                            System.out.println("Your enemy has " + enemyHP + " HP left.");
                        } else {
                            System.out.println(respArr[0]);
                        }
                        break;
                    case 3: //Blessed attack: 20% chance of hitting 200% of the players total attack
                        //consumes 50 mana
                        player.manaP -= 50;
                        if(rnJesus < 20) {
                            System.out.println(respArr[1]);
                            enemyHP -= (player.atkP + player.splP) * 2;
                            System.out.println("Your enemy has " + enemyHP + " HP left.");
                        } else {
                            System.out.println(respArr[0]);
                        }
                        break;
                }
            } else if(gameState == 0) {//Resting for one turn
                System.out.println("You rested for one turn. Your MP has been refilled");
                player.manaRefill(tempMP);
            } else {
                throw new InvalidGameStateException("Game State is unknown.");
            }
            //Add enemy turn
            System.out.println("Now it's your enemy's turn");
            rnJesus = rand.nextInt(101);
            if (rnJesus < 50) {
                System.out.println("A successful hit");
                player.healthP -= 10 * player.levelUpCount + 5;
                System.out.println("You have " + player.healthP + " HP left.");
            }
            else {
                System.out.println("It was missed.");
            }
        }

    }

    public int checkStats() {
        int result = -2;
        if(isPlayerDead()) {
            System.out.println("You lost! ;_;");
            result = -1;
            return result;
        } else if(isEnemyDead()) {
            System.out.println("You won! ^_^");
            result = 1;
            return result;
        } else if(isFatigue()) {
            System.out.println("You are exhausted, resting for one turn! >_<");
            result = 0;
            return result;
        }
        return result;
    }

    public boolean isPlayerDead() {
        if(player.healthP <= 0) {
            return true;
        } else return false;
    }

    public boolean isEnemyDead() {
        if(enemyHP <= 0) {
            return true;
        } else return false;
    }

    public boolean isFatigue() {
        if(player.manaP <= 0) {
            return true;
        } else return false;
    }
}

class InvalidGameStateException extends RuntimeException {
    public InvalidGameStateException(String err) {
        super(err);
    }
}
