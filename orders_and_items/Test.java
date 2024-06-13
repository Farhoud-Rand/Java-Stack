public class Test {
    public static void main(String [] args){
        Item item1 = new Item("mocha",10.0);
        Item item2 = new Item("latte",8.0);
        Item item3 = new Item("drip coffee",15.0);
        Item item4 = new Item("chapatino",6.0);

        Order order1 = new Order("Cindhuri");
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noua");
        Order order4 = new Order("Sam");

        order1.addItem(item3);
        System.out.println("Order 1 information:");
        System.out.println(order1.display());
        System.out.println("------------------------------------------------------------\n");

        order2.addItem(item1);
        System.out.println("Order 2 information:");
        System.out.println(order2.display());
        System.out.println("------------------------------------------------------------\n");
        
        order3.addItem(item4);
        System.out.println("Order 3 information:");
        System.out.println(order3.display());
        System.out.println("------------------------------------------------------------\n");

        order4.addItem(item2);
        System.out.println("Order 4 status before");
        System.out.println(order1.getStatusMessage());
        order1.setReady(true);
        System.out.println("Order 4 status After");
        System.out.println(order1.getStatusMessage());
        order4.addItem(item2);
        order4.addItem(item2);
        System.out.println("Order 4 information:");
        System.out.println(order4.display());

        order2.setReady(true); 
        System.out.println("Order 2 status");
        System.out.println(order2.getStatusMessage());
    }
}
