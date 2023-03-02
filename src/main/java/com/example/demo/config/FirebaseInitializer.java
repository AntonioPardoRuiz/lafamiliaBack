package com.example.demo.config;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.stereotype.Service;

//Importamos las librerias de google.
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseInitializer {
	@PostConstruct
	private void iniFirestore() throws IOException {
		InputStream serviceAccount =getClass().getClassLoader().getResourceAsStream("mifamilia-3d548-firebase-adminsdk-8l7yt-1670c17d7a.json");
		//InputStream serviceAccount =getClass().getClassLoader().getResourceAsStream("catchlead.json");
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                //.setCredentials(GoogleCredentials.getApplicationDefault())
				.setDatabaseUrl("https://mifamilia-3d548.firebaseapp.com/")
		//		.setDatabaseUrl("https://catchleadsdb.firebaseapp.com/")
				.build();
				//Con esto inicializamos con la base de datos.
		if(FirebaseApp.getApps().isEmpty()){
			FirebaseApp.initializeApp(options);
		}
	}
	
	public Firestore getFirestore() {
		System.out.println(FirestoreClient.getFirestore());
		return FirestoreClient.getFirestore();
	}
		//FirebaseApp firebaseApp = FirebaseApp.initializeApp(options);
		//		return FirestoreClient.getFirestore(firebaseApp);


	
}
