/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.order;

import dao.order.CardPointDAO;
import entity.order.CardPoint;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author zOzDarKzOz
 */
@Controller
@RequestMapping(value = "cardpoint/")
public class CardPointCtr {

    @RequestMapping(value = "checkcardpoint")
    public @ResponseBody
    CardPoint checkCardPoint(@RequestParam("code") String code) {
        if (code != null && code.trim().matches("([0-9a-zA-Z]){6,6}")) {
            CardPoint cardPoint = new CardPointDAO().getCustomerCardPointByCode(code);
            if (cardPoint != null) {
                if (cardPoint.getCardCode().equals(code.toUpperCase())) {
                    return cardPoint;
                }
            }
        }
        return null;
    }
}
