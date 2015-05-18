/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.addressbookwithstreams;

import com.swcguild.addressbookwithstreams.controller.AddressBookController;
import java.io.IOException;

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) throws IOException {
        AddressBookController control = new AddressBookController();
        control.run();
    }
 
}
