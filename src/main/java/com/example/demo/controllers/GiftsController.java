package com.example.demo.controllers;

import com.example.demo.dao.IGiftsDao;
import com.example.demo.dao.IStatusDao;
import com.example.demo.entitys.Gifts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gifts")
@CrossOrigin("*")
@RestController
public class GiftsController {

    @Autowired
	private IGiftsDao iGiftsDao;
	@Autowired
	private IStatusDao iStatusDao;
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



    /**
	 * GET Status items
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	//Quitamos el CORS
	@CrossOrigin(origins= {"*"})
	//La ruta donde vamos acceder ahora http://..../usuario/list
	//Recuperamos el listado de usuarios. Para comenzar trabajamos con este metodo
	@GetMapping("/getStatus")
	public ResponseEntity getStatus() throws Exception, Throwable {
        System.out.println("getStatus");
		return new ResponseEntity(iStatusDao.getStatus(),HttpStatus.OK);
	}

	/**
	 * POST USUARIOS
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	//Quitamos el CORS
	@CrossOrigin(origins= {"*"})
	//La ruta donde vamos acceder ahora http://..../usuario/list
	//Recuperamos el listado de usuarios. Para comenzar trabajamos con este metodo
	@PostMapping("/postGifts")
	public ResponseEntity postGifts(@RequestBody Gifts Gifts) throws Exception, Throwable {
        System.out.println("postGifts");
		return new ResponseEntity(iGiftsDao.postGifts(Gifts),HttpStatus.OK);
	}


}



