package com.company;

import java.io.*;

public class Main {

    public static void main(String[] args) {
        StringBuilder string = new StringBuilder();

        if (args.length == 0) {
            System.out.println("Veuillez renseigner le fichier dans les paramètres d'application en première position !");
        } else {
            try {
                FileReader fichier = new FileReader(args[0]);
                int octet = 0;
                do {
                    octet = fichier.read();
                    if (octet > 0) {
                        string.append((char) octet);
                    }
                } while (octet > 0);
                System.out.println("Fin du fichier, on ferme !");
                fichier.close();
            } catch (FileNotFoundException e) {
                System.err.println("Le fichier " + args[0] + " n'a pas ete trouve");
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
//            for (int i =0; i < string.length(); i++) {
//                System.out.print(string.charAt(i));
//            }
        }

        if (args.length < 2) {
            System.out.println("Veuillez renseigner le fichier dans les paramètres d'application en seconde position !");
        } else {
            try {
                FileWriter copy = new FileWriter(args[1]);
                for (int i =0; i < string.length(); i++) {
                    copy.write(string.charAt(i));
                }
                System.out.println ("On ferme le fichier !");
                copy.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
