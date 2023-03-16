package com.example.demo.dao;
import com.example.demo.entitys.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public interface IGiftsDao {

    //Recordemos que trabajamos con colecciones. 
	//Obtenemos, añadimos que si se realiza una llamada, se adjunten las excepciones. 
	public List<Gifts> getGifts() throws InterruptedException, ExecutionException;
	//Recordemos que trabajamos con colecciones. 
	//Borramos. 
		//Damos de alta. 
	public String postGifts(Gifts gifts) throws InterruptedException, ExecutionException;

	//Damos de alta. 
	public String putGifts(Gifts gifts) throws InterruptedException, ExecutionException;

    
}