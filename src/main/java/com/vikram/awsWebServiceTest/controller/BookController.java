package com.vikram.awsWebServiceTest.controller;

import com.vikram.awsWebServiceTest.models.Book;
import com.vikram.awsWebServiceTest.repository.MySqlRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/books")
public class BookController {

    private final MySqlRepository mySqlRepository;

    public BookController(MySqlRepository mySqlRepository) {
        this.mySqlRepository = mySqlRepository;
    }

    @PostMapping("")
    public ResponseEntity<Book> addBook (@RequestBody Book book) {
        //Spara book till DB, få den sparade boken tillbaka
        Book respBook = mySqlRepository.save(book);

        //Retunera book till avsändare
        return ResponseEntity.status(201).body(respBook);
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> getBooks () {
        //Hämta alla böcker från DB
        List<Book> books = mySqlRepository.findAll();

        //Retuera alla böcker till avsändare
        return ResponseEntity.status(200).body(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getOneBook( @PathVariable long id ) {
        //Hämta en specifk book, eller en tom book om den inte finns
        Book book = mySqlRepository.findById(id).orElse(new Book());

        //Returnera book till avsändaren
        if (book.getId() != null) return ResponseEntity.status(200).body(book);
        else                      return ResponseEntity.status(204).body(book);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> editOneBook (
            @PathVariable long id,
            @RequestBody Book payload
    ) {
        //Hämta den valda booken
        Book book = mySqlRepository.findById(id).orElse(new Book());

        //Kontrollera att den hämtade boken finns.
        if (book.getId() == null) return ResponseEntity.status(404).body(book);

        if (payload.getTitle() != null) book.setTitle(payload.getTitle());
        if (payload.getAuthor() != null) book.setAuthor(payload.getAuthor());

        //Spara boken till DB
        mySqlRepository.save(book);

        return ResponseEntity.status(200).body(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook( @PathVariable Long id ) {

        try {
            //Hämta den valda booken
            Book book = mySqlRepository.findById(id).orElseThrow();

            // Radera den valda booken
            mySqlRepository.deleteById(id);

            //Returnea en response
            return ResponseEntity.status(200).body("Det valda objektet har tagits bort");

        } catch(NoSuchElementException e) {
            return ResponseEntity.status(404).body("Det valda objektet finns inte. Kontrollera ID värdet i URL");
        }
    }
}
