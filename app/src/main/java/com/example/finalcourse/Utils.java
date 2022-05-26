package com.example.finalcourse;

import com.bumptech.glide.util.Util;

import java.util.ArrayList;

//in a real world application this file is the Database class
public class Utils {


    private static ArrayList<Book> allBooks;
    private static ArrayList <Book> alreadyReadBooks;
    private static ArrayList <Book> wantToReadBooks;
    private static ArrayList <Book> currentlyReadBooks;
    private static ArrayList <Book> favoriteBooks;


    private static  Utils instance ;


    private Utils()  {
        if (null == allBooks) ;
        {

            allBooks = new ArrayList<>();
            initData();
        }

        if (null == alreadyReadBooks) ;
        {

            alreadyReadBooks = new ArrayList<>();
        }

        if (null == wantToReadBooks) ;
        {

            wantToReadBooks = new ArrayList<>();
        }

        if (null == currentlyReadBooks) ;
        {

            currentlyReadBooks = new ArrayList<>();
        }

        if (null == favoriteBooks) ;
        {

            favoriteBooks = new ArrayList<>();
        }
    }

    private void initData() {
        allBooks.add(new Book(1,"Mousem Sed","Ahmed Mourad","https://m.media-amazon.com/images/I/51iELn2EQ0L._AC_SY580_.jpg",150,
                "Ahmed is go go go go ","a book for go go go go go go go go go go go go go go "));
        allBooks.add(new Book(2,"Chocalata","Omar Taher","https://m.media-amazon.com/images/I/41Jdx90oXEL._AC_SY580_.jpg",123,
                "Omar Taher issss","gowa gowa bara bara boga boga"));

        //TODO add initial data
    }

    public static Utils getInstance() {
            if (null != instance){
                return  instance;
            }else {
                instance= new Utils();
                return instance;
            }

    }


    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getAlreadyReadBooks() {
        return alreadyReadBooks;
    }

    public static ArrayList<Book> getWantToReadBooks() {
        return wantToReadBooks;
    }

    public static ArrayList<Book> getCurrentlyReadBooks() {
        return currentlyReadBooks;
    }

    public static ArrayList<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public Book getBookByID(int id ){
        for (Book b:allBooks){
            if (b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public boolean addToAlreadyRead (Book book ){

        return alreadyReadBooks.add(book);
    }

    public boolean addToWantToRead (Book book){
        return wantToReadBooks.add(book);
    }

    public boolean addToCurrentlyReading(Book book){
        return currentlyReadBooks.add(book);
    }
    public boolean addToFavoriteBooks(Book book){
        return favoriteBooks.add(book);
    }
}
