package in.ashok;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import in.ashok.binding.Book_Details;

public interface BookRepository extends JpaRepository<Book_Details, Serializable> {
}
