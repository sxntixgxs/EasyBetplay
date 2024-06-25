package com.soccer.view;

import java.util.*;
import java.util.Scanner;
import com.soccer.model.entity.*;
import com.soccer.Controller;

public class ViewTeam {
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
                    int confirmar = 0;
                    Team ek = new Team();
                    System.out.println("Ingrese el codigo del equipo a actualizar: ");      
                    codigoEq = scanner.nextLine();
                    ek = controlador.equipos.get(codigoEq);
                    System.out.println("Modificando ... " + ek.getNombre());
                    System.out.println("1. Actualizar nombre de equipo");
                    System.out.println("2. Actualizar ciudad del equipo");
                    System.out.println("3. Actualizar plantilla de entrenadores");
                    System.out.println("4. Añadir jugador");
                    System.out.println("5. Añadir masajista");
                    System.out.println("6. Eliminar entrenador");
                    System.out.println("7. Eliminar jugador");
                    System.out.println("8. Eliminar médico");
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
                            List<Player> jugadores = ek.getLstJugadores();
                            List<Doctor> medicos = ek.getLstMasajistas();
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
                            confirmar = 0;
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
                            //Pedimos los datos para crear la instancia de Medico/Doctor/Masajista
                            Random random1 = new Random();
                            System.out.println("Registrando medico... \nPor favor complete los siguientes datos: ");
                            int idM = random1.nextInt();
                            String nombreM;
                            System.out.println("Ingrese el nombre del médico: ");
                            scanner.nextLine();
                            nombreM = scanner.nextLine();
                            System.out.println("Ingrese el apellido del médico: ");
                            String apellidoM = scanner.nextLine();
                            System.out.println("Ingrese la edad del médico: ");
                            int edadM = scanner.nextInt();
                            System.out.println("Ingrese el título del médico: ");
                            String tituloM = scanner.nextLine();
                            System.out.println("Ingrese los años de experiencia del médico: ");
                            int expYear = scanner.nextInt();
                            //Confirmar datos
                            confirmar = 0;
                            System.out.println("Estos fueron los datos ingresados: \nNombre: "+nombreM+" "+apellidoM+"\nEdad: "+edadM+"\nDorsal: "+tituloM+"\nPosición: "+expYear);
                            System.out.println("1. Confirmar datos\n2. Modificar Datos\n3. Salir de este menú");
                            confirmar = scanner.nextInt();
                            switch (confirmar) {
                                case 1:

                                    try {
                                        Doctor doctor = new Doctor(idM,nombreM,apellidoM,edadM,tituloM,expYear);
                                        ek.setLstMasajistas(doctor);
                                        System.out.println(nombreM+" "+apellidoM+"\nAñadido con éxito!");
                                    } catch (Exception e) {
                                        System.out.println("Hubo un error añadiendo al médico\nIntente de nuevo");
                                    }
                                    break;
                                case 2:
                                    continue;
                                default:
                                    break;
                            }
                            break;
                        case 6://eliminar entrenador
                            System.out.println("Este es el listado de entrenadores de "+ek.getNombre()+" ...");
                            entrenadores = ek.getLstEntrenadores();
                            if(entrenadores.size()>0){
                                for (Coach coach : entrenadores) {
                                    System.out.println("ID: "+coach.getId()+" "+"Nombre: "+coach.getNombre()+" "+coach.getApellido()+"\nEdad: "+coach.getEdad()+"\nFederacion: "+coach.getIdFederacion());
                                }
                            }else{
                                System.out.println("No hay entrenadores registrados !!!");
                            }
                            contador = 0;
                            while (contador!=-1) {
                                System.out.println("Ingrese el ID del entrenador que desea eliminar: ");
                                int delCoach = scanner.nextInt();
                                int idxCoach;
                                for (Coach coach : entrenadores) {
                                    if(coach.getId()==delCoach){
                                        idxCoach = entrenadores.indexOf(coach);
                                        try {
                                            entrenadores.remove(idxCoach);
                                            System.out.println("Entrenador eliminado con éxito! ");
                                            contador = -1;
                                            break;
                                            
                                        } catch (Exception e) {
                                            System.out.println("Hubo algún error, verifique los datos e intente de nuevo.");
                                        }
                                    }
                                }

                            }
                            break;
                        case 7://eliminar jugador
                            System.out.println("Este es el listado de jugadores de "+ek.getNombre()+" ...");
                            jugadores = ek.getLstJugadores();
                            if(jugadores.size()>0){
                                for (Player jugador : jugadores) {
                                    System.out.println("JUGADOR ID: # "+jugador.getId()+"\n"+jugador.getNombre()+" "+jugador.getApellido()+"\nEdad: "+jugador.getEdad()+"\nPosición: "+jugador.getPosicion()+"\nDorsal: "+jugador.getDorsal());
                                }
                            }else{
                                System.out.println("No hay jugadores registrados !!!");
                            }
                            contador = 0;
                            while (contador!=-1) {
                                System.out.println("Ingrese el ID del jugador que desea eliminar: ");
                                int delPlayer = scanner.nextInt();
                                int idxPlayer;
                                for (Player player : jugadores) {
                                    if (player.getId()==delPlayer) {
                                        idxPlayer = jugadores.indexOf(player);
                                        try {
                                            jugadores.remove(idxPlayer);
                                            System.out.println("Jugador eliminado con éxito.");
                                            contador=-1;
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Ocurrió un error, intente de nuevo.");
                                            contador=-1;
                                        }
                                    }
                                }
                            }
                            break;
                        case 8: //eliminar masajista
                            System.out.println("Esta es la plantilla de médicos de "+ek.getNombre()+" ...");
                            medicos = ek.getLstMasajistas();
                            if (medicos.size()>0) {
                                for (Doctor doctor : medicos) {
                                    System.out.println("MEDICO ID #: "+doctor.getId()+"\nNombre: "+doctor.getNombre()+" "+doctor.getApellido()+"\nTítulo: "+doctor.getTitulo());
                                }
                            }else{
                                System.out.println("No hay médicos registrados !!!");
                            }
                            contador = 0;
                            while(contador!=-1){
                                System.out.println("Ingrese el ID del médico que desea eliminar: ");
                                int delMedico = scanner.nextInt();
                                int idxMedico;
                                for (Doctor doctor : medicos) {
                                    if (doctor.getId()==delMedico) {
                                        idxMedico = medicos.indexOf(doctor);
                                        try {
                                            medicos.remove(idxMedico);
                                            System.out.println("Médico eliminado con éxito.");contador = -1;
                                            break;
                                        } catch (Exception e) {
                                            System.out.println("Ocurrió un error, intente de nuevo.");
                                            contador=-1;
                                        }
                                    }
                                }
                            }
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
