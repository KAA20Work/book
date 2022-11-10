package books


class BooksController {
    def index() {
        def book = new Book(id: 1, title: "War and Piece", author: new Author(id: 1, name: "Lev Tolstoy"))
        book.save()

        render "Saved successfully!"
    }
}
