public class ProductManager {

    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {

        this.repo = repo;
    }

    public void add(Product item) {
        repo.save(item);
    }

    public Product[] searchBy(String name) {
        Product[] result = new Product[0];
        for (Product items : repo.getItems()) {
            if (matches(items, name)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = items;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

}
