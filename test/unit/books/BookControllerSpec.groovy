package books

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import groovy.mock.interceptor.MockFor
import spock.lang.Specification

@TestFor(BooksController)
@Mock([BookService, Book])
class BookControllerSpec extends Specification {

    void "test list"() {

        given:
        controller.service = new BookService()
        when:
        controller.list()
        then:
        response.text == '[]'
    }
}
