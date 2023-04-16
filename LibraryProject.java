package com.company;

import java.util.Scanner;

interface Library {
    void addBook(String a);

    void issueBook(String a);

    void returnBook(String a);

    void showAvailableBooks();
}

class MyLibraryProject implements Library {
    private String[] bookList;
    private String[] issuebookList;

    MyLibraryProject() {
        this.bookList = new String[100];
        this.issuebookList = new String[100];
    }

    // You have to implement a library using Java Class "Library"
    // Methods: addBook, issueBook, returnBook, showAvailableBooks
    // Properties: Array to store the available books,
    // Array to store the issued books
    @Override
    public void addBook(String bookName) {
        for (int i = 0; i < this.bookList.length; i++) {
            if (this.bookList[i] == null) {
                this.bookList[i] = bookName;
                break;
            }
        }
    }

    @Override
    public void showAvailableBooks() {
        for (String i : this.bookList) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }

    @Override
    public void issueBook(String bookName) {
        int addtoissue = 0;
        for (int i = 0; i < this.bookList.length; i++) {
            if (this.bookList[i] != null) {
                if (this.bookList[i].equals(bookName)) {
                    this.bookList[i] = null;
                    addtoissue = 1;
                    break;
                }
            }
        }
        if (addtoissue == 1) {
            for (int i = 0; i < this.bookList.length; i++) {
                if (this.issuebookList[i] == null) {
                    this.issuebookList[i] = bookName;
                    break;
                }
            }
        }
    }

    @Override
    public void returnBook(String bookName) {
        int removefromissue = 0;
        for (int i = 0; i < this.issuebookList.length; i++) {
            if (this.issuebookList[i] != null) {
                if (this.issuebookList[i].equals(bookName)) {
                    this.issuebookList[i] = null;
                    removefromissue = 1;
                    break;
                }
            }
        }
        if (removefromissue == 1) {
            for (int i = 0; i < this.bookList.length; i++) {
                if (this.bookList[i] == null) {
                    this.bookList[i] = bookName;
                    break;
                }
            }
        }

    }
    public void showissuedBooks () {
        for (String i : this.issuebookList) {
            if (i != null) {
                System.out.println(i);
            }
        }
    }
}

public class LibraryProject {
    public static void main(String[] args) {
        MyLibraryProject LP = new MyLibraryProject();
        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("Choose The Options Given Below :");
            System.out.println("1. Add a Book to the Library");
            System.out.println("2. Issue a Book from the Library");
            System.out.println("3. Return the book to the Library");
            System.out.println("4. Show Available Books");
            System.out.println("5. Show Books that are already Issued");
            System.out.println("6. Exit");
            System.out.println("--------------------------------------------");
            System.out.println("Enter Your Choice (1-6) :");
            Scanner sc = new Scanner(System.in);
            int x = sc.nextInt();
            String bookName;
            bookName = sc.nextLine();
            int Exit = 0;
            switch (x) {
                case 1:
                    System.out.println("Enter the Name of the book :");
                    bookName = sc.nextLine();
                    LP.addBook(bookName);
                    System.out.println("Book Added !");
                    break;
                case 2:
                    System.out.println("Enter the Name of the book :");
                    bookName = sc.nextLine();
                    LP.issueBook(bookName);
                    System.out.println("Book Issued Succesfully !");
                    break;
                case 3:
                    System.out.println("Enter the Name of the book :");
                    bookName = sc.nextLine();
                    LP.returnBook(bookName);
                    System.out.println("Book Returned Succesfully !");
                    break;
                case 4:
                    System.out.println("Total Available Books :");
                    LP.showAvailableBooks();
                    break;
                case 5:
                    System.out.println("Total Already Issued Books :");
                    LP.showissuedBooks();
                    break;
                case 6:
                    System.out.println("Thanks For Visiting.");
                    Exit = 1;
                    break;
                default:
                    System.out.println("Wrong Input");
                    break;
            }
            if (Exit == 1) {
                break;
            }
        }
    }
}

