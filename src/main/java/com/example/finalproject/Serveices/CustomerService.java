package com.example.finalproject.Serveices;

import com.example.finalproject.DAO.CustomerDAO;

import com.example.finalproject.Model.Company;
import com.example.finalproject.Model.Coupon;
import com.example.finalproject.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerDAO customerDAO;

    public Customer addCustomer(Customer customer) {

        if (customer.getEmail() != null && customerDAO.findByEmail(customer.getEmail()) == null)


            return customerDAO.save(customer);

        return null;

    }
    public void updateCustomer(Customer customer){
        Customer cus = customerDAO.findById(customer.getId()).orElse(null);
        if (cus != null){
        cus.setEmail(customer.getEmail());
        cus.setPassword(customer.getPassword());
        cus.setFirst_name(customer.getFirst_name());
        cus.setLast_name(cus.getLast_name());
        customerDAO.save(cus);
        }

    }
    public void deleteCustomer(int id) {
        Customer cus = customerDAO.findById(id).orElse(null);
        if (cus != null) {
            customerDAO.deleteById(id);

        }


    }

    public List<Customer> getAllCustomers() {
        return customerDAO.findAll();
    }
    public Optional<Customer> getOneCUstomer(int id){
        return customerDAO.getOneCUstomerById(id);
    }
}