package books

import org.springframework.web.servlet.ModelAndView

class BooksController {
    private final HashMap<Long, Book> booksList = new HashMap<>()


    BooksController() {
        booksList.put(1, new Book(1, "Lev Tolstoy", "War and Piece"))
        booksList.put(2, new Book(2, "Fedor Dostoevsky", "Crime and Punishment"))
    }

    def list() {
        render view: 'book-show', model: [books: booksList.values()]
    }

    def add(String author, String title) {
        booksList.put(booksList.size() + 1, new Book(booksList.size() + 1, author, title))
        redirect action: 'list'
    }

    def remove(int id) {
        booksList.remove(id)
        redirect action: 'list'
    }

    def getBook(int id) {
        def currentBook = booksList.get(id)
        render view: 'single-book', model: [book: currentBook]
    }

}
