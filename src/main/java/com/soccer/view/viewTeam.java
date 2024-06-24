package com.soccer.view;

import java.util.*;
import java.util.Scanner;
import com.soccer.model.entity.*;
import com.soccer.Controller;

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
                case 1: //crear equipo
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

                case 2: //actualizar equipo
              
                    String codigoEq = null;
                    Team ek = new Team();
                    System.out.println("Ingrese el codigo del equipo a actualizar: ");      
                    codigoEq = scanner.nextLine();
                    ek = controlador.equipos.get(codigoEq);
                    System.out.println("Modificando ... " + ek.getNombre());
                    System.out.println("1. Actualizar nombre de equipo");
                    System.out.println("2. Actualizar ciudad del equipo");
                    System.out.println("3. Actualizar plantilla de entrenadores");
                    System.out.println("4. Añadir jugador");
                    int election = scanner.nextInt();
                    switch (election) {
                        case 1: //modificar nombre equipo
                            System.out.println("Ingrese el nuevo nombre del equipo: ");
                            scanner.nextLine();
                            String newName = scanner.nextLine();
                            ek.setNombre(newName);
                            System.out.println("Nombre actualizado a "+newName+"!");
                            break;
                        case 2: // modificar ciudad
                            System.out.println("Ingrese la nueva ciudad: ");
                            scanner.nextLine();
                            String newCity = scanner.nextLine();
                            ek.setCiudad(newCity);
                            System.out.println("Ciudad actualizada a "+newCity+"!");
                        case 3://añadir entrenador
                            System.out.println("Añadiendo / modificando entrenadores de "+ek.getNombre()+" ...");
                            scanner.nextLine();
                            List<Coach> entrenadores = ek.getLstEntrenadores();
                            int contador = 0;

                            if(entrenadores.size()>0){
                                System.out.println("Esta es la plantilla actual de entrenadores: ");
                                for (Coach coach : entrenadores) {
                                    System.out.println("Nombre: "+coach.getNombre()+" "+coach.getApellido()+"\nEdad: "+coach.getEdad()+"\nFederacion: "+coach.getIdFederacion());//para acceder a los datos hay que usar los getters !
                                }
                            }
                            while(contador!=-1){
                                System.out.println("Insertar los datos requeridos para añadir entrenador... ");
                                scanner.nextLine();
                                System.out.println("Ingrese nombre del entrenador: ");
                                String nombreC = scanner.nextLine();
                                System.out.println("Ingrese apellido del entrenador: ");
                                String apellidoC = scanner.nextLine();
                                System.out.println("Ingrese edad del entrenador: ");
                                int edadC = scanner.nextInt();
                                System.out.println("Ingrese el id de la federación: ");
                                int idFederacionC = scanner.nextInt();
                                System.out.println("Estos son los datos ingresados: ");
                                System.out.println("Nombre: "+nombreC+" "+apellidoC+"\nEdad: "+edadC+"\nidFederacion: "+idFederacionC);
                                System.out.println("1. Confirmo datos");
                                System.out.println("2. Modificar datos");
                                System.out.println("3. Salir de este menú.");
                                int check = scanner.nextInt();
                                switch (check) {
                                    case 1:
                                        Random random = new Random();
                                        int idC = random.nextInt();
                                        Coach entrenador = new Coach(idC, nombreC, apellidoC, edadC, idFederacionC);
                                        ek.setLstEntrenadores(entrenador);
                                        System.out.println("Datos registrados con exito! ");
                                        int continuar = 0;
                                        scanner.nextLine();
                                        System.out.println("Desea añadir más entrenadores?\n1. Sí\n2. No");
                                        continuar = scanner.nextInt();
                                        if(continuar==1){
                                            continue;
                                        }else{
                                            contador=-1;
                                        }
                                    case 2:{
                                        continue;
                                    }
                                    case 3:
                                        contador=-1;
                                        break;
                                    default:
                                        break;
                                }
                            }

                            break;
                        case 4://añadir jugador
                            //Pedimos los datos para crear la instancia de Player
                            System.out.println("Registrando jugador... \nPor favor complete los siguientes datos: ");
                            Random random = new Random();
                            int idP = random.nextInt();
                            String nombreP;
                            System.out.println("Ingrese el nombre del jugador: ");
                            scanner.nextLine();
                            nombreP = scanner.nextLine();
                            System.out.println("Ingrese el apellido del jugador: ");
                            String apellidoP = scanner.nextLine();
                            System.out.println("Ingrese la edad del jugador: ");
                            int edadP = scanner.nextInt();
                            System.out.println("Ingrese el dorsal del jugador: ");
                            int dorsalP = scanner.nextInt();
                            System.out.println("Ingrese la posición del jugador: ");
                            String posicionP = scanner.nextLine();
                            // Player jugador = new Player();
                            //Confirmar datos
                            int confirmar = 0;
                            System.out.println("Estos fueron los datos ingresados: \nNombre: "+nombreP+" "+apellidoP+"\nEdad: "+edadP+"\nDorsal: "+dorsalP+"\nPosición: "+posicionP);
                            System.out.println("1. Confirmar datos\n2. Modificar Datos\n3. Salir de este menú");
                            confirmar = scanner.nextInt();
                            switch (confirmar) {
                                case 1:

                                    try {
                                        Player jugador = new Player(idP,nombreP,apellidoP,edadP,dorsalP,posicionP);
                                        ek.setLstJugadores(jugador);
                                        System.out.println(nombreP+" "+apellidoP+"\nAñadido con éxito!");
                                    } catch (Exception e) {
                                        System.out.println("Hubo un error añadiendo al jugador\nIntente de nuevo");
                                    }
                                    break;
                                case 2:
                                    continue;
                                default:
                                    break;
                            }
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

                case 3: //buscar equipo
                    Team eq = new Team();
                    String codigoE = null;
                    System.out.println("Ingrese el codigo del equipo:");
                    codigoE = scanner.nextLine();
                    eq = controlador.equipos.get(codigoE);
                    try {
                        System.out.println("Mi equipo " + eq.getNombre());
                    } catch (Exception e) {
                        System.out.println("Sin registros ...");
                    }

                    break;
                case 4: //eliminar equipo
                    //usamos null para vaciar esa instancia de la calse equipo
                    String codigoBor = null;
                    Team bo = new Team();
                    int conf = 0;
                    System.out.println("Ingrese el codigo del equipo a eliminar: ");      
                    codigoBor = scanner.nextLine();
                    bo = controlador.equipos.get(codigoBor);
                    if (bo != null) {
                        System.out.println("Eliminando "+bo.getNombre()+" ...\n1. Confirmar\n2. Cancelar");
                        conf = scanner.nextInt();
                        if (conf==1) {
                            // bo = null;
                            controlador.equipos.remove(codigoBor);
                            System.out.println("Eliminado con exito!");
                        }else{
                            System.out.println("Abortando...");
                        }
                    }
                    break;

                case 5: //listar todos los equipo
                    // Cómo imprimir un hashtable !! 
                    Enumeration<String> keys = controlador.equipos.keys();
                    while (keys.hasMoreElements()) {
                        String key = keys.nextElement();
                        System.out.println(controlador.equipos.get(key).getNombre()+"\tCiudad: "+controlador.equipos.get(key).getCiudad());
                        scanner.nextLine();
                    }
                    break;

                case 6: //salir
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion invalida, intentelo de nuevo.");
            }
        }
    }
}
