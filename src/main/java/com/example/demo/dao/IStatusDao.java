

package com.example.demo.dao;
import com.example.demo.entitys.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IStatusDao {

    //Recordemos que trabajamos con colecciones. 
	//Obtenemos, añadimos que si se realiza una llamada, se adjunten las excepciones. 
	public List<Status> getStatus() throws InterruptedException, ExecutionException;
	//Recordemos que trabajamos con colecciones.
	//Obtenemos, añadimos que si se realiza una llamada, se adjunten las excepciones. 


    
}