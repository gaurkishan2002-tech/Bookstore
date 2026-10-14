package bookStore.BookStore.service;

import bookStore.BookStore.entity.Book;
import bookStore.BookStore.repositery.BookRepositery;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepositery bookRepositery;

    public BookService(BookRepositery bookRepositery){
        this.bookRepositery=bookRepositery;
    }

    public Book addBook(Book book){
        return bookRepositery.save(book);
    }

    public List<Book> getAllBook(){
        return bookRepositery.findAll();
    }

    public Book getBookById(Long id){
        return bookRepositery.findById(id).orElse(null);
    }

    public List<Book> searchBooks(String title){
        return bookRepositery.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> getByCategory(String category){
        return bookRepositery.findByCategoryIgnoreCase(category);
    }

    @Transactional
    public Book updateBook(Long id,Book updateBook){
        Book existBook=getBookById(id);
        existBook.setTitle(updateBook.getTitle());
        existBook.setAuther(updateBook.getAuther());
        existBook.setCategory(updateBook.getCategory());
        existBook.setPrice(updateBook.getPrice());
        existBook.setQuntity(updateBook.getQuntity());

        return bookRepositery.save(existBook);
    }

    public void deleteBook(Long id){
        Book book=getBookById(id);
        bookRepositery.delete(book);
    }
}
