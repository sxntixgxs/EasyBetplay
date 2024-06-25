package com.soccer;

import java.util.Scanner;

import com.soccer.view.viewPlayer;
import com.soccer.view.viewTeam;

public class Main {
    public static void menuPrincipal(viewTeam, viewPlayer){
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        while(flag){
            System.out.println("Bienvenido al sistema LigaBetPlay");
            System.out.println("1. Acceder al menú de equipos");
            System.out.println("2. Acceder al menú de jugadores");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    viewTeam.start();
                    break;
                case 2:
                    viewPlayer.start();
                default:
                    break;
            }
        }
    }
    public static void main(String[] args) {
        Controller ctrlTeams = new Controller();
        Controller ctrlPlayers = new Controller();

        viewTeam.controlador = ctrlTeams;
        viewTeam vt = new viewTeam();
        
        viewPlayer.controlador = ctrlPlayers;
        viewPlayer vp = new viewPlayer();

        menuPrincipal(viewTeam,viewPlayer);


       // System.out.println("Jugador"+ eq.getLstJugadores().get(0).getNombre());
    }

}