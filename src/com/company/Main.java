package com.company;

class Main {

    public static void main(String[] args) {
        Methods methods = new Methods();

        if (args.length < 2) {
            System.out.println("Veuillez renseigner les fichiers dans les paramètres d'application !");
        } else {
            String message = "Je suis le texte copié !";
            methods.copy(args[0], args[1]);
            methods.readThenCopy(args[0], args[1]);
            methods.writeReadAndCopy(args[0], "copie2.txt", message);
        }
    }
}
