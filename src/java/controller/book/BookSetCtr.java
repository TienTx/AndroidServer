/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.book;

import dao.book.BookDAO;
import dao.book.BookSetDAO;
import entity.book.Book;
import entity.book.BookSet;
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
@RequestMapping(value = "bookset")
public class BookSetCtr {

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<Book> bookByBookSet(@RequestParam("idBS") String idBS) {
        if (idBS != null) {
            try {
                int id = Integer.parseInt(idBS);
                if (id >= 0) {
                    ArrayList<Book> listBookByBookSet = new BookDAO().getListOfBookByIdBookSet(id);
                    if (listBookByBookSet != null) {
                        return listBookByBookSet;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<BookSet> getAllBookSet() {
        try {
            ArrayList<BookSet> listBookSet = new BookSetDAO().getAll();
            if (listBookSet != null) {
                return listBookSet;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
