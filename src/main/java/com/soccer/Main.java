package com.soccer;

import java.util.Scanner;

import com.soccer.view.*;

public class Main {
    public static void menuPrincipal(ViewTeam viewTeam,ViewPlayer viewPlayer){
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
        sc.close();
    }
    public static void main(String[] args) {
        Controller ctrlTeams = new Controller();
        Controller ctrlPlayers = new Controller();

        ViewTeam vt = new ViewTeam();
        ViewTeam.controlador = ctrlTeams;

        ViewPlayer vp = new ViewPlayer();
        ViewPlayer.controlador = ctrlPlayers;


        menuPrincipal(vt,vp);


       // System.out.println("Jugador"+ eq.getLstJugadores().get(0).getNombre());
    }

}