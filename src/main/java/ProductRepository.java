public class ProductRepository {

    private Product[] items = new Product[0];


    public Product[] save(Product item) {
        Product[] tmp = new Product[items.length + 1];

        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;

        return tmp;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(id);

        }

        Product[] tmp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = tmp;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public Product[] getItems() {
        return items;
    }


}
