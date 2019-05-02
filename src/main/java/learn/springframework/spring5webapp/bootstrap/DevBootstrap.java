package learn.springframework.spring5webapp.bootstrap;

import learn.springframework.spring5webapp.model.Author;
import learn.springframework.spring5webapp.model.Book;
import learn.springframework.spring5webapp.repositories.AuthorRepository;
import learn.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData() {

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain driven design", "2544", "Harper Collins");
        Set<Book> books = new HashSet<>();
        books.add(ddd);
//        eric.getBooks().add(ddd);
        eric.setBooks(books);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Ron

        Author ron = new Author("Ron", "Johnson");
        Book noEjb = new Book("J2EE development without Ejb", "2344", "Worx");
        ron.getBooks().add(noEjb);
        authorRepository.save(ron);
        bookRepository.save(noEjb);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
