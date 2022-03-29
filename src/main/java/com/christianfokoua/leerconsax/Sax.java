package com.christianfokoua.leerconsax;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author chris
 */
public class Sax {
    
    
    
    
    
    public Sax(String fichier){
        
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            
            SAXParser interprete = factory.newSAXParser();
            
            interprete.parse(new File(fichier), new DefaultHandler());
            
            System.out.println("Finalizado con exit !");
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Sax.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
