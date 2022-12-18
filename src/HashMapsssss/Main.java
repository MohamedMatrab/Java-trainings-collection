package HashMapsssss;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<String,String> names=new HashMap<String,String>();

        names.put("MM","Mohamed Matrab");
        names.put("NL","Nasrollah Laddad");
        names.put("HK","Halim Kaoutari");

        System.out.println(names.containsValue("Nasrollah Laddad"));

    }
}
