package books

class Book {
    int id
    String author
    String title

    Book(int id, String author, String title) {
        this.id = id
        this.author = author
        this.title = title
    }
    String getAuthor() {
        return this.author
    }
}
