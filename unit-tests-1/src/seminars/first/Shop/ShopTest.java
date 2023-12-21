package seminars.first.Shop;


import java.util.ArrayList;
import java.util.List;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

    public static void main(String[] args) {
        Product product1 = new Product();
        product1.setCost(150);
        product1.setTitle("Bananas");
        Product product2 = new Product();
        product2.setTitle("Milk");
        product2.setCost(70);
        Product product3 = new Product();
        product3.setCost(120);
        product3.setTitle("Cake");
        Product product4 = new Product();
        product4.setTitle("Meat");
        product4.setCost(650);
        Product product5 = new Product();
        product5.setCost(180);
        product5.setTitle("Beer");

        java.util.List<Product> list = new ArrayList<>();
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);

        Shop shop = new Shop();
        shop.setProducts(list);

        //TESTS

        // 1. Тесты, чтобы проверить, что магазин хранит верный список продуктов
        // (правильное количество продуктов, верное содержимое корзины).
        shop.testProductsListPositive(5
                , product1, product2, product3, product4, product5);

        Product product6 = new Product();
        product6.setTitle("Bread");
        product6.setCost(50);
        shop.testProductsListNegative_IncorrectProducts(product6);

        // 2. тесты для проверки корректности работы метода getMostExpensiveProduct
        // (правильность нахождения сасого дорогого продукта).
        shop.testSortProductsByPricePositive(
                List.of(product2, product3, product1, product5, product4));

        shop.testSortProductsByPriceNegative(
                List.of(product3, product2, product1, product4, product5));

        // 3. тесты для проверки корректности работы метода sortProductsByPrice
        // (правильность сортировки).
        shop.testGetMostExpensiveProductPositive(product4);

        shop.testGetMostExpensiveProductNegative(product1);

    }
}