package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code");
        Book designPatterns = new Book();
        Book thePragmaticProgrammer = new Book();
        Book codeComplete = new Book();
        Book[] books = new  Book[4];
        books[0] = cleanCode;
        books[1] = designPatterns;
        books[2] = thePragmaticProgrammer;
        books[3] = codeComplete;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName());
        }
        Book tenp = books[0];
        books[0] = books[3];
        books[3] = tenp;
        for (int index = 0; index < books.length; index++) {
            System.out.println(books[index].getName());
        }
        for (int index = 0; index < books.length; index++) {
            if ("Clean code".equals(books[index].getName())) {
                System.out.println(books[index].getName());
            }
        }
    }
}
