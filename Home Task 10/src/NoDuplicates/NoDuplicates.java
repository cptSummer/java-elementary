package NoDuplicates;

import java.util.ArrayList;

import java.util.HashSet;

public class NoDuplicates {

    public ArrayList<Object> removeDuplicates(ArrayList<Object> collection) {
        return new ArrayList<>(new HashSet<>(collection));
    }


}
