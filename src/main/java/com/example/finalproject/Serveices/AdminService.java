package com.example.finalproject.Serveices;

//import com.example.finalproject.DAL.CompanyDBDAO;

import com.example.finalproject.DAO.CompanyDAO;
import com.example.finalproject.Model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
//    private  List<Company> companiesDB = new ArrayList<>();
    @Autowired
     CompanyDAO companyDAO;


    public Company addCompany(Company company) {

        if (companyDAO.findByEmailOrName(company.getEmail(), company.getName()) == null)

            return companyDAO.save(company);

        return null;

    }

    public void updateCompany(Company company){
            Company com =  companyDAO.findById(company.getId()).orElse(null);
            if (com != null){
                    com.setEmail(company.getEmail());
                    com.setPassword(company.getPassword());
                System.out.println(com);

            }
            companyDAO.save(com);
    }

    public void deleteCompany(int id){
        Company com = companyDAO.findById(id).orElse(null);
        if(com!=null){
            companyDAO.deleteById(id);

        }

    }

    public List<Company> getAllCompanies(){
        return companyDAO.findAll();
    }

    public Optional<Company> getOneCompanyById(int id){
       return companyDAO.getOneCompanyById(id);
    }
}
