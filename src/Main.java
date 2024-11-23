import flower.*;
import Command.*;
import java.util.*;

public class Main {
    private static boolean exit = false;

    public static void main(String[] args) {
        Bouquet bouquet = new Bouquet();
        Invoker invoker = new Invoker();
        Scanner scanner = new Scanner(System.in);
        List<Flower> flowers = new ArrayList<>();
        List<Accessories> accessories = new ArrayList<>();

        double[] lengths = FlowersByStemLength(scanner);
        Map<Integer, Command> commandMap = new HashMap<>();
        commandMap.put(1, new SortFlowersCommand(bouquet));
        commandMap.put(2, new SearchFlowersCommand(bouquet, lengths[0], lengths[1]));
        commandMap.put(3, new ShowBouquetCommand(bouquet));
        commandMap.put(4, new CreateNewFlowerCommand(bouquet, scanner));
        commandMap.put(5, new CreateNewAccessoryCommand(bouquet, scanner));
        commandMap.put(6, new LoadFlowersCommand(flowers, "flowers.txt"));
        commandMap.put(7, new LoadAccessoriesCommand(accessories, "accessories.txt"));
        commandMap.put(8, new AddLoadedFlowersCommand(bouquet, flowers));
        commandMap.put(9, new AddLoadedAccessoriesCommand(bouquet, accessories));
        commandMap.put(10, new Price200(bouquet));

        printMenu(scanner, invoker, commandMap);

        System.out.println("Вихід");
        scanner.close();
    }


    private static double[] FlowersByStemLength(Scanner scanner) {
        System.out.print("Введіть мінімальну довжину: ");
        double minLength = scanner.nextDouble();
        System.out.print("Введіть максимальну довжину: ");
        double maxLength = scanner.nextDouble();
        return new double[]{minLength, maxLength};
    }


    private static void printMenu(Scanner scanner, Invoker invoker, Map<Integer, Command> commandMap) {
        while (true) {
            System.out.println("\nМеню:");
            for (Map.Entry<Integer, Command> entry : commandMap.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue().getDesc());
            }
            System.out.println("0: Вихід");
            System.out.print("Виберіть дію: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) {
                break;
            }

            Command command = commandMap.get(choice);
            if (command != null) {
                command.execute();
            } else {
                System.out.println("Такої дії не існує");
            }
        }
    }


}
