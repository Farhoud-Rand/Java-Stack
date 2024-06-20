import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Museum {

     public static void main(String[] args) {
          
          ArrayList<Art> museum = new ArrayList<Art>();

          Painting p1 = new Painting("batat" ,"subhi"," el 7akat 3no ola ", "charcol " );
          Painting p2 = new Painting("tamta" ,"subhi"," el 7akat 3no ola ", "charcol " );
          Painting p3 = new Painting("tobaco" ,"subhi"," el 7akat 3no ola ", "charcol " );
          // Sculpture s1 = new Sculpture();
          // Sculpture s2 = new Sculpture();

          museum.add(p1);
          museum.add(p2);
          museum.add(p3);
          // museum.add(s1);
          // museum.add(s2);
          // Collections.shuffle(museum);
          // System.out.println(museum);
          p1.viewArt();
     }
}