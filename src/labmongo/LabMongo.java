/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labmongo;

import Conexion.ConexionMongo;
import GUI.Inicio;
import java.net.UnknownHostException;

/**
 *
 * @author Carlos
 */
public class LabMongo {

    /**
     * @param args the command line arguments
     * @throws java.net.UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here
        Inicio nv = new Inicio();
        nv.setVisible(true);
        ConexionMongo b = new ConexionMongo();
        b.Consultar("Ds");
    }
    
}
