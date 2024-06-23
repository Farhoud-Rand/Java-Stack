public class Device {
     int battery;

     public Device() {
          this.battery = 100;

     }

     public void batteryLife() {
          System.out.println("your battery life is %" + this.battery);
     }
}