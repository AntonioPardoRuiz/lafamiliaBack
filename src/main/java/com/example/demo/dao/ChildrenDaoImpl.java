package com.example.demo.dao;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.ArrayList;
import com.example.demo.config.FirebaseInitializer;
import com.example.demo.entitys.*;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import org.springframework.beans.factory.annotation.Autowired;

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
    
}
