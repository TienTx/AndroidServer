/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.person;

import dao.order.CardPointDAO;
import dao.person.PersonDAOAbstractFactory;
import dao.person.PersonDAOFactoryProducer;
import entity.order.CardPoint;
import entity.person.PersonAbstractFactory;
import entity.person.PersonFactoryProducer;
import entity.person.address.Address;
import entity.person.customer.Customer;
import entity.person.fullname.FullName;
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
@RequestMapping(value = "user/")
public class UserCtr {

    //signup: success: return string like: cardcode#cardpoint, fail: return string "fail"
    @RequestMapping(value = "signup", method = RequestMethod.POST)
    public @ResponseBody
    String signup(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("rePassword") String rePassword
    ) {
        String res = "fail";
        if (name != null && name.length() >= 6 && name.length() <= 30
                && email != null && email.length() <= 30
                && password != null && password.length() >= 6 && password.length() <= 30
                && rePassword.equals(password)) {

            Address add = new Address("x", "x", "x", "x", "x", "x", "x");
            FullName fn = new FullName("x", "x", "x");
            PersonAbstractFactory customerFactory = PersonFactoryProducer.getFactory("customer");
            Customer cus = customerFactory.getCustomer("customerMember");
            cus.setAddress(add);
            cus.setEmail(email);
            cus.setFullName(fn);
            cus.setPhoneNum("x");
            cus.setCustomerMemberUsername(email);
            cus.setCustomerMemberPassword(password);
            PersonDAOAbstractFactory customerDAOFactory = PersonDAOFactoryProducer.getDAOFactory("customerDAO");
            try {
                int idMember = customerDAOFactory.getCustomerDAO("customerMemberDAO").addCustomerMember(cus);
                if (idMember != -1) {
                    CardPoint cusCardPoint = new CardPointDAO().newCardPoint(idMember, 0);
                    res = cusCardPoint.getCardCode() + "#" + cusCardPoint.getPoints();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return res;
    }
}
