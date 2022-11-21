package YandexContest;

import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class TaskC {
//    public static void main(String[] args) {
//        System.out.println(solve(System.in));
//    }

    public static String solve(InputStream input) {
        Scanner scanner = new Scanner(input);
        ArrayList<Product> allProducts = parseProducts(scanner.nextLine().trim());
        Criterion criterion = parseCriterion(scanner);

        ArrayList<Product> productsToBuy = new ArrayList<>();
        for (Product product : allProducts) {
            if (criterion.isMetFor(product)) {
                productsToBuy.add(product);
            }
        }
        productsToBuy.sort(Comparator.comparingLong(lhs -> lhs.id));

        JSONArray result = new JSONArray();
        for (Product product : productsToBuy) {
            result.add(product.toJson());
        }
        return result.toString();
    }

    private static ArrayList<Product> parseProducts(String rawInput) {
        ArrayList<Product> products = new ArrayList<>();
        JSONParser parser = new JSONParser();
        try {
            JSONArray rawProducts = (JSONArray) parser.parse(rawInput);
            for (Object rawProduct : rawProducts) {
                JSONObject product = (JSONObject) rawProduct;
                products.add(
                        new Product(
                                (long) product.get("id"),
                                (long) product.get("price"),
                                (String) product.get("name"),
                                DATE_FORMAT.parse((String) product.get("date"))
                        )
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("It's impossible");
        }
        return products;
    }

    private static Criterion parseCriterion(Scanner scanner) {
        Criterion criterion = new Criterion();
        for (int i = 0; i < 5; i++) {
            criterion.setField(scanner.nextLine().trim());
        }
        return criterion;
    }

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");

    private static class Product {
        long id;
        long price;
        String name;
        Date dateInStock;

        public Product(long id, long price, String name, Date dateInStock) {
            this.id = id;
            this.price = price;
            this.name = name;
            this.dateInStock = dateInStock;
        }

        public JSONObject toJson() {
            return new JSONObject(){{
                put("id", id);
                put("price", price);
                put("name", name);
                put("date", DATE_FORMAT.format(dateInStock));
            }};
        }
    }

    private static class Criterion {
        long minPrice;
        long maxPrice;
        String nameSubstring;
        Date inStockAfter;
        Date inStockBefore;

        void setField(String field) {
            String[] parts = field.split(" ");
            String type = parts[0];
            String value = parts[1];
            try {
                if ("PRICE_GREATER_THAN".equals(type)) {
                    minPrice = Long.parseLong(value);
                } else if ("PRICE_LESS_THAN".equals(type)) {
                    maxPrice = Long.parseLong(value);
                } else if ("NAME_CONTAINS".equals(type)) {
                    nameSubstring = value.toLowerCase();
                } else if ("DATE_AFTER".equals(type)) {
                    inStockAfter = DATE_FORMAT.parse(value);
                } else if ("DATE_BEFORE".equals(type)) {
                    inStockBefore = DATE_FORMAT.parse(value);
                }
            } catch (Exception e) {
                throw new RuntimeException("It's impossible");
            }
        }

        public boolean isMetFor(Product product) {
            return
                    minPrice <= product.price && product.price <= maxPrice
                            && product.name.toLowerCase().contains(nameSubstring)
                            && (product.dateInStock.after(inStockAfter) || product.dateInStock.equals(inStockAfter))
                            && (product.dateInStock.before(inStockBefore) || product.dateInStock.equals(inStockBefore));
        }
    }
}

