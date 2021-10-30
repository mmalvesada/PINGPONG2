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
    private int turns = Game.MAX_TURNS;
    private Player nextPlayer;
    private boolean mustPlay = false;

    public Player(String text) {

        this.text = text;

    }


    @Override //sobre escribimos el método n veces en nuestro proceso

    public void run() {

        while(!gameFinished()) {
            while (!mustPlay);// mientras el juego no acabe, seguimos jugando
            System.out.println(text);
            turns--;//restamos un numero de turnos
            this.mustPlay = false;
            nextPlayer.mustPlay = true;
        }

    }
//antes el jugador pasa el metodo mediante mensaje, 
   //ahora vamos a jugar con el metdo mustplay, el propio judaor es el reponsable de su turno,
    //por tanto de cada hilo

    private boolean gameFinished() {

        return turns == 0; //para finalizar partido

    }



    public void setNextPlayer(Player nextPlayer) {

        this.nextPlayer = nextPlayer;//mlamada al siguiente jugador

    }



    public void setMustPlay(boolean mustPlay) {

        this.mustPlay = mustPlay;

    }

}