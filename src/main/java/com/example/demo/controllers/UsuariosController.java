package com.example.demo.controllers;

import com.example.demo.dao.IUsuariosDao;
import com.example.demo.entitys.Usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    /**
	 * GET UsuariosID
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	//Quitamos el CORS
	@CrossOrigin(origins= {"*"})
	//La ruta donde vamos acceder ahora http://..../usuario/list
	//Recuperamos el listado de usuarios. Para comenzar trabajamos con este metodo
	@GetMapping("/getUsuariosId")
	public ResponseEntity getUsuariosId(@RequestParam String id ) throws Exception, Throwable {
        System.out.println("getUsuariosId");
		return new ResponseEntity(iUsuariosDao.getUsuariosId(id),HttpStatus.OK);
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
	@PostMapping("/postUsuarios")
	public ResponseEntity postUsuarios(@RequestBody Usuarios Usuarios) throws Exception, Throwable {
        System.out.println("postUsuarios");
		return new ResponseEntity(iUsuariosDao.postUsuarios(Usuarios),HttpStatus.OK);
	}

	/**
	 * PUT USUARIO
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	//Quitamos el CORS
	@CrossOrigin(origins= {"*"})
	//La ruta donde vamos acceder ahora http://..../usuario/list
	//Recuperamos el listado de usuarios. Para comenzar trabajamos con este metodo
	@PutMapping("/putUsuarios")
	public ResponseEntity putUsuarios(@RequestBody Usuarios Usuarios) throws Exception, Throwable {
        System.out.println("postUsuarios");
		return new ResponseEntity(iUsuariosDao.putUsuarios(Usuarios),HttpStatus.OK);
	}


	/**
	 * ENVIAR MENSAJE
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	//Quitamos el CORS
	@CrossOrigin(origins= {"*"})
	//La ruta donde vamos acceder ahora http://..../usuario/list
	//Recuperamos el listado de usuarios. Para comenzar trabajamos con este metodo
	@PostMapping("/enviarMensaje")
	public ResponseEntity enviarMensaje(@RequestBody Usuarios Usuarios) throws Exception, Throwable {
        System.out.println("EnviarMensaje");
		return new ResponseEntity(iUsuariosDao.enviarMensaje(Usuarios),HttpStatus.OK);
	}

	/**
	 * RESETEAMOS EL PASSWORD
	 * @return
	 * @throws Exception
	 * @throws Throwable
	 */
	//Quitamos el CORS
	@CrossOrigin(origins= {"*"})
	//La ruta donde vamos acceder ahora http://..../usuario/list
	//Recuperamos el listado de usuarios. Para comenzar trabajamos con este metodo
	@PostMapping("/resetearPassword")
	public ResponseEntity resetearPassword(@RequestBody Usuarios Usuarios) throws Exception, Throwable {
        System.out.println("EnviarMensaje");
		return new ResponseEntity(iUsuariosDao.resetearPassword(Usuarios),HttpStatus.OK);
	}


}



