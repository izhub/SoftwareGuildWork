/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbook;

import com.swcguild.addressbook.dao.AddressBookDao;
import com.swcguild.addressbook.dto.Address;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author apprentice
 */
@Controller
public class HomeControllerNoAjax {
    
       //reference to dao interface
    private AddressBookDao dao;

    // annotation driven constructor
    @Inject
    public HomeControllerNoAjax(AddressBookDao dao) {
        this.dao = dao;
    }
    
     //NO AJAX CODING.........
    
    //endpoint returns name of view : displayAddressBook.jsp
    @RequestMapping(value = "/displayAddressBook", method = RequestMethod.GET)
    public String displayAddressBookNoAjax(Model model) {

        //get list of all addresses
        List<Address> aList = dao.getAllAddress();
        //put in Model to pass to view
        model.addAttribute("aList", aList);
        //return logica view name
        return "displayAddressBook";
    }

    //endpoint returns newAddressForm; takes no parameters

    @RequestMapping(value = "/addAddressForm", method = RequestMethod.GET)
    public String addAddressForm(Model model) {

        //model added to tag field to dto for validation check
        model.addAttribute("address", new Address());
        return "addAddressForm";
    } // now go create newAddressForm.jsp for this

    //endpoint gets submitted form from HttpServletRequest, creates new
    // dto object, sets fields on new object, add object to DAO and 
    // redirects to displayAddressBookDao
    @RequestMapping(value = "/addnew", method = RequestMethod.POST)
    public String addAddressForm(@Valid @ModelAttribute("address") Address address,
            BindingResult result) {

        if (result.hasErrors()) {
            return "addAddressForm";
        }

        dao.addAddress(address);

        return "redirect:displayAddressBook";
    }

    @RequestMapping(value = "/deleteAddress", method = RequestMethod.GET)
    public String deleteAddress(HttpServletRequest req) {

        int id = Integer.parseInt(req.getParameter("id"));
        dao.removeAddress(id);
        return "redirect:displayAddressBook";
    }

    //create endpoint that will cause Edit form to be displayed
    // same pattern as above
    @RequestMapping(value = "/editAddress", method = RequestMethod.GET)
    public String editAddressForm(HttpServletRequest req, Model model) {

        int id = Integer.parseInt(req.getParameter("id"));

        Address address = dao.getAddressById(id);
        model.addAttribute("address", address);
        return "editAddressForm";
    }

//    public String editAddress(HttpServletRequest req, Model model){
//        
//        int id = Integer.parseInt(req.getParameter("id"));
//        Address address = dao.getAddressById(id);
//        model.addAttribute("address", address);
//        return "editAddressForm";
//    }
    
    @RequestMapping(value = "/editAddressForm", method = RequestMethod.POST)
    public String editAddress(@Valid @ModelAttribute("address") Address address,
            BindingResult result) {

        if (result.hasErrors()) {
            return "editAddressForm";
        }
        dao.updateAddress(address);
        return "redirect:displayAddressBook";
    }
}
