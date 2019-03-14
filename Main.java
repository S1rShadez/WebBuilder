package com.company;

import static javax.swing.JOptionPane.*;

public class Main {

    public static void main(String[] args) {
        showMessageDialog(null, "Velkommen til WebBuilder!");

        String title = showInputDialog("Skriv inn tittelen til Nettstedet:");
        String header = showInputDialog("Skriv inn nettsidens Header:");
        //Konverter de tre promptene over til èn dialogboks med flere input
        //Legg også til andre valgmuligheter, for eks. ferdiggenerert nav bar

        int DBer = 0;
        try {
            DBer = Integer.parseInt(showInputDialog( "Skriv inn ønsket antall Dynamiske bokser: (OBS! KUN TALL!)"));
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Du skrev ikke inn et tall :(") ;
            System.exit(-1337);
        }

        CreateFile.createFile(title,header,DBer);

	    showMessageDialog(null, "OBS!!!\nFilene har blitt lagret i den valgte mappen.\nKlikk \"OK\" for å lukke dette programmet");
    }
}
