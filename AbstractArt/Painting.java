public class Painting extends Art {

     private String paintType;

     public Painting(String title , String  author , String description , String paintType){
          super(title, author, description);
          this.paintType = paintType;
     } 
     
     @Override
     public String toString() {
          return "Painting class " +super.toString() +" paintType ="+ this.paintType ;
     }

     public void viewArt() {
          System.out.println(toString());
     }

}