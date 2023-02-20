package com.example.finalproject.API;

import com.example.finalproject.Model.Company;
import com.example.finalproject.Model.Coupon;
import com.example.finalproject.Model.Customer;
import com.example.finalproject.Serveices.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @PostMapping("/Company2/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PutMapping ("/Company2/updateCustomer")
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);

    }

    @DeleteMapping("/Company2/deleteCustomer")
    public void deleteCustomer(@RequestParam int id){
        customerService.deleteCustomer(id);
    }
    @GetMapping("/Company2/getAllCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/Company2/getOneCustomerById")
    public Optional<Customer> getOneCustomer(int id){
        return customerService.getOneCUstomer(id);
    }

}
