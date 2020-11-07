package ui;

import model.*;
import java.util.Scanner;

public class Menu {

    MCS mcs;
    Scanner in;   //numero
    Scanner sc;   //cadenas

    public Menu() {
        mcs = new MCS();
        in = new Scanner(System.in);
        sc = new Scanner(System.in);
    }

    public void showLogo() {

        System.out.println("  (((((((((((((((((((((((((((((((((((((((((((((((((\n"
                + "  ((((((((((((((((/((((((((((((((((((((((((((((((((\n"
                + "  (((/  .(((((((*  .((((((*        (((((/      /(((\n"
                + "  (((/   .((((((.  .(((((   ,((((((((((*  .((((((((\n"
                + "  (((/    /((((/   .((((/  ,(((((((((((.  /((((((((\n"
                + "  (((/     ((((*   .((((*  ,(((((((((((/   ((((((((\n"
                + "  (((/  *  *(((     ((((*  ,((((((((((((,  .(((((((\n"
                + "  (((/  /.  ((*     ((((*  *(((((((((((((,   ((((((\n"
                + "  (((/  //  ,(  .   ((((*  *((((((((((((((/   /((((\n"
                + "  (((/  *(*  ,  (   ((((*  *((((((((((((((((   /(((\n"
                + "  (((/  ,(/    ,(   /(((*  ,(((((((((((((((((   (((\n"
                + "  (((/  .((    ((   /((((  .(((((((((((((((((.  /((\n"
                + "  (((/  .((.  .((.  *((((,  *((((((((((((((((   /((\n"
                + "  (((/  .((((((((.  *(((((   *((((/,/(((((((/   (((\n"
                + "  (((/  .((((((((.  *((((((.        *((   .   .((((\n"
                + "  (((((((((((((((/*/((((((((((///(((((((////(((((((\n"
                + "  (((((((((((((((((((((((((((((((((((((((((((((((((\n"
                + "                 ./(###((///((###(*                \n"
                + "             *#(,                   *((,           \n"
                + "          ,#/                           ((         \n"
                + "        .#*          .**/////*,.          ((       \n"
                + "       *(.      .//////////////////*       *#      \n"
                + "      .#,     *///////////////////////,     /(     \n"
                + "      /(    *///////////////////////////    .#.    \n"
                + "    ,/////,*/////////////////////////////,*////*.  \n"
                + "    /////////////////////////*,...,/////////////,  \n"
                + "    //////*,,,********,,.............,,,,,//////,  \n"
                + "    //////*.........//*........//*.......,//////,  \n"
                + "    //////*.........,,.........,,........,//////,  \n"
                + "    //////*..............................,//////,  \n"
                + "     *///*  ........,/.........**.......  .*///,   \n"
                + "              .......,/*.....,/*.......            \n"
                + "                 ........,,,,.......               \n"
                + "                      .........                    \n"
                + "       \n"
                + "  *************************************************");

    }

    public void addUser() {
        String name;
        String password;
        int age;

        System.out.println("Del usuario digita: \n");
        System.out.print("Nombre/Apodo: ");
        name = sc.nextLine();
        System.out.print("Contraseña: ");
        password = sc.nextLine();
        System.out.print("Edad: ");
        age = in.nextInt();

        System.out.println(mcs.addUser(name, password, age));
    }

    public void login() {
        String name;
        String password;

        System.out.print("Nombre/Apodo de usuario: ");
        name = sc.nextLine();
        System.out.print("Contraseña: ");
        password = sc.nextLine();

        System.out.println(mcs.loginUser(name, password));

    }

    public void showUserInfo() {

        System.out.println(mcs.showUsers());

    }

    public void addPoolSong() {
        String title;
        String artistName;
        String releaseDate;
        String duration;
        int gender;

        System.out.println("Ingrese los datos de la cancion");
        System.out.print("Titulo: ");
        title = sc.nextLine();
        System.out.print("Nombre del artista/banda: ");
        artistName = sc.nextLine();
        System.out.print("Fecha de lanzamiento: ");
        releaseDate = sc.nextLine();
        System.out.println("A continuacion use el formato MM/SS");
        System.out.print("Duracion:");
        duration = sc.nextLine();
        System.out.println("Ingrese el genero de la cancion");
        System.out.println("1. Rock\n" + "2. HipHop\n" + "3. Classical\n"
                + "4. Reggae\n" + "5. Salsa\n" + "6. Metal\n");
        gender = in.nextInt() - 1;

        System.out.println(mcs.addPoolSong(title, artistName, releaseDate, duration, gender));

    }

    public void showPoolSongs() {

        System.out.println(mcs.showSongs());

    }

    public void addPrivatePL() {

        String name;

        System.out.println("De la playList privada ingresa: ");
        System.out.print("Nombre: ");
        name = sc.nextLine();

        System.out.println(mcs.addPrivatePL(name));
    }

