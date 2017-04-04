package support;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by Sublimee on 15.03.2017.
 */
public class DBConnector  {


    public static void init() throws FileNotFoundException
    {
        FileInputStream serviceAccount = new FileInputStream("C:\\IntelliJIDEA2016.3.5(64)Project\\Arcadia\\ArcadiaWebProject\\coopcopy-5dc9f-firebase-adminsdk-zgprh-9bab625579.json");

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
    }
	
	    public void getSignedUsersBetweenDates(final Collection collection, long date1 , long date2) {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("/users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                synchronized (collection) {
                    ArrayList<String> names = new ArrayList<String>();
                    names.add("Email");
                    names.add("Name");
                    names.add("Date");
                    collection.addArrayList(names);
                    for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                        Long date = ((Long) userSnapshot.child("dateCreated").getValue());
                        if (date >= date1 && date <= date2)
                        {
                            ArrayList<String> user = new ArrayList<String>();
                            user.add((String) userSnapshot.child("name").getValue());
                            user.add((String) userSnapshot.child("email").getValue());
                            user.add(date.toString());
                            collection.addArrayList(user);
                        }

                    }
                    collection.notifyAll();
                }
            }

            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }



}
