package in.ashok;

import java.util.List;
import in.ashok.binding.Book_Details;

public interface Sservice {
    String upsertBook(Book_Details book);
    List<Book_Details> getAllBooks();
    String updateBook(Book_Details book);
    String deleteBook(Integer bookId);
}
