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
import tool.MyTool;

/**
 *
 * @author zOzDarKzOz
 */
@Controller
public class SearchCtr {

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<Book> search(
            @RequestParam("vl") String value) {
        if (value != null && !value.equals("")) {
            try {
                String name = MyTool.handleInputString(value);
                ArrayList<Book> listBook = new BookDAO().getListOfBookByName(name);
                if (listBook != null) {
                    return listBook;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
