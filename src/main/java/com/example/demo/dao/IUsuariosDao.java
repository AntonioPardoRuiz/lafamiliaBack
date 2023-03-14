

package com.example.demo.dao;
import com.example.demo.entitys.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IUsuariosDao {

    //Recordemos que trabajamos con colecciones. 
	//Obtenemos, añadimos que si se realiza una llamada, se adjunten las excepciones. 
	public List<Usuarios> getUsuarios() throws InterruptedException, ExecutionException;
	//Recordemos que trabajamos con colecciones.
	//Obtenemos, añadimos que si se realiza una llamada, se adjunten las excepciones. 
	public List<Usuarios> getUsuariosId(String id) throws InterruptedException, ExecutionException; 
	//Borramos. 

	//Damos de alta. 
	public String postUsuarios(Usuarios Usuarios) throws InterruptedException, ExecutionException;

	//Realizar el proceso de PUT USUARIOS.
	public String putUsuarios(Usuarios Usuarios) throws InterruptedException, ExecutionException;

	//Damos de alta. 
	public String enviarMensaje(Usuarios Usuarios) throws InterruptedException, ExecutionException;

    
}