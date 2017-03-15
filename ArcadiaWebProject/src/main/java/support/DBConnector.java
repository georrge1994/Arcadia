package support;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Vector;

/**
 * Created by Sublimee on 15.03.2017.
 */
public class DBConnector  {


    public static void init() throws FileNotFoundException
    {
        FileInputStream serviceAccount = new FileInputStream("C:\\Projects\\arcadia_test_projects\\lesson2\\coopcopy-5dc9f-firebase-adminsdk-zgprh-9bab625579.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                .setDatabaseUrl("https://coopcopy-5dc9f.firebaseio.com/")
                .build();
        boolean hasBeenInitialized=false;
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
        for(FirebaseApp app : firebaseApps){
            if(app.getName().equals("[DEFAULT]")){
                hasBeenInitialized=true;
            }
        }

        if(!hasBeenInitialized) {
            FirebaseApp.initializeApp(options);
        }

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
    }



}
