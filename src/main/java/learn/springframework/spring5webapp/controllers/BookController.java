package learn.springframework.spring5webapp.controllers;

import learn.springframework.spring5webapp.model.Book;
import learn.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BookController {

    private BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books", bookRepository.findAll());
        Iterable<Book> books = bookRepository.findAll();
        for (Book book: books) {
            System.out.println(book.getTitle());
        }
        return "books";
    }
}
