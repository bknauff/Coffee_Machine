import java.util.*;

public class CoffeeMachine {

    Scanner scanner;
    int water;
    int milk;
    int beans;
    int money;
    int cups;

    public CoffeeMachine(){
        this.scanner = new Scanner(System.in);
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.money = 550;
        this.cups = 9;
    }

    public void action(){
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.next();
        switch(action){
            case "buy":
                buyChoice();
                break;
            case "fill":
                fill();
                break;
            case "take":
                System.out.println("I gave you $"+this.money);
                this.money = 0;
                action();
                break;
            case "remaining":
                amount();
                action();
                break;
            case "exit":
                break;

        }
    }

    public void amount(){
        System.out.println("\nThe coffee machine has:\n" +this.water+" of water\n" +
                +this.milk+" of milk\n" +this.beans+" of coffee beans\n" +this.cups+ " of " +
                "disposable cups\n" +this.money+ " of money\n");
    }

    public void buyChoice(){
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte," +
                "3 - cappuccino, back - back to main menu:");
        var buyChoice = scanner.next();
        switch(buyChoice){
            case ("1"):
                buyEsp();
                break;
            case ("2"):
                buyLat();
                break;
            case ("3"):
                buyCap();
                break;
            case ("back"):
                action();
        }

    }

    public void buyEsp(){
        if((this.water/250) >=1 && (this.beans/16) >=1){
            System.out.println("I have enough resources, making you a coffee!\n");
            this.water -= 250; this.beans -= 16; this.money +=4; this.cups -=1;
            action();

        }
        else{
            if((this.water/250) < 1)
                System.out.println("Sorry not enough water!\n");
            else
                System.out.println("Sorry not enough coffee beans!\n");
            action();
        }
    }

    public void buyLat(){
        if((this.water/350) >=1 && (this.beans/20) >=1 && (this.milk/75) >=1){
            System.out.println("I have enough resources, making you a coffee!\n");
            this.water -= 350; this.beans -= 20; this.milk -= 75; this.money +=7; this.cups -=1;
            action();

        }
        else{
            if((this.water/350) < 1)
                System.out.println("Sorry not enough water!\n");
            else if(this.milk/75 < 1)
                System.out.println("Sorry not enough milk!\n");
            else
                System.out.println("Sorry not enough coffee beans!\n");
            action();
        }
    }

    public void buyCap(){
        if((this.water/200) >=1 && (this.beans/12) >=1 && (this.milk/100) >=1){
            System.out.println("I have enough resources, making you a coffee!\n");
            this.water -= 200; this.beans -= 12; this.milk -= 100; this.money +=6; this.cups -=1;
            action();

        }
        else{
            if((this.water/200) < 1)
                System.out.println("Sorry not enough water!\n");
            else if(this.milk/100 < 1)
                System.out.println("Sorry not enough milk!\n");
            else
                System.out.println("Sorry not enough coffee beans!\n");
            action();
        }
    }

    public void fill(){
        System.out.println("Write how many ml of water do you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.beans += scanner.nextInt();
        System.out.println("Write hoe many disposable cups of coffee do you want to add:");
        this.cups += scanner.nextInt();

        action();
    }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        boolean status = true;
        machine.action();
    }
}