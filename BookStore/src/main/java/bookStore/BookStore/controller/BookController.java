package bookStore.BookStore.controller;

import bookStore.BookStore.entity.Book;
import bookStore.BookStore.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService=bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@Valid @RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getAllBook(){
        return bookService.getAllBook();
    }

    @GetMapping("/{id}")
    public Book getBookbyId(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/{search}")
    public List<Book> searchBook(@RequestParam String title ){
        return bookService.searchBooks(title);
    }

    @GetMapping("/category/{category}")
    public List<Book> getBookCategory(@PathVariable String category){
        return bookService.getByCategory(category);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id ,@Valid @RequestBody Book book){
        return  bookService.updateBook(id,book);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }

}
