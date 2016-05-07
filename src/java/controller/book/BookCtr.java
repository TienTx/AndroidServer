/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.book;

import dao.book.BookDAO;
import entity.book.Book;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author zOzDarKzOz
 */
@Controller
@RequestMapping(value = "book/")
public class BookCtr {

    //get list of 20 new books
    @RequestMapping(value = "get20newbooks", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<Book> get20NewBooks() {
        try {
            ArrayList<Book> list20NewBooks = new BookDAO().get20NewBooks();
            if (list20NewBooks != null) {
                return list20NewBooks;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //get book by idBook
    @RequestMapping(value = "getbook", method = RequestMethod.POST)
    public @ResponseBody
    Book getBook(@RequestParam("idBook") String idBook) {
        try {
            int idB = Integer.parseInt(idBook);
            Book book = new BookDAO().getBookById(idB);
            if (book != null) {
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
