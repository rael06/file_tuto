package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Methods {

    void writeReadAndCopy(String _originFile, String _destinationFile, String _message) {
        String message = _message != null ? _message : "Bonjour je teste l'écriture dans un fichier ! ";
        try {
            FileReader originFile = new FileReader(_originFile);
            FileWriter destinationFile = new FileWriter(_destinationFile);
            int octet;

            for (int i = 0; i < message.length(); i++) {
                destinationFile.write(message.charAt(i));
            }

            destinationFile.write("\n");

            do {
                octet = originFile.read();
                if (octet > 0) {
                    destinationFile.write((char) octet);
                }
            } while (octet > 0);
            originFile.close();
            destinationFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void copy(String _originFile, String _destinationFile) {
        try {
            FileReader originFile = new FileReader(_originFile);
            FileWriter copyFile = new FileWriter(_destinationFile);
            int octet;
//            originFile.skip(10);
            do {
                octet = originFile.read();
                if (octet > 0) {
                    copyFile.write((char) octet);
                }
            } while (octet > 0);
            originFile.close();
            copyFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void readThenCopy(String _originFile, String _destinationFile) {

        StringBuilder string = new StringBuilder();

        try {
            FileReader fichier = new FileReader(_originFile);
            int octet;
            do {
                octet = fichier.read();
                if (octet > 0) {
                    string.append((char) octet);
                }
            } while (octet > 0);
            System.out.println("Fin de la copie du fichier d'origine, on ferme !");
            fichier.close();

            FileWriter copy = new FileWriter(_destinationFile);
            for (int i = 0; i < string.length(); i++) {
                copy.write(string.charAt(i));
            }
            System.out.println("Fin de l'écriture du fichier de destination, on ferme !");
            copy.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
