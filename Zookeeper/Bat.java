public class Bat extends Mammal {
    
    public Bat(){
        this.energy+=200;
    }
    
    public void fly(){
        this.energy-=50;
        System.err.println("The bat is airborne");
    }
    public void eatHumans(){
        this.energy+=25;
        System.err.println("The bat is Satisfied ");
    }
    public void attackTown(){
        this.energy-=100;
        System.out.println("The attack of the Bat was destroying");
    }
}   