    public void addRestrictedPL() {
        String name;

        System.out.println("De la playList restringida ingresa:");
        System.out.print("Nombre: ");
        name = sc.nextLine();

        System.out.println(mcs.addRestrictedPL(name));
    }

    public void addUserAccess() {
        int restrictedPL;
        int userAccess;
        System.out.println("Selecciona la playList");
        for (int i = 0; i < mcs.getPlayLists().length; i++) {
            if (mcs.getPlayLists()[i] instanceof RestrictedPL) {
                System.out.println((i + 1) + ". " + mcs.getPlayLists()[i].getName());
            }
        }
        restrictedPL = in.nextInt() - 1;
        System.out.println("");

        System.out.println("Seleccion el usuario al que quieres dar acceso");
        for (int i = 0; i < mcs.getUsers().length; i++) {
            if(mcs.getUsers()[i] != null){
                System.out.println((i + 1) + ". " + mcs.getUsers()[i].getName());
            }
        }
        userAccess = in.nextInt() - 1;

        System.out.println(mcs.addUserAccess(restrictedPL, userAccess));
    }

    public void addPublicPL() {
        String name;

        System.out.println("De la playList publica ingresa:");
        System.out.print("Nombre: ");
        name = sc.nextLine();

        System.out.println(mcs.addPublicPL(name));
    }

    public void addCalificationPL() {
        int playList;
        float calification;

        System.out.println("Selecciona la playList");
        for (int i = 0; i < mcs.getPlayLists().length; i++) {
            if (mcs.getPlayLists()[i] instanceof PublicPL) {
                System.out.println((i + 1) + ". " + mcs.getPlayLists()[i].getName());
            }
        }
        playList = in.nextInt();

        System.out.println("");
        System.out.println("Califica la playList de 1 a 5");
        calification = in.nextFloat();

        mcs.addCalificationPL(playList, calification);
    }

    public void addPlayListSong() {
        int playList;
        int song;
        
        System.out.println("Seleccione la lista");
        for (int i = 0; i < mcs.getPlayLists().length; i++) {
            if(mcs.getPlayLists()[i] != null){
                System.out.println((i + 1) + ". " + mcs.getPlayLists()[i].getName());
            }
        }
        playList = in.nextInt() - 1;

        System.out.println("\nSeleccione la cancion que desea agregar");
        for (int i = 0; i < mcs.getPoolSongs().length; i++) {
            if(mcs.getPoolSongs()[i] != null){
                System.out.println((i + 1) + ". " + mcs.getPoolSongs()[i].getTitle());
            }
        }
        song = in.nextInt() - 1;
        
        if (mcs.getPlayLists()[playList] instanceof PrivatePL) {

            mcs.addSongPrivate(playList, song);

        } else if (mcs.getPlayLists()[playList] instanceof RestrictedPL) {

            mcs.addSongRestricted(playList, song);

        } else {

            mcs.addSongPublic(playList, song);

        }
        
        mcs.upgrapePlayList();
    }
    
    public void showPlayList() {

        System.out.println(mcs.showPlayList());

    }

    public void startProgram() {
        int option = 0;
        int cont = 0;

        showLogo();
        System.out.println("");
        while (option != 13) {
            System.out.println("");
            System.out.println("1. Agregar nuevo usuario.\n" + "2. Iniciar sesion.\n" + "3. Mostrar todos los usarios.\n"
                    + "4. Agregar cancion al pool.\n" + "5. Mostrar todas las canciones.\n" + "6. Agregar nueva playList publica.\n"
                    + "7. Calificar playList publica.\n" + "8. Agregar nueva playList privada.\n" + "9. Agregar nueva playList retringida.\n"
                    + "10. Agregar acceso de usuario a playList restringida.\n" + "11. Agregar cancion a playList.\n"
                    + "12. Mostrar todas las playList.\n" + "13. Salir del menu.\n");

            option = in.nextInt();

            switch (option) {

                case 1:
                    addUser();
                    break;
                    
                case 2:
                    login();
                    break;

                case 3:
                    showUserInfo();
                    break;

                case 4:
                    addPoolSong();
                    break;

                case 5:
                    showPoolSongs();
                    break;

                case 6:
                    addPublicPL();
                    break;

                case 7:
                    addCalificationPL();
                    break;

                case 8:
                    addPrivatePL();
                    break;

                case 9:
                    addRestrictedPL();
                    break;

                case 10:
                    addUserAccess();
                    break;

                case 11:
                    addPlayListSong();
                    break;
                    
                case 12:
                    showPlayList();
                    break;

                case 13:
                    System.out.println("\n\n¡Gracias por utilizar nuestra App!");
                    break;
                    
                default:
                    System.out.println("Por favor, selecciona una de las opciones disponibles.");
                    break;
            }
        }
    }

}
