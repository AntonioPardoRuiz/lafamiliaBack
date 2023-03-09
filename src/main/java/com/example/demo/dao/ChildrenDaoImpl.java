package com.example.demo.dao;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import com.example.demo.config.FirebaseInitializer;
import com.example.demo.entitys.*;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChildrenDaoImpl implements IChildrenDao {
    
    @Autowired
	private FirebaseInitializer firebase;

    public static final String COL_NAME="children";
    
    @Override
    public List<Children> getChildren() throws InterruptedException, ExecutionException {

        System.out.println("getChildren");
    	List<Children> response = new ArrayList<>();
    	Children Children;
    	
    	ApiFuture<QuerySnapshot> querySnapshotApiFuture = firebase.getFirestore().collection(COL_NAME).get();
    	try {
    		for(DocumentSnapshot doc : querySnapshotApiFuture.get().getDocuments()) {
    			Children = doc.toObject(Children.class);
    			Children.setId(doc.getId());
    			response.add(Children);
    		}
    	return response;
    	} catch(Exception e) {
    		System.out.println(e);
    		return null;
    	}	



    }

	/** METODO POST QUE PERMITE AÑADIR DATOS A LOS PROCESOS. */
	@Override
	public String postChildren(Children children) throws InterruptedException, ExecutionException {

		System.out.println("postChildrenDao");
		//Sin documento
		///String documento = null;
	    //System.out.println(documento);
		Firestore dbFirestore = firebase.getFirestore();
		//Si document() no le defines, nada te genera de manera automatica el nombre del documento en firebase.
		
		ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document().set(children);
		System.out.println(collectionsApiFuture.get().getUpdateTime().toString());

		return collectionsApiFuture.get().getUpdateTime().toString();
	
	}
    
}
