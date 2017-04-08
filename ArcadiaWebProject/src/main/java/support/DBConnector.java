package support;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class DBConnector {

    public synchronized static void init() throws FileNotFoundException {
        FileInputStream serviceAccount = new FileInputStream("D:\\Arcadia\\myCurrent\\Arcadia\\ArcadiaWebProject\\coopcopy-5dc9f-firebase-adminsdk-zgprh-9bab625579.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
                .setDatabaseUrl("https://coopcopy-5dc9f.firebaseio.com/")
                .build();
        boolean hasBeenInitialized = false;
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
        for (FirebaseApp app : firebaseApps) {
            if (app.getName().equals("[DEFAULT]")) {
                hasBeenInitialized = true;
            }
        }

        if (!hasBeenInitialized) {
            FirebaseApp.initializeApp(options);
        }
    }

    public void getSignedUsersBetweenDates(final Collection collection, long date1, long date2) {
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
                        if (date >= date1 && date <= date2) {
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


    public void getCoursesBetweenDates(final Collection collection, long date1, long date2) {

        HashMap<String, Long> grCount = new HashMap<String, Long>();
        HashMap<String, Pair> result = new HashMap<String, Pair>();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        DatabaseReference ref = database.getReference("/");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.child("userGroups").getChildren()) {
                    grCount.put(userSnapshot.getKey(), userSnapshot.getChildrenCount());
                }
                for (DataSnapshot group : dataSnapshot.child("groupCourses").getChildren()) {
                    for (DataSnapshot course : group.child("courses").getChildren()) {
                        if ((Long) course.child("dateStart").getValue() >= date1) {
                            if (result.containsKey(course.getKey()))
                                result.get(course.getKey()).addL(grCount.get(group.getKey()).longValue());
                            else
                                result.put(course.getKey(), new Pair(grCount.get(group.getKey()).longValue(), 0L));
                        }

                        if ((Long) course.child("dateEnd").getValue() <= date2) {
                            if (result.containsKey(course.getKey()))
                                result.get(course.getKey()).addR(grCount.get(group.getKey()).longValue());
                            else
                                result.put(course.getKey(), new Pair(0L, grCount.get(group.getKey()).longValue()));
                        }
                    }
                }

                synchronized (collection) {
                    ArrayList<String> names = new ArrayList<String>();
                    names.add("Course");
                    names.add("Signed Users");
                    names.add("Passed Users");
                    collection.addArrayList(names);
                    for (Map.Entry<String, Pair> entry : result.entrySet()) {
                        ArrayList<String> newCourse = new ArrayList<String>();
                        newCourse.add(entry.getKey());
                        newCourse.add(entry.getValue().left.toString());
                        newCourse.add(entry.getValue().right.toString());
                        collection.addArrayList(newCourse);
                    }
                    collection.notifyAll();
                }

            }

            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    public void getUsersRating(final Collection collection, String type, int howMuch) {
        ArrayList<User> allUsers = new ArrayList<User>();
        ArrayList<User> result = new ArrayList<User>();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("/users");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    allUsers.add(new User(
                            (String) userSnapshot.child("email").getValue(),
                            (String) userSnapshot.child("name").getValue(),
                            (Long) userSnapshot.child("rating").getValue()
                    ));
                }
                allUsers.sort(User::compareTo);
                int real = howMuch;
                if (howMuch > allUsers.size())
                    real = allUsers.size();
                if (howMuch <= 0)
                    real = 0;
                switch (type) {
                    case "hi": {
                        for (int i = 0; i < real; i++)
                            result.add(allUsers.get(i));
                    }
                    break;
                    case "low": {
                        for (int i = 0; i < real; i++)
                            result.add(allUsers.get(allUsers.size() - i - 1));
                    }
                    break;
                    default:
                        break;
                }

                synchronized (collection) {

                    ArrayList<String> names = new ArrayList<String>();
                    names.add("name");
                    names.add("email");
                    names.add("rating");
                    collection.addArrayList(names);
                    for (User nextUser: result)
                    {
                        ArrayList<String> newUser = new ArrayList<String>();
                        newUser.add(nextUser.name);
                        newUser.add(nextUser.email);
                        newUser.add(nextUser.rating.toString());
                        collection.addArrayList(newUser);
                    }
                    collection.notifyAll();
                }
            }

            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    class Pair {
        Long left;
        Long right;

        public Pair(Long L, Long R) {
            this.left = L;
            this.right = R;
        }

        public void addL(Long left) {
            this.left += left;
        }

        public void addR(Long right) {
            this.right += right;
        }

    }
}






