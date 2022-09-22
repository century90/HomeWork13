public class AlreadyExistsException extends RuntimeException {

    public AlreadyExistsException(int id) {
        super("Товар с id " + id + " уже есть в корзине");
    }
}
