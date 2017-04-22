package firebase_communication;

// describes user in DB
public class User implements Comparable<User>{
    String email = "";
    String name = "";
    Long rating = 0L;

    public User (String email, String name, Long rating){
        this.email = email;
        this.name = name;
        this.rating = rating;
    }

    @Override
    public int compareTo(User anotherUser) {
        return anotherUser.rating.compareTo(this.rating);
    }
}