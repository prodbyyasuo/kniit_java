package org.kniit.lab5.task8;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] names = {"книга", "ручка", "линейка", "пенал"};
        String[] categories = {"канцелярия", "офис", "школа"};
        Random random = new Random();

        List<ShopItem> items = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            String name = names[random.nextInt(names.length)];

            int price = 10 + random.nextInt(5);
            String category = categories[random.nextInt(categories.length)];
            items.add(new ShopItem(name, price, category));;
        }

        items.sort(Comparator.comparing(ShopItem::getName)
                .thenComparingInt(ShopItem::getPrice));

        System.out.println("Отсортированный список");
        for (ShopItem item : items) {
            System.out.println(item);
        }

        System.out.println("\nСтатистика дубликатов");
        Map<ShopItem, Integer> frequencyMap = new HashMap<>();
        for (ShopItem item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        int duplicatesFound = 0;
        for (Map.Entry<ShopItem, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Товар " + entry.getKey() + " встречается: " + entry.getValue() + " раз(а).");
                duplicatesFound++;
            }
        }
        if (duplicatesFound == 0) {
            System.out.println("Дубликатов не найдено.");
        }
    }
}
