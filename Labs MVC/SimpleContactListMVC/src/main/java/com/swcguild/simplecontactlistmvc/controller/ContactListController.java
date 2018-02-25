/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.simplecontactlistmvc.controller;

import com.swcguild.simplecontactlistmvc.dto.Contact;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller //step 1 : lets spring know about us 
public class ContactListController {
    
    @RequestMapping(value="displayContactList", method=RequestMethod.GET)   // step 3 link name in jsp 
        public String displayContactList(HttpServletRequest req, Model model){ //step 2 methods, forwards to view
            Contact c1 = new Contact();
            c1.setFirstName("Joe");
            c1.setLastName("Smith");
            c1.setEmail("jsmith@smith.com");
            
            Contact c2 = new Contact();
            c2.setFirstName("Bob");
            c2.setLastName("Evans");
            c2.setEmail("bevans@evans.com");
            
            Contact c3 = new Contact();
            c3.setFirstName("Bill");
            c3.setLastName("Gates");
            c3.setEmail("bgates@gates.com");
            
            List<Contact> cList = new ArrayList<>();
            cList.add(c1);
            cList.add(c3);
            cList.add(c2);
            
            model.addAttribute("listOfContacts", cList);
            
        return "displayContactList";    //go create .jsp for this 
    }
}
