package books

import grails.converters.JSON


class BooksController {
    def index() {
        def book = new Book(id: 1, title: "War and Piece", author: new Author(id: 1, name: "Lev Tolstoy"))
        book.save()

        redirect action: 'list'
    }
    def list() {
        def books = Book.list()
        render books as JSON
    }
}
