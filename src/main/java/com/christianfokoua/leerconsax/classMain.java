package com.christianfokoua.leerconsax;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author willy christian Fokoua
 */
public class classMain {
    
    public static void main(String[] args){
        
       
         try {
        //Obtenir la configuration du sax parser
        SAXParserFactory spfactory = SAXParserFactory.newInstance();
        //Obtenir une instance de l'objet parser
        SAXParser saxParser = spfactory.newSAXParser();
 
        /*les trois méthodes sont déclarées dans le
         corp du DefaltHandler*/
        DefaultHandler handler = new DefaultHandler() {
 
        boolean apodo = false;
        boolean nombre = false;
        boolean videojuego = false;
        boolean edad = false;
        boolean origen = false;
 
        /*cette méthode est invoquée à chaque fois que parser rencontre
          une balise ouvrante '<' */
        public void startElement(String uri, String localName,String qName,Attributes attributes) throws SAXException{
 
           if (qName.equalsIgnoreCase("apodo")) {
             apodo = true;
           }
 
           if (qName.equalsIgnoreCase("nombre")) {
             nombre = true;
           }
 
           if (qName.equalsIgnoreCase("videojuego")) {
             videojuego = true;
           }
 
           if (qName.equalsIgnoreCase("edad")) {
             edad = true;
           }
           
           if(qName.equalsIgnoreCase("origen")){
               origen = true;
           }
        }
 
        /*cette méthode est invoquée à chaque fois que parser rencontre
          une balise fermante '>' */
        public void endElement(String uri, String localName,String qName) throws SAXException {
                
           if (qName.equalsIgnoreCase("apodo")) {
             apodo = false;
           }
 
           if (qName.equalsIgnoreCase("nombre")) {
             nombre = false;
           }
 
           if (qName.equalsIgnoreCase("videojuego")) {
             videojuego = false;
           }
 
           if (qName.equalsIgnoreCase("edad")) {
             edad = false;
           }
           
           if(qName.equalsIgnoreCase("origen")){
               origen = false;
           }
        }

        /*imprime les données stockées entre '<' et '>' */
        public void characters(char ch[], int start,int length) throws SAXException {
 
           if (apodo) {
             System.out.println("Apodo : " + 
                    new String(ch, start, length));
             apodo = false;
           }
   
           if (nombre) {
             System.out.println("Nombre : " +
                     new String(ch, start, length));
             nombre = false;
           }
 
           if (videojuego) {
             System.out.println("Videojuego : " + 
                     new String(ch, start, length));
             videojuego = false;
           }
 
           if (edad) {
             System.out.println("Edad : " + 
                     new String(ch, start, length));
             edad = false;
           }
           
           if(origen){
               System.out.println("Origen : " + new String(ch, start , length)) ;
               origen = false;
               System.out.println();
           }
        }
 
        };
 
       saxParser.parse("gamer.xml", handler);
 
     } catch (IOException | ParserConfigurationException | SAXException e) {
       e.printStackTrace();
     }
 
        
        
    }
}
