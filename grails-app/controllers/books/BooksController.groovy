package books

import grails.converters.JSON
import grails.gorm.DetachedCriteria


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
    def update() {
        def book = Book.get(1)
        book.setTitle("War and War")
        book.save(flush: true)
        redirect action: 'list'
    }
    def find() {
        def book = Book.findByTitle("Crime and Punishment")
        render book.title
    }
    def findByTwoConditions() {
        def query = Book.where{ title == "War and Piece" }
        def query2 = query.where {id == 1}
        render query2.find().author.name
    }
}
