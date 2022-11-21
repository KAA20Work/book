package books

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(HelloController)
class BookControllerSpec extends Specification {

    void "test index"() {

        when:
        controller.index()
        then:
        response.text == 'Hello'
    }
}
