/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pingpong;

/**
 *
 * @author María Malvesada
 */
public class Player implements Runnable {


    private final String text;
    private Player nextPlayer;
    private volatile boolean mustPlay = false;

    public Player(String text) {

        this.text = text;

    }



    @Override

    public void run() {

        while(!Thread.interrupted()) {

            while (!mustPlay);
            System.out.println(text);
            this.mustPlay = false;
            nextPlayer.mustPlay = true;
        }

    }



    public void setNextPlayer(Player nextPlayer) {

        this.nextPlayer = nextPlayer;

    }



    public void setMustPlay(boolean mustPlay) {

        this.mustPlay = mustPlay;

    }

}