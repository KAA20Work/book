package books

class User {
    String login
    String password
    String email

    User(String login, String password, String email) {
        this.login = login
        this.password = password
        this.email = email
    }
}