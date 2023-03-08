package com.example.demo.dao;
import java.util.List;
import java.util.concurrent.ExecutionException;
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

@Service
public class GiftsDaoImpl implements IGiftsDao {

    @Autowired
	private FirebaseInitializer firebase;

    public static final String COL_NAME="gifts";


  //Recordemos que firebase no trabaja con sql.Trabaja con colecciones. 
	@Override
    public List<Gifts> getGifts() throws InterruptedException, ExecutionException {
		System.out.println("getGifts");
    	List<Gifts> response = new ArrayList<>();
    	Gifts gifts;
    	
    	ApiFuture<QuerySnapshot> querySnapshotApiFuture = firebase.getFirestore().collection(COL_NAME).get();
    	try {
    		for(DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
    			gifts = doc.toObject(Gifts.class);
    			gifts.setId(doc.getId());
    			response.add(gifts);
    		}
    	return response;
    	} catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}	
    }


	/** METODO POST QUE PERMITE AÑADIR DATOS A LOS PROCESOS. */
	@Override
	public String postGifts(Gifts gifts) throws InterruptedException, ExecutionException {

		System.out.println("postGiftsDao");
		//Sin documento
		///String documento = null;
	    //System.out.println(documento);
		Firestore dbFirestore = firebase.getFirestore();
		//Si document() no le defines, nada te genera de manera automatica el nombre del documento en firebase.
		
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document().set(gifts);
		System.out.println(collectionsApiFuture.get().getUpdateTime().toString());

		return collectionsApiFuture.get().getUpdateTime().toString();
	
	}
    
}
