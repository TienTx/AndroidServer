/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.book;

import dao.book.BookDAO;
import dao.book.CategoryDAO;
import entity.book.Book;
import entity.book.Category;
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
@RequestMapping(value = "category")
public class CategoryCtr {

    //get list of book by id category
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<Book> bookByCategory(@RequestParam("idCt") String idCt) {
        if (idCt != null) {
            try {
                int id = Integer.parseInt(idCt);
                if (id >= 0) {
                    ArrayList<Book> listBookByCategory = new BookDAO().getListOfBookByIdCategory(id);
                    if (listBookByCategory != null) {
                        return listBookByCategory;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //get all category
    @RequestMapping(value = "/getAll", method = RequestMethod.POST)
    public @ResponseBody
    ArrayList<Category> getAllCategory() {
        try {
            ArrayList<Category> listCategory = new CategoryDAO().getAll();
            if (listCategory != null) {
                return listCategory;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
