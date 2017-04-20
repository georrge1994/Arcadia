package firebase_communication;

import java.util.ArrayList;

public class Collection {

    public ArrayList<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();

    public void addArrayList(ArrayList<String> arrayList)
    {
        outer.add(arrayList);
    }
}
