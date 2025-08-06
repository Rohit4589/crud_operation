package in.ashok;

import java.util.List;
import org.springframework.stereotype.Service;
import in.ashok.binding.Book_Details;

@Service
public class BookServiceImplementation implements Sservice {

    private final BookRepository bookRepo;

    public BookServiceImplementation(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public String upsertBook(Book_Details book) {
        if (book.getBookId() != null) {
            Book_Details existingBook = bookRepo.findById(book.getBookId())
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + book.getBookId()));

            existingBook.setBookName(book.getBookName());
            existingBook.setBookAuthor(book.getBookAuthor());
            existingBook.setBookPrice(book.getBookPrice());

            bookRepo.save(existingBook);
            return "Record Updated";
        } else {
            bookRepo.save(book);
            return "Record Inserted";
        }
    }

    @Override
    public List<Book_Details> getAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public String updateBook(Book_Details book) {
        return upsertBook(book); // Reuse upsert logic
    }

    @Override
    public String deleteBook(Integer bookId) {
        bookRepo.deleteById(bookId);
        return "Book Deleted";
    }
}
