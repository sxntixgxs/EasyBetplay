package com.soccer.view;

import java.util.Scanner;

import com.soccer.Controller;
import com.soccer.model.entity.Team;

public class viewTeam {
    public static Controller controlador;
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Actualizar Equipo");
            System.out.println("3. Buscar Equipo");
            System.out.println("4. Eliminar Equipo");
            System.out.println("5. Listar todos Equipos");
            System.out.println("6. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                        Team equipo = new Team();
                        String codigoEquipo = null;
                        System.out.println("Ingrese el codigo del equipo :");
                        codigoEquipo = scanner.nextLine();
                        System.out.println("Ingrese Nombre del equipo :");
                        equipo.setNombre(scanner.nextLine());
                        System.out.println("Ingrese la ciudad :");
                        equipo.setCiudad(scanner.nextLine());
                        controlador.equipos.put(codigoEquipo, equipo);
                    break;

                case 2:
              
                    String codigoEq = null;
                    Team ek = new Team();
                    System.out.println("Ingrese el codigo del equipo a actualizar: ");      
                    codigoEq = scanner.nextLine();
                    ek = controlador.equipos.get(codigoEq);
                    System.out.println("Modificando ... " + ek.getNombre());
                    System.out.println("1.Actualizar nombre de equipo");
                    System.out.println("2.Actualizar ciudad del equipo");
                    int election = scanner.nextInt();
                    switch (election) {
                        case 1:
                            System.out.println("Ingrese el nuevo nombre del equipo: ");
                            scanner.nextLine();
                            String newName = scanner.nextLine();
                            ek.setNombre(newName);
                            System.out.println("Nombre actualizado a "+newName+"!");
                            break;
                        case 2:
                            System.out.println("Ingrese la nueva ciudad: ");
                            String newCity = scanner.nextLine();
                            ek.setCiudad(newCity);
                            System.out.println("Ciudad actualizada a "+newCity+"!");
                        case 3://añadir entrenador
                            break;
                        case 4://añadir jugador
                            break;
                        case 5: //añadir masajista
                            break;
                        case 6://eliminar entrenador
                            break;
                        case 7://eliminar jugador
                            break;
                        case 8: //eliminar masajista
                            break;
                        default:
                            break;
                    }
                    break;

                case 3:
                    Team eq = new Team();
                    String codigoE = null;
                    System.out.println("Ingrese el codigo del equipo:");
                    codigoE = scanner.nextLine();
                    eq = controlador.equipos.get(codigoE);
                    System.out.println("Mi equipo " + eq.getNombre());
                    break;
                case 4:

                    break;

                case 5:

                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
