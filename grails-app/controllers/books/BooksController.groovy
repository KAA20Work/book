package books

import grails.converters.JSON


class BooksController {
    def add() {
        def book = new Book(id: 1, title: "War and Piece", author: new Author(id: 1, name: "Lev Tolstoy"))
        book.save()
        def book2 = new Book(id: 2, title: "Crime and Punishment", author: new Author(id: 2, name: "Dostoevsky"))
        book2.save()
        redirect action: 'list'
    }
    def list() {
        def books = Book.list(sort:"title", order:"desc")
        render books as JSON
    }
    def delete() {
        def book = Book.get(1)
        book.delete(flush: true)
        redirect action: 'list'
    }
}
