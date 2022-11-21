package books

import java.text.SimpleDateFormat
import java.time.LocalDateTime

class Book {

    int id
    String title
    Author author

    static mapping = {version false}

    static constraints = {
        title size: 0..100, unique: true, blank: false
        author size: 0..100, blank: false
    }
}
