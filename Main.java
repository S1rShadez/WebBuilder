package com.company;

import javax.swing.*;

import java.awt.*;

import static javax.swing.JOptionPane.*;

public class Main {

    public static void main(String[] args) {
        //Her lages innputfeltene
        JTextField title = new JTextField(10);
        JTextField header = new JTextField(10);
        JTextField DBer = new JTextField(10);

        //Her lages "Panelet" som har all tekst on alle innputfeltene
        JPanel mainPrompt = new JPanel();

        //Her spesifiseres størrelsen og layout på "Panelet"
        mainPrompt.setLayout(new GridLayout(0, 2, 2, 2));

        //Her legges all tekst og innput til
        mainPrompt.add(new Label("Velkommen til WebBuilder!"));
        mainPrompt.add(Box.createVerticalStrut(10));
        mainPrompt.add(new Label("Skriv inn tittelen til Nettstedet:"));
        mainPrompt.add(title);
        mainPrompt.add(new Label("Skriv inn nettsidens Header:"));
        mainPrompt.add(header);
        mainPrompt.add(new Label("Skriv inn ønsket antall Dynamiske bokser:"));
        mainPrompt.add(DBer);
        mainPrompt.add(new Label("(OBS! KUN SIFFER!)"));

        //Her legges en ok/cancel option til i "panelet"
        int done = showConfirmDialog(null, mainPrompt, "", OK_CANCEL_OPTION);

        //Her sjekkes det om cancel knappen ble trykket, hvis "ja" så avsluttes programmet
        if(done == CANCEL_OPTION){
            System.exit(8008135);
        }

        //Her hentes teksten som har blitt skrevet inn
        String titleText = title.getText();
        String headerText = header.getText();

        //Her sjekkes det for tomme tekstinnput, hvis de er tomme får brukeren en feilmelding, og programmet avsluttes
        if(titleText == "" || headerText == "" || titleText.isEmpty() || headerText.isEmpty()){
            showMessageDialog(null, "Vennligst fyll inn begge tekstfeltene!");
            System.exit(3537);
        }

        /*
        TODO
        Legg også til andre valgmuligheter, for eks. ferdiggenerert nav bar
        */

        int DBtall =0;
        try {
            DBtall = Integer.parseInt(DBer.getText());
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Du skrev ikke inn et tall :(") ;
            System.exit(-1337);
        }

        CreateFile.createFile(titleText,headerText,DBtall);

	    showMessageDialog(null, "OBS!!!\nFilene har blitt lagret i den valgte mappen.\nKlikk \"OK\" for å lukke dette programmet");
    }
}
