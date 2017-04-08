package support.pdf;

import java.util.HashMap;
import java.util.Map;

public class Data {

    private Map<String, String> users;

    public Data() {
        users = new HashMap<>();
    }

    private void fillMap () {
        for(int i = 0; i < 10; i++) {
            users.put("Vanya" + i, "2017.08." + i);
        }
    }

    public Map<String, String> getUsers() {
        fillMap();
        return users;
    }
}
