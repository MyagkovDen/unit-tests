package seminars.first.Shop;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        List<Product> sortedList = new ArrayList<>(products);
        sortedList.sort((e1, e2) -> e1.getCost() - e2.getCost());
        return sortedList;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        List<Product> sortedList = new ArrayList<>(products);
        Product product = sortedList.stream().max((e1, e2) -> e1.getCost() - e2.getCost()).get();
        return product;
    }

    public void testProductsListPositive(int n, Product... products) {
        assertThat(getProducts())
                .isNotEmpty()
                .hasSize(n)
                .contains(products);
    }

    public void testProductsListNegative_IncorrectProducts(Product... products) {
        assertThat(getProducts())
                .doesNotContain(products);
    }

    public void testSortProductsByPricePositive(List<Product> products) {
        assertThat(sortProductsByPrice()).isEqualTo(products);
    }

    public void testSortProductsByPriceNegative(List<Product> products) {
        assertThat(sortProductsByPrice()).isNotEqualTo(products);
    }

    public void testGetMostExpensiveProductPositive(Product product) {
        assertThat(getMostExpensiveProduct()).isEqualTo(product);
    }

    public void testGetMostExpensiveProductNegative(Product product) {
        assertThat(getMostExpensiveProduct()).isNotEqualTo(product);
    }

}