package com.company;

import java.util.Scanner;

interface Library{
    void addBook(String []b,String a);
    void issueBook(String []b,String[]c, String a);
    void returnBook(String []b,String[]c, String a);
    void showAvailableBooks(String []b);
}
public class LibraryProject implements Library{
    // You have to implement a library using Java Class "Library"
    // Methods: addBook, issueBook, returnBook, showAvailableBooks
    // Properties: Array to store the available books,
    // Array to store the issued books
    @Override
    public void addBook(String[] bookList,String bookName){
        for (int i=0;i<bookList.length;i++){
            if (bookList[i]==null){
                bookList[i]=bookName;
                break;
            }
        }
    }

    @Override
    public void showAvailableBooks(String[] bookList) {
        for (String i:bookList){
            if(i!=null) {
                System.out.println(i);
            }
        }
    }

    @Override
    public void issueBook(String[] booklist, String[] issuebooklist, String bookName) {
        int addtoissue = 0;
        for (int i=0;i<booklist.length;i++){
            if (booklist[i]!=null){
                if (booklist[i].equals(bookName)){
                    booklist[i]=null;
                    addtoissue = 1;
                    break;
                }
            }
        }
        if (addtoissue==1){
            for (int i=0;i<booklist.length;i++){
                if (issuebooklist[i]==null){
                    issuebooklist[i]=bookName;
                    break;
                }
            }
        }
    }

    @Override
    public void returnBook(String[] booklist, String[] issuebooklist, String bookName) {
        int removefromissue = 0;
        for (int i=0;i<issuebooklist.length;i++){
            if (issuebooklist[i]!=null){
                if (issuebooklist[i].equals(bookName)){
                    issuebooklist[i]=null;
                    removefromissue = 1;
                    break;
                }
            }
        }
        if (removefromissue==1){
            for (int i=0;i<booklist.length;i++){
                if (booklist[i]==null){
                    booklist[i]=bookName;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] bookList = new String[100];
        String[] issuedBookList = new String[100];

        LibraryProject LP = new LibraryProject();
//        LP.addBook(bookList,"The Reality of Money");
//        LP.addBook(bookList,"Coding Master v4");
//        LP.addBook(bookList,"Pirates of Carribean");
//        System.out.println("\nCurrently Available Books :");
//        LP.showAvailableBooks(bookList);
//        System.out.println("\nIssuing the books ..");
//        LP.issueBook(bookList,issuedBookList,"The Reality of Money");
//        System.out.println("\nCurrent Books :");
//        LP.showAvailableBooks(bookList);
//        System.out.println("\nFetching the returned books ..");
//        LP.returnBook(bookList,issuedBookList,"The Reality of Money");
//        System.out.println("\nCurrent Books :");
//        LP.showAvailableBooks(bookList);

        while(true){
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
            switch (x){
                case 1:
                    System.out.println("Enter the Name of the book :");
                    bookName = sc.nextLine();
                    LP.addBook(bookList,bookName);
                    System.out.println("Book Added !");
                    break;
                case 2:
                    System.out.println("Enter the Name of the book :");
                    bookName = sc.nextLine();
                    LP.issueBook(bookList,issuedBookList,bookName);
                    System.out.println("Book Issued Succesfully !");
                    break;
                case 3:
                    System.out.println("Enter the Name of the book :");
                    bookName = sc.nextLine();
                    LP.returnBook(bookList,issuedBookList,bookName);
                    System.out.println("Book Returned Succesfully !");
                    break;
                case 4:
                    System.out.println("Total Available Books :");
                    LP.showAvailableBooks(bookList);
                    break;
                case 5:
                    System.out.println("Total Already Issued Books :");
                    LP.showAvailableBooks(issuedBookList);
                    break;
                case 6:
                    System.out.println("Thanks For Visiting.");
                    Exit =1;
                    break;
                default:
                    System.out.println("Wrong Input");
                    break;
            }
            if (Exit==1){
                break;
            }
        }
    }
}
