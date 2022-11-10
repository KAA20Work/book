package books

class Author {
    int id
    String name
    static belongsTo = [book: Book]
    static mapping = {version false}
    static constraints = {
    }
}
