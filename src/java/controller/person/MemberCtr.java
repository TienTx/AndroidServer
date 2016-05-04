/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.person;

import dao.person.PersonDAOAbstractFactory;
import dao.person.PersonDAOFactoryProducer;
import entity.person.customer.Customer;
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
@RequestMapping(value = "member/")
public class MemberCtr {

    //login: success: true, fail: false
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    boolean customerMemberLogin(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    ) {
        boolean isSuccess = false;
        if (username != null && username.length() >= 6
                && password != null && password.length() >= 6) {
            username = MyTool.handleInputString(username);
            password = password.trim();
            PersonDAOAbstractFactory customerDAOFactory = PersonDAOFactoryProducer.getDAOFactory("customerDAO");
            try {
                Customer cus = customerDAOFactory.getCustomerDAO("customerMemberDAO").getMemberByUsernameAndPassword(username, password);
                if (cus != null) {
                    isSuccess = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }
}
