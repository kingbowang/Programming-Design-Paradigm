import lab0.publication.Person;
import lab0.publication.Book;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * A JUnit test class for the Book class.
 */
public class BookTest {

    private Book book;

    @Before
    public void setUp() {

        Person person = new Person("Mark", "Smith", 1984);
        book = new Book("JAVA", person, 45.72f);
    }

    @Test
    public void getTitle() {
        assertEquals("JAVA", book.getTitle());
    }

    @Test
    public void getPrice() {
        assertEquals(45.72f, book.getPrice(), 0);
    }

    @Test
    public void getAuthor() {
        assertEquals("Mark", book.getAuthor().getFirstName());
        assertEquals("Smith", book.getAuthor().getLastName());
        assertEquals(1984, book.getAuthor().getYearOfBirth());
    }
}