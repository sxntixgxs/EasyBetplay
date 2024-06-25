package com.soccer.view;

import java.util.*;

import com.soccer.model.entity.Player;
import com.soccer.model.entity.Team;
import com.soccer.Controller;

public class viewPlayer {
       public static Controller controlador;
       public List<Player> lstJugadores = new ArrayList<>();//lista global de jugadores
       public void start(){
              Scanner scanner = new Scanner(System.in);
              Random random = new Random();
              Team equipo = new Team();
              while (true) {
                     System.out.println("1. Registrar jugador");
                     System.out.println("2. Actualizar jugador");
                     System.out.println("3. Buscar jugador");
                     System.out.println("4. Eliminar jugador");
                     System.out.println("5. Listar jugadores");
                     System.out.println("6. Salir");
                     int choice = scanner.nextInt();
                     scanner.nextInt();

                     switch (choice) {
                            case 1:
                            
                                   int id = random.nextInt();
                                   System.out.println("Registro jugador ...");
                                   System.out.println("**La inscripción de jugador en un equipo se debe hacer desde la administración de equipo**");
                                   System.out.println("Ingrese el nombre del jugador: ");
                                   String nombre = scanner.nextLine();
                                   System.out.println("Ingrese el apellido del jugador: ");
                                   String apellido = scanner.nextLine();
                                   System.out.println("Ingrese la edad del jugador: ");
                                   int edad = scanner.nextInt();
                                   System.out.println("Ingrese el dorsal del jugador: ");
                                   int dorsal = scanner.nextInt();
                                   System.out.println("Ingrese la posición del jugador: ");
                                   String pos = scanner.nextLine();
                                   System.out.println("Estos son los datos: \nNombre: "+nombre+" "+apellido+"\nEdad: "+edad+"\nDorsal: "+dorsal+"\nPosición: "+pos);
                                   System.out.println("1. Confirmar datos");
                                   System.out.println("2. Modificar datos");
                                   System.out.println("3. Salir de este menú");
                                   int check = scanner.nextInt();
                                   switch (check) {
                                          case 1:
                                                 Player player = new Player(id,nombre,apellido,edad,dorsal,pos);   
                                                 lstJugadores.add(player);//Añadimos el jugador a una lista de jugadores global
                                                 Enumeration<String> keys = controlador.equipos.keys();
                                                 while (keys.hasMoreElements()) {
                                                     String key = keys.nextElement();
                                                     System.out.println(controlador.equipos.get(key).getNombre()+"\tCiudad: "+controlador.equipos.get(key).getCiudad());
                                                     scanner.nextLine();
                                                     lstJugadores.add(player);
                                                 }
                                                 System.out.println("Jugador añadido con éxito! ");
                                                 break;
                                          case 2:
                                                 continue;
                                   
                                          default:
                                                 break;
                                   }


                                   break;
                     
                            default:
                                   break;
                     }
                     scanner.close();
              }
       }
}
