package com.hunglp.hibernate_overview;

import com.hunglp.hibernate_overview.entity.many_to_many.Category;
import com.hunglp.hibernate_overview.entity.many_to_many.Product;
import com.hunglp.hibernate_overview.entity.one_to_many.Company;
import com.hunglp.hibernate_overview.entity.one_to_many.Employee;
import com.hunglp.hibernate_overview.entity.one_to_one.Address;
import com.hunglp.hibernate_overview.entity.one_to_one.User;
import com.hunglp.hibernate_overview.entity.one_to_one_join_column.Staff;
import com.hunglp.hibernate_overview.entity.one_to_one_join_column.WorkStation;
import com.hunglp.hibernate_overview.entity.one_to_one_share_primary_key.*;
import com.hunglp.hibernate_overview.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class HibernateOverviewApplicationTests {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    void contextLoads() {
    }

    // ----------------------------------------------- ONE TO ONE --------------------------------------------
    @Test
    public void  createUserWithAddress(){

        User user = new User("Le Phi Hung");
        Address address = new Address("Ha Noi", "Nam Tu Liem");
        user.setAddress(address);
        userRepository.save(user);

    }

    //---------------------------- ONE TO ONE join columns  ----------------------------------------------

    @Test
    public void createStaffWithWorkstation(){
        Staff staff_1 = new Staff("Le Van A");
        WorkStation d6_rikkei = new WorkStation("d6", "3", staff_1);
        staff_1.setWorkStation(d6_rikkei);

        Staff staff_2 = new Staff("Le Viet Dung");
        WorkStation d11_cmc = new WorkStation("d5","6", staff_2);
        staff_2.setWorkStation(d11_cmc);

        staffRepository.saveAll(List.of(staff_1, staff_2));
    }

    // ONE TO ONE SHARE PRIMARY KEY
    @Test
    public void createDeveloperWithAccountGit(){

        AccountGit accountGit = new AccountGit("123456789");

        Developer developer = new Developer("Hung","Le");
        developer.setAccount(accountGit);

        developerRepository.save(developer);
    }

    // ---------------------------------   ONE TO MANY -----------------------------------------------

    @Test
    public void createCompanyWithEmployee(){
        Company company = new Company("CMC", "Duy Tan Cau giay", new ArrayList<>());

        Employee emp_1 = new Employee("Hung", company);
        Employee emp_2 = new Employee("Dung", company);

        company.getEmployeeList().add(emp_1);
        company.getEmployeeList().add(emp_2);

        companyRepository.save(company);
    }


    // --------------------------------------------- MANY TO MANY -------------------------------------
    @Test
    public void crateCategoryWithProduct(){
          //  category can have multiple product

//        Category category_1 = new Category("Electronic Device");
//        Category category_2 = new Category("Clothes");
//
//        Product product_1 = new Product("SamSung Smart TV");
//        Product product_2 = new Product("Iphone 12 XS max");
//        Product product_3 = new Product("T-shirt");
//        Product product_4 = new Product("Short");
//
//        category_1.setProducts(List.of(product_1, product_2));
//        category_2.setProducts(List.of(product_3,product_4));

//        categoryRepository.saveAll(List.of(category_1, category_2));


          // Product can have multiple
        Category category_5 = new Category("Houseware");
        Category category_6 = new Category("Decorations");

        Product clock_1 = new Product("Timex 1984 quarts");

        clock_1.setCategories(List.of(category_5, category_6));

        productRepository.save(clock_1);

    }


}
