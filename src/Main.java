import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> shoppingList = new ArrayList<>(); // Создаем новый список

        options();

        while (true) {
            System.out.println("Выберите операцию:");
            String operation = scanner.nextLine();

            if ("end".equals(operation)) break;
            
            switch (operation) {
                case "1":
                    addProduct(scanner, shoppingList);
                    break;
                case "2":
                    System.out.println("Список покупок:");
                    printList(shoppingList);
                    break;
                case "3":
                    deleteProduct(scanner, shoppingList);
                    printList(shoppingList);
                    break;
                case "4":
                    searchProduct(scanner, shoppingList);
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }

    private static void searchProduct(Scanner scanner, ArrayList<String> shoppingList) {
        System.out.println("Введите текст для поиска:");
        String searchProd = scanner.nextLine();
        String searchProdLower = searchProd.toLowerCase();
        System.out.println("Найдено:");
        for (int i = 0; i < shoppingList.size(); i++) {
            String listContLower = shoppingList.get(i).toLowerCase();
            if (listContLower.contains(searchProdLower)) {
                System.out.println((i + 1) + "." + shoppingList.get(i));
            }
        }
    }

    private static void deleteProduct(Scanner scanner, ArrayList<String> shoppingList) {
        System.out.println("Что из списка хотите удалить?");
        printList(shoppingList);
        String delProduct = scanner.nextLine();
        if (isNumeric(delProduct)) {
            System.out.println("Продукт " + shoppingList.get(Integer.parseInt(delProduct) - 1) + " удален, в списке осталось:");
            shoppingList.remove(Integer.parseInt(delProduct) - 1);
        } else {
            System.out.println("Продукт " + delProduct + " удален, в списке осталось:");
            shoppingList.remove(delProduct);
        }
    }

    private static void addProduct(Scanner scanner, ArrayList<String> shoppingList) {
        System.out.println("Какую покупку хотите добавить?");
        String addProduct = scanner.nextLine();
        shoppingList.add(addProduct);
        System.out.println("Количество товаров в списке: " + shoppingList.size());
    }

    public static void options() {  // Варианты команд для работы со списком
        System.out.println("Операции со списком покупок:");
        System.out.println("1. Добавить товар в список.");
        System.out.println("2. Просмотреть список.");
        System.out.println("3. Удалить товар из списка.");
        System.out.println("4. Поиск товара в списке.");
    }

    public static void printList(ArrayList prodList) { // Метоб для вывода актуального списка продктов
        for (int i = 0; i < prodList.size(); i++) {
            System.out.println((i + 1) + ". " + prodList.get(i));
        }
    }

    private static boolean isNumeric(String s) {  // Проверка введенного текста является он String или Integer
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}