/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteConcern;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.net.UnknownHostException;
import javax.swing.text.Document;



/**
 *
 * @author Carlos
 */
public class ConexionMongo {
    DB db;
    DBCollection coleccion;
    BasicDBObject document;
    DBObject doc;
    
    public ConexionMongo() throws UnknownHostException{
        try {
            Mongo conex = new Mongo("LocalHost",27017);
            db= conex.getDB("prueba");
            System.out.println("CHETE");
        } catch (UnknownHostException e) {
            System.out.println("FAIL");
        }
        
        
    }
    
    public void insertar(){
        
        coleccion= db.getCollection("persona");
        BasicDBObject Nuevo = new BasicDBObject("Nombre","Theo")
                .append("Age", 6)
                .append("Status", "Dormido");
        coleccion.insert(Nuevo);     
    }
    
    public void ConsultarTodo(){
        coleccion= db.getCollection("persona");
        DBCursor cursor = coleccion.find();
        while (cursor.hasNext()){
            System.out.println(cursor.next());
        }
        
    }
    public void Consultar(String x){
        int cont = 0;
        coleccion= db.getCollection("persona");
        BasicDBObject filtro = new BasicDBObject();
        filtro.put("name", "Adrian");
        DBCursor curse = coleccion.find(filtro);
        while (curse.hasNext()){
            cont=+1;
            System.out.println(curse.next());
        }
        System.out.println(cont);
       // Document dc = coleccion.find(eq("name",));
        
       // System.out.println(dc);
    }
    public void eliminar(){
        coleccion= db.getCollection("persona");
        BasicDBObject Nuevo = new BasicDBObject("name","Carlos");
        coleccion.remove(Nuevo);
                     
    }

    public void actualizar(){
        coleccion= db.getCollection("persona");
        BasicDBObject Viejo = new BasicDBObject();
        BasicDBObject Nuevo = new BasicDBObject("name", "Carlos")
                .append("Age", 21)
                .append("Status", "Cansado");
        Viejo.put("name", "Humberto");
        coleccion.update(Viejo, Nuevo);
        
    }
    
    
    
}
