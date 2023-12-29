package com.example.springweb;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
class BookController {

    // Хранение книг в списке
    private List<String> books = new ArrayList<>();

    // Обработчик GET-запроса для получения всех книг
    @GetMapping
    public List<String> getAllBooks() {
        return books;
    }

    // Обработчик GET-запроса для получения книги по ее идентификатору
    @GetMapping("/{id}")
    public String getBookById(@PathVariable int id) {
        if (id >= 0 && id < books.size()) {
            return books.get(id);
        } else {
            return "Книга не найдена";
        }
    }

    // Обработчик POST-запроса для добавления новой книги
    @PostMapping
    public String addBook(@RequestBody String book) {
        books.add(book);
        return "Книга успешно добавлена";
    }

    // Обработчик DELETE-запроса для удаления книги по ее идентификатору
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        if (id >= 0 && id < books.size()) {
            books.remove(id);
            return "Книга успешно удалена";
        } else {
            return "Книга не найдена";
        }
    }
}
