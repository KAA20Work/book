package books

import grails.converters.JSON
import grails.gorm.DetachedCriteria
import org.springframework.beans.factory.annotation.Autowired


class BooksController {
    @Autowired
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
