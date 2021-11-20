package lesson11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private HashMap<String, ArrayList<String>> phoneBookStorage = new HashMap<>();

    public void add(String name, String phoneNumber){
        if (phoneBookStorage.get(name) == null){
            phoneBookStorage.put(name, new ArrayList<String>());
        }
        phoneBookStorage.get(name).add(phoneNumber);
    }

    public ArrayList get(String name){
        return phoneBookStorage.get(name);
    }

    @Override
    public String toString() {
        String str = "PhoneBook:\n";
        for(Map.Entry<String, ArrayList<String>> entry: phoneBookStorage.entrySet()){
            str += entry.getKey() + ": ";
            for(String phoneNumber: entry.getValue()){
                str += phoneNumber + " ";
            }
            str += "\n";
        }
        return str;
    }
}
