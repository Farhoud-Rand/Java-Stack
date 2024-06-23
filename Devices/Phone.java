public class Phone extends Device {

     public void call() {
          this.battery -= 5;
          
          if (this.battery <= 0) {
               this.battery = 0;
               System.out.println("your phone out of battery");
          }
          else if (this.battery <= 10){
               System.out.println("low battery");
          }
     }

     public void playingGame() {
          if (this.battery <=25) {
               System.out.println("u cant play another game your battery is less than 25% recharge to play ");
               
               
          }
          else{

               this.battery -= 20;
               if (this.battery <= 0) {
                    this.battery = 0;
                    System.out.println("your phone out of battery");
               }
               else if (this.battery <= 10){
                    System.out.println("low battery please recharge");
               }
          }
     }

     public void charging() {
          this.battery += 50;
          if (this.battery >= 100) {
               this.battery = 100;
               System.out.println("your phone is fully charged");

     }
}
}
