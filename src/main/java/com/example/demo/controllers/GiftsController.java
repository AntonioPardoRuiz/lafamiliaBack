package com.example.demo.controllers;

import com.example.demo.dao.IGiftsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gifts")
@CrossOrigin("*")
@RestController
public class GiftsController {

    @Autowired
	private IGiftsDao iGiftsDao;
    /**
	 * GET Usuarios
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	//Quitamos el CORS
	@CrossOrigin(origins= {"*"})
	//La ruta donde vamos acceder ahora http://..../usuario/list
	//Recuperamos el listado de usuarios. Para comenzar trabajamos con este metodo
	@GetMapping("/getGifts")
	public ResponseEntity getGifts() throws Exception, Throwable {
        System.out.println("getGifts");
		return new ResponseEntity(iGiftsDao.getGifts(),HttpStatus.OK);
	}




}



