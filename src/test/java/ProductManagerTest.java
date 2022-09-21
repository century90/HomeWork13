import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Smartphone item1 = new Smartphone(1, "смартфон1", 100, "Россия");
    Book item2 = new Book(2, "Книга2", 200, "Петров П.П.");
    Book item3 = new Book(3, "книга3", 300, "Иванов И.И.");
    Smartphone item4 = new Smartphone(4, "смартфон4", 400, "Китай");
    Book item5 = new Book(5, "книга5", 500, "Сидоров С.С.");
    Book item6 = new Book(2, "Книга2", 200, "ПЕетров П.П.");

    @Test
    public void shouldAddItems() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);

        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repo.save(item5);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByItems() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);

        Product[] expected = {item2};
        Product[] actual = manager.searchBy("Книга2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByItems2Positions() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);
        manager.add(item6);

        Product[] expected = {item2, item6};
        Product[] actual = manager.searchBy("Книга2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByItemsNotPositions() {
        manager.add(item1);
        manager.add(item2);
        manager.add(item3);
        manager.add(item4);
        manager.add(item5);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Книга10");

        Assertions.assertArrayEquals(expected, actual);
    }

}
