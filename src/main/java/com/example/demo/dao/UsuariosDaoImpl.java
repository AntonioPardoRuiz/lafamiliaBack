package com.example.demo.dao;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadLocalRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.example.demo.config.FirebaseInitializer;
import com.example.demo.entitys.*;
import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Proceso de Envio Email

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


@Service
public class UsuariosDaoImpl implements IUsuariosDao {

    @Autowired
	private FirebaseInitializer firebase;
	//Proceso de envio via email 
	@Autowired
    private JavaMailSender javaMailSender;

    public static final String COL_NAME="users";
	public static final String COL_NAME_GUEST="guest";


  //Recordemos que firebase no trabaja con sql.Trabaja con colecciones. 
	@Override
    public List<Usuarios> getUsuarios() throws InterruptedException, ExecutionException {
		System.out.println("getUsers");
    	List<Usuarios> response = new ArrayList<>();
    	Usuarios Usuarios;
    	
    	ApiFuture<QuerySnapshot> querySnapshotApiFuture = firebase.getFirestore().collection(COL_NAME).get();
    	try {
    		for(DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
    			Usuarios = doc.toObject(Usuarios.class);
    			Usuarios.setId(doc.getId());
    			response.add(Usuarios);
    		}
    	return response;
    	} catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}	
    }

	/** Recuperamos el valor de un usuario por un id. */

	@Override
	public List<Usuarios> getUsuariosId(String id) throws InterruptedException, ExecutionException {

		List<Usuarios> response = new ArrayList<>();
    	Usuarios usuarios;		
		ApiFuture<QuerySnapshot> querySnapshotApiFuture = firebase.getFirestore().collection(COL_NAME).whereEqualTo("id",id).get();
		    	
		try {
		     for(DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
		         usuarios = doc.toObject(Usuarios.class);
		         usuarios.setId(doc.getId());
		         response.add(usuarios);
		         System.out.println("Respuesta Back");
		         System.out.println(response);
		     }
		   //Devolvemos la respuesta en este caso los json de las coleccion
		   return response;
		    	
		 }catch(Exception e) {
			 	System.out.println(e);
		        return null;
		 }	
		    	
   }



	/** METODO POST QUE PERMITE AÑADIR DATOS A LOS PROCESOS. */
	@Override
	public String postUsuarios(Usuarios Usuarios) throws InterruptedException, ExecutionException {

		System.out.println("postUsuariosDao");
		//Sin documento
		///String documento = null;
	    //System.out.println(documento);
		Firestore dbFirestore = firebase.getFirestore();
		//Si document() no le defines, nada te genera de manera automatica el nombre del documento en firebase.
		
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document().set(Usuarios);
		System.out.println(collectionsApiFuture.get().getUpdateTime().toString());

		return collectionsApiFuture.get().getUpdateTime().toString();
	
	}


	@Override
	public String enviarMensaje(Usuarios Usuarios) throws InterruptedException, ExecutionException {
		//Definimos todos los procesos.
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(Usuarios.getEmail());

        msg.setSubject("Bienvenido a la Familia:"+Usuarios.getNombre()); 
        msg.setText("En este enlace dispone la aplicacion para su descarga como invitado: URL,"+"\n\nSu password de usuario es:"+Usuarios.getPassword());
		msg.setText("Recuerde sus credenciales son: Credenciales:,"+"\n\nSu Email:"+Usuarios.getEmail()+"\n\nSu password:"+Usuarios.getPassword() );

        javaMailSender.send(msg);

		return("Envio Correcto");
     
		
	}

	@Override
	public String resetearPassword(Usuarios Usuarios) throws InterruptedException, ExecutionException {

		//Resetamos el password y actualizamos en la base de datos el nuevo password. 
		
		//Definimos todos los procesos del envio del password
		int longitud = 8;
		//Recuperamos una cadena aleatorio a partir del metodo
		String nuevoPassword = generarCadena(longitud);
		System.out.printf("Nuevo Password"+nuevoPassword);
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(Usuarios.getEmail());
        msg.setSubject("Bienvenido a la Familia:"+Usuarios.getNombre());
        msg.setText("En este enlace dispone la aplicacion para su descarga: URL,"+"\n\nSu nuevo password es:"+nuevoPassword);
        javaMailSender.send(msg);
		//Realizamos la actualizacion del password. 
		System.out.println("resetearPassword");
		String id = Usuarios.getId();
		System.out.println("id:"+id);
		try{
			Firestore dbFirestore = firebase.getFirestore();
			//Si document() no le defines, nada te genera de manera automatica el nombre del documento en firebase.Actualizamos el proceso de putMonederoCaptador
			DocumentReference  documento = dbFirestore.collection(COL_NAME).document(id);
			documento.update("password",nuevoPassword);
			documento.update("confirmPassword",nuevoPassword);
			return "Actualizacion del password correcta";

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}
  
		
	}

	public static String generarCadena(int longitud){
		    // El banco de caracteres
			String banco = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
			// La cadena en donde iremos agregando un carácter aleatorio
			String cadena = "";
			for (int x = 0; x < longitud; x++) {
				int indiceAleatorio = numeroAleatorioEnRango(0, banco.length() - 1);
				char caracterAleatorio = banco.charAt(indiceAleatorio);
				cadena += caracterAleatorio;
			}
			return cadena;

	}

	public static int numeroAleatorioEnRango(int minimo, int maximo) {
		// nextInt regresa en rango pero con límite superior exclusivo, por eso sumamos 1
		return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
	}


	@Override
	public String putUsuarios(Usuarios Usuarios) throws InterruptedException, ExecutionException {

		System.out.println("putUsuarios");
		String id = Usuarios.getId();
		//Recuperamos todos los campos que vamos a actualizar. 
		String ciudad = Usuarios.getCiudad();
		String direccion = Usuarios.getDireccion();
		String pais = Usuarios.getPais();
		String provincia = Usuarios.getProvincia();

		System.out.println("id:"+id);
		try{
			Firestore dbFirestore = firebase.getFirestore();
			//Si document() no le defines, nada te genera de manera automatica el nombre del documento en firebase.Actualizamos el proceso de putMonederoCaptador
			DocumentReference  documento = dbFirestore.collection(COL_NAME).document(id);
			documento.update("ciudad",ciudad);
			documento.update("direccion",direccion);
			documento.update("pais",pais);
			documento.update("provincia",provincia);
			return "Actualizacion correcta";

		} catch(Exception e) {
			System.out.println(e.getMessage());
			return e.getMessage();
		}

		

	}

	/** G U E S T */
	
	/** PROCESO GUEST */
	@Override
	public String postGuest(Guest guest) throws InterruptedException, ExecutionException {

		System.out.println("postGuestDao");
		//Sin documento
		///String documento = null;
	    //System.out.println(documento);
		Firestore dbFirestore = firebase.getFirestore();
		//Si document() no le defines, nada te genera de manera automatica el nombre del documento en firebase.
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME_GUEST).document().set(guest);
		System.out.println(collectionsApiFuture.get().getUpdateTime().toString());

		return collectionsApiFuture.get().getUpdateTime().toString();
	
	}

		/** Recuperamos el valor de un usuario por un id. */

	@Override
	public List<Guest> getGuestId(String id) throws InterruptedException, ExecutionException {

		List<Guest> response = new ArrayList<>();
    	Guest guest;		
		ApiFuture<QuerySnapshot> querySnapshotApiFuture = firebase.getFirestore().collection(COL_NAME).whereEqualTo("id",id).get();
		    	
		try {
		     for(DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
		         guest = doc.toObject(Guest.class);
		         guest.setId(doc.getId());
		         response.add(guest);
		         System.out.println("Respuesta Back");
		         System.out.println(response);
		     }
		   //Devolvemos la respuesta en este caso los json de las coleccion
		   return response;
		    	
		 }catch(Exception e) {
			 	System.out.println(e);
		        return null;
		 }	
		    	
   }
    
}
