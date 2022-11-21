package books

import grails.converters.JSON


class BooksController {

    BookService service
    def add() {
        service.add()
        redirect action: 'list'
    }
    def list() {
        render service.listBooks() as JSON
    }
    def delete() {
        service.delete()
        redirect action: 'list'
    }
    def update() {
        service.update()
        redirect action: 'list'
    }
    def find() {
        def book = service.find()
        render book.title
    }
    def findByTwoConditions() {
        def book = service.findByTwoConditions()
        render book.find().author.name
    }
}
