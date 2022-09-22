import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Smartphone item1 = new Smartphone(1, "смартфон1", 100, "Россия");
    Book item2 = new Book(2, "Книга2", 200, "Петров П.П.");
    Book item3 = new Book(3, "книга3", 300, "Иванов И.И.");
    Smartphone item4 = new Smartphone(4, "смартфон4", 400, "Китай");
    Book item5 = new Book(5, "книга5", 500, "Сидоров С.С.");

    @Test
    public void shouldShowAllItems() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);

        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldDeleteItem() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.removeById(item2.getId());

        Product[] expected = {item1, item3, item4, item5};
        Product[] actual = repo.getItems();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSaveItem() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);

        Product[] expected = {item1, item2, item3, item4, item5};
        Product[] actual = repo.save(item5);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGiveError() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);

        Assertions.assertThrows(NotFoundException.class, () -> repo.removeById(6));

    }



}
