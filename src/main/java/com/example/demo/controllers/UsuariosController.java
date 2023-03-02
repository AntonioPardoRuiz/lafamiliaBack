package com.example.demo.controllers;

import com.example.demo.dao.IUsuariosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/usuarios")
@CrossOrigin("*")
@RestController
public class UsuariosController {

    @Autowired
	private IUsuariosDao iUsuariosDao;
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
	@GetMapping("/getUsuarios")
	public ResponseEntity getUsuarios() throws Exception, Throwable {
        System.out.println("getUsuarios");
		return new ResponseEntity(iUsuariosDao.getUsuarios(),HttpStatus.OK);
	}




}



