package books


class BooksController {
    def addBook() {
        def newBook = new Book(1, "Lev Tolstoy", "War and Piece")
        newBook.save()
        render "Book was saved correctly!"
    }
}
