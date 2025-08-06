package in.ashok.binding;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Book_Information")
public class Book_Details {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Book_id")
    private Integer bookId;

    @Column(name = "Book_name")
    private String bookName;

    @Column(name = "Book_Author")
    private String bookAuthor;

    @Column(name = "Book_price")
    private Double bookPrice;
}
