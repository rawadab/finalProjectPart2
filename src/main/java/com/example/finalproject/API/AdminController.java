package com.example.finalproject.API;

import com.example.finalproject.Model.Company;
import com.example.finalproject.Serveices.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/Company2/addCompany")
    public Company addCompany(@RequestBody Company company) {
        return companyService.addCompany(company);
    }
    @PutMapping ("/Company2/updateCompany")
    public void updateCompany(@RequestBody Company company){
         companyService.updateCompany(company);
    }
    @DeleteMapping("/Company2/deleteCompany")
    public void deleteCompany(@RequestParam int id){
        companyService.deleteCompany(id);
    }

    @GetMapping("/Company2/getAllCompanies")
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @GetMapping("/Company2/getOneCompanyById")
    public Optional<Company> getOneCompany(int id){
        return companyService.getOneCompanyById(id);
    }


}
