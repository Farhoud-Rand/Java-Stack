public class Sculpture extends Art {
     private String material;

     public Sculpture(String title, String author, String description, String material) {
          super(title, author, description);
          this.material = material;
     }

     @Override
     public String toString() {
          return "Sculpture class " + super.toString() + "material=" + this.material;
     }

     public void viewArt() {
          System.out.println(toString());
     }

}