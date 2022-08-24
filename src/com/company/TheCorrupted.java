/**
 * @author Yener Karaca
 * @since 09.12.2021
 */
package com.company;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TheCorrupted {

    public static void main(String[] args) throws InterruptedException {
        Player player = null;

        printWithDelays(Acts.startingText, TimeUnit.MILLISECONDS, 50);
        Thread.sleep(1000);
        player = createUser(player);
        printWithDelays(Acts.act1(player), TimeUnit.MILLISECONDS, 100);
        //First fight happens
        Fight fight1 = new Fight(player, 500);
        fight1.fightBegins();
        printWithDelays(Acts.act2(), TimeUnit.MILLISECONDS, 100);
        //Second fight happens
        Fight fight2 = new Fight(player, 1000);
        fight2.fightBegins();
        printWithDelays(Acts.act3(), TimeUnit.MILLISECONDS, 100);
        Fight fight3 = new Fight(player, 6666);
        printWithDelays(Acts.finalAct(), TimeUnit.MILLISECONDS, 100);
        Scanner yon = new Scanner(System.in);
        int resp = -1;
        do {
            resp = yon.nextInt();
            if(resp < 0 || resp > 1) {
                System.out.println("Invalid option, try again.");
            }
        } while(resp < 0 || resp > 1);
        if(resp == 0) {
            System.out.println("You decided not to save the Gatholla, you were fascinated by it's power and decided\n" +
                    "to use it on yourself. You've put it on and waited. And suddenly devil's body perished.\n" +
                    "Just as you were wondering what happened to him you started to transform. Your skin became dark\n" +
                    "flames, it caused you a lot of pain that you've lost consciousness. You felt the devil's presence\n"
                    +"inside you. Now you've realized, this greed of yours has turned you into the devil himself...\n" +
                    "THE END");
        }
        else {
            System.out.println("You decided to save the Gatholla, you turned the amulet three times. Darkness faded\n" +
                    "away. Sun has risen again. You walked to the window and looked at the city. Everyone that has\n" +
                    "been killed or corrupted were healing. You've saved Gatholla!\n" +
                    "THE END");
        }
        System.out.println("Thanks for playing ^_^");
    }

    public static Player createUser(Player player) throws InterruptedException {
        //Ask from user to select a tribe
        int tribeChoose = 0;
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("\nWhich tribe you wish to be in? \nEnter 1 for humans, 2 for wizards or 3 for orcs: ");
            tribeChoose = input.nextInt();
            if(tribeChoose == 1) {
                printWithDelays(Acts.act1_a, TimeUnit.MILLISECONDS, 100);
                player = new Knight();
                break;
            } else if(tribeChoose == 2) {
                printWithDelays(Acts.act1_b, TimeUnit.MILLISECONDS, 100);
                player = new Sorcerer();
                break;
            } else if (tribeChoose == 3) {
                printWithDelays(Acts.act1_c, TimeUnit.MILLISECONDS, 100);
                player = new Warrior();
                break;
            } else {
                System.out.println("Invalid argument, please try again.");
            }
        }
        return player;
    }
    public static void printWithDelays(String str, TimeUnit tu, long delay) throws InterruptedException {
        for(char ch : str.toCharArray()) {
            System.out.print(ch);
            tu.sleep(delay);
        }
    }
}