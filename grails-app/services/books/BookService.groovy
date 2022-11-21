package books

import grails.transaction.Transactional


class BookService {
    static scope = "prototype"

    def listBooks() {
        Book.list()
    }
    @Transactional
    def add() {
        def book = new Book(id: 1, title: "War and Piece", author: new Author(id: 1, name: "Lev Tolstoy"))
        book.save()
        def book2 = new Book(id: 2, title: "Crime and Punishment", author: new Author(id: 2, name: "Dostoevsky"))
        book2.save()
    }
    @Transactional
    def delete() {
        def book = Book.get(1)
        book.delete(flush: true)
    }
    @Transactional
    def update() {
        def book = Book.get(1)
        book.setTitle("War and War")
        book.save(flush: true)
    }
    @Transactional
    def find() {
        def book = Book.findByTitle("Crime and Punishment")
        return book
    }
    @Transactional
    def findByTwoConditions() {
        def query = Book.where{ title == "War and Piece" }
        def query2 = query.where {id == 1}
        return query2
    }
}
