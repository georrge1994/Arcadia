package Firebase;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Георгий on 13.03.2017.
 */
public class Connection {

    private String email, name, role;

    public Connection(){
       /* FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("coopcopy-5dc9f-firebase-adminsdk-zgprh-9bab625579.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                    .setDatabaseUrl("https://coopcopy-5dc9f.firebaseio.com/")
                    .build();

            FirebaseApp.initializeApp(options);
            final FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference ref = database.getReference("/groupUsers/4aZZszu3IaPT0OSvM3CREIGfUzD3");
            ref.addValueEventListener(new ValueEventListener() {
                //@Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot chatSnapshot: dataSnapshot.getChildren()) {
                        email = (String) chatSnapshot.child("email").getValue();
                        name = (String) chatSnapshot.child("name").getValue();
                        role = (String) chatSnapshot.child("role").getValue();
                    }
//                DataSnapshot childSnapshot =  dataSnapshot.getChildren();
//                dataSnapshot.getValue();
//                System.out.println(dataSnapshot.getKey() + " was " + test.t1 + " meters tall.");
                    //dataSnapshot.getValue(Test.class);
                    //System.out.println(post);
                }

                //@Override
                public void onCancelled(DatabaseError databaseError) {
                    System.out.println("The read failed: " + databaseError.getCode());
                }
            });

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }*/
        email = "error1 ";
        name = "error2 ";
        role = "error3";
    }

    public String getMessage() {
        return email + " "+ name + " " + role;
    }


}

