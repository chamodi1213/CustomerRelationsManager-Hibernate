/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import mysql.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import mysql.entity.Customer;
import org.hibernate.Transaction;

/**
 *
 * @author Chamodi
 */
public class DataBaseManager {
       
    public ArrayList getAllCustomers(){
        Session session = null;
        Transaction transaction = null;
        
        String hql = "from Customer";
        System.out.println(hql);
        ArrayList resultList = new ArrayList();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            Query q = session.createQuery(hql);
            resultList = (ArrayList) q.list();
            
            transaction.commit();
        } catch (Exception he) {
            if(transaction != null){
                transaction.rollback();
            }
        } finally{
            if(session != null){
                session.close();
            }
        }
        return resultList;
    }
    
     public void saveCustomer(String fname, String lname, String email) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Customer customer = new Customer();
            customer.setFirstName(fname);
            customer.setLastName(lname);
            customer.setEmail(email);

            session.save(customer);
            transaction.commit();
            System.err.println("Saved");
        } catch (Exception he) {
            if(transaction != null){
                transaction.rollback();
            }
        } finally{
            if(session != null){
                session.close();
            }
        }
     }
     
     public void updateCustomer(int id,String fname, String lname, String email){
        Session session = null;
        Transaction transaction = null;
        
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Customer customer = (Customer)session.load(Customer.class, id);
            customer.setFirstName(fname);
            customer.setLastName(lname);
            customer.setEmail(email);

            session.update(customer);
            transaction.commit();

            System.err.println("Updated");
        } catch (Exception he) {
            if(transaction != null){
                transaction.rollback();
            }
        } finally{
            if(session != null){
                session.close();
            }
        }
     }
     
     public void deleteCustomer(int id){
        Session session = null;
        Transaction transaction = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Customer customer = (Customer)session.load(Customer.class, id);
            session.delete(customer);

            transaction.commit();

            System.err.println("Deleted");
        } catch (Exception he) {
            if(transaction != null){
                transaction.rollback();
            }
        } finally{
            if(session != null){
                session.close();
            }
        }
     }
     
       
}
