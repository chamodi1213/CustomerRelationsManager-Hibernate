/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DataBaseManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chamodi
 */
public class CustomerService {
    
    public ArrayList getAllCustomers(){
        DataBaseManager db = new DataBaseManager();
        System.out.println("customerService");
        return db.getAllCustomers();
    }
    
    public void saveCustomer(String fname, String lname, String email){
        DataBaseManager db = new DataBaseManager();
        db.saveCustomer(fname, lname, email);
    }
    
      public void updateCustomer(int id, String fname, String lname, String email){
        DataBaseManager db = new DataBaseManager();
        db.updateCustomer(id, fname, lname, email);
    }
      
    public void deleteCustomer(int id){
     DataBaseManager db = new DataBaseManager();
     db.deleteCustomer(id);
    }
}
