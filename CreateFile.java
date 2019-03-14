package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static javax.swing.JOptionPane.*;

public class CreateFile {

    public static void createFile(String title ,String header, int DbNr){
        String DB = "";


        if(DbNr > 0){
            for(int i = 0; i < DbNr; i++){
                DB+= "        <div class=\"dynamicBox\"></div> \n";
            }
        }

        String fileContent =
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title> " + title +" </title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"indexCSS.css\">\n" +
                "</head>\n" +
                "<body>\n" +
                "    <header><h1> " + header +" </h1></header>\n" +
                "    \n" +
                "    <div id=\"content\">\n" +
                "    \n" +
                DB +
                "        \n" +
                "    </div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";

        BufferedWriter indexWriter = null;
        BufferedWriter cssWriter = null;

        JFileChooser path = null;
        try {
            path = new JFileChooser();
            path.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            path.showSaveDialog(null);
        } catch (HeadlessException e) {
            showMessageDialog(null, "Noe gikk galt ved valg av lagringssted");
        }

        try {
            new File(path.getSelectedFile() + "\\" + title).mkdirs();
            cssWriter = new BufferedWriter(new FileWriter(path.getSelectedFile() + "\\" + title +"\\indexCSS.css"));
            indexWriter = new BufferedWriter(new FileWriter(path.getSelectedFile() + "\\" + title +"\\index.html"));
        } catch (IOException e) {
            showMessageDialog(null, "Filstien kunne ikke fastsettes :=") ;
            System.exit(-69);
        }
        try {
            cssWriter.write(CssContents.cssContents);
            indexWriter.write(fileContent);
        } catch (IOException e) {
            showMessageDialog(null, "Filen/e kunne ikke skrives til :/") ;
            System.exit(-69);
        }
        try {
            cssWriter.close();
            indexWriter.close();
        } catch (IOException e) {
            showMessageDialog(null, "Det er visst noe gærent med skriveren :{") ;
            System.exit(-69);
        }


    }

}
