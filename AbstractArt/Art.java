public abstract class Art{
private String title;
private String author;
private String description;

public Art (String title , String  author , String description){
     this.title = title;
     this.author = author;
     this.description = description;
}

@Override
public String toString() {
     return "title=" + title + ", author=" + author + ", description=" + description ;
}

public abstract void viewArt();


}
