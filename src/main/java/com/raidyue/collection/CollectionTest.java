import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionTest {

    public static void main(String[] args) {
        List<String> ids = new ArrayList<>();
        ids.add("1");
        List<String> ids2 = new ArrayList<>();
        ids.addAll(ids2);
        System.out.println("....");

        Set<String> s1 = new HashSet<>();
        s1.add("1");
        s1.add("1");
        System.out.println(s1.size());

        ids.remove(0);
        for (int i = 0; i < 10; i++) {
            
            ids.add(i + "");
        }
        System.out.println(ids.subList(1,10));

    }

}
