package com.example.demo.controllers;

import com.example.demo.dao.IChildrenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/children")
@CrossOrigin("*")
@RestController
public class ChildrenController {

    @Autowired
	private IChildrenDao iChildrenDao;
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
	@GetMapping("/getChildren")
	public ResponseEntity getChildren() throws Exception, Throwable {
        System.out.println("getChildren");
		return new ResponseEntity(iChildrenDao.getChildren(),HttpStatus.OK);
	}


}



