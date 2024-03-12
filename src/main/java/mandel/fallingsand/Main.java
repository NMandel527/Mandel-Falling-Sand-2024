package mandel.fallingsand;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sand sand = new Sand(50, 10);
        sand.randomSand(50);
        Scanner input = new Scanner(System.in);
        try {
            sand = new Sand(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            sand.randomSand(Integer.parseInt(args[2]));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        while (true) {
            System.out.println("enter");
            String enter = input.nextLine();
            if (enter.isEmpty()) {
                sand.fall();
                System.out.println(sand.toString());
            } else {
                break;
            }
        }
    }
}
