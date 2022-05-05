package Algorithms.Edunext.Text;

import java.util.HashSet;
import java.util.Set;

public class textLinkedList {

    public static void main(String[] args) {
        Set s = new HashSet();
        String a[] = {
            "i", "came", "i", "came", "q"
        };

        for(int i =0; i<a.length; i++){
            s.add(a[i]);
        }

        System.out.println(s.size());
    }
}
