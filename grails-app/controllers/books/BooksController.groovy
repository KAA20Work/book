package books

import org.springframework.web.servlet.ModelAndView

class BooksController {
    private final HashMap<Long, Book> booksList = new HashMap<>()
    private final Map<String, User> usersByLogin = new HashMap<>()

    def beforeInterceptor = [action: this.&auth, except: ['registration', 'login']]

    BooksController() {
        booksList.put(1, new Book(1, "Lev Tolstoy", "War and Piece"))
        booksList.put(2, new Book(2, "Fedor Dostoevsky", "Crime and Punishment"))
    }

    private auth() {
        if (!session.user) {
            redirect action: 'registration'
            return false
        }
    }

    def registration() {
        if (session.user) {
            redirect action: 'list'
            return
        }

        String login = request.getParameter('login')
        String email = request.getParameter('email')
        String password = request.getParameter('password')

        if (login == null || usersByLogin.containsKey(login) || email == null || password == null) {
            render view: 'registration'
            return
        }

        User user = [login, password, email]
        usersByLogin.put(login, user)
        session.user = user
        redirect action: 'list'
    }

    def login() {
        if (session.user) {
            redirect action: 'list'
            return
        }

        String login = request.getParameter('login')
        String password = request.getParameter('password')
        User user

        if (login == null || password == null || (user = usersByLogin.get(login)) == null || user.getPassword() != password) {
            render view: 'login'
            return
        }

        session.user = user
        redirect action: 'list'
    }

    def list() {
        render view: 'book-show', model: [books: booksList.values()]
    }

    def add(String author, String title) {
        booksList.put(booksList.size() + 1, new Book(booksList.size() + 1, author, title))
        redirect action: 'list'
    }

    def remove(int id) {
        booksList.remove(id)
        redirect action: 'list'
    }

    def getBook(int id) {
        def currentBook = booksList.get(id)
        render view: 'single-book', model: [book: currentBook]
    }

}
