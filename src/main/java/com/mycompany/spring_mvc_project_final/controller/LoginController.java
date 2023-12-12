/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring_mvc_project_final.controller;


import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.entities.BidEntity;
import com.mycompany.spring_mvc_project_final.entities.CreditEntity;
import com.mycompany.spring_mvc_project_final.entities.ProductEntity;
import com.mycompany.spring_mvc_project_final.enums.Role;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.repository.AuctionRepository;
import com.mycompany.spring_mvc_project_final.repository.BidRepository;
import com.mycompany.spring_mvc_project_final.repository.CreditRepository;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    AuctionRepository auctionRepository;
    @Autowired
    BidRepository bidRepository;
    @Autowired
    CreditRepository creditRepository;

    @RequestMapping("/login")
    public String loginPage(Model model, @RequestParam(value = "error", required = false) boolean error) {
        if (error) {
            model.addAttribute("message", "Login Fail!!!");
        }
        return "login";
    }
    @RequestMapping("/admin/home")
    public String viewHome(Model model,HttpSession session, HttpServletRequest request) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        }
        session.setAttribute("username",username);
        model.addAttribute("message", "Hello Admin: " + username);
        return "admin/home";
    }

    @RequestMapping("/user/home")
    public String viewHome(Model model, HttpSession session) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            session.setAttribute("username", username);

        }

        return "student/index";
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String welcomePage(Model model,HttpSession session) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.toString();

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
            session.setAttribute("username", username);

        }
        String name=(String) session.getAttribute("username");
        List<ProductEntity> productEntityList = productRepository.findByView1("2");
        Date targetDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(targetDate);
        c.add(Calendar.DATE, 1);
        targetDate = c.getTime();
        model.addAttribute("targetDate",targetDate.getTime());
        model.addAttribute("name",name);
        model.addAttribute("productEntityList",productEntityList);
        return "home";
    }
    @RequestMapping(value = {"/account"})
    public String account(Model model,HttpServletRequest request) {
        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("username");
        AccountEntity ac =accountRepository.findByEmail(username);
        long account_id=ac.getId();
        CreditEntity credit=creditRepository.findByAccount_id(account_id);
        model.addAttribute("credit",credit);
        return "account";
    }
    @RequestMapping(value = {"/register"})
    public String showRegister(Model model) {
        model.addAttribute("account", new AuctionEntity());
        return "register";
    }
//    @RequestMapping(value = "/register",method = RequestMethod.POST)
//    public String register(@ModelAttribute("account") AccountEntity newAccount, Model model) {
//        if (accountRepository.existsByEmail(newAccount.getEmail())) {
//            model.addAttribute("error", "Email already exists");
//            return "register";
//        } else {
//            UserStatus activeStatus = UserStatus.ACTIVE;
//            newAccount.setStatus(activeStatus);
//            AccountEntity account=accountRepository.save(newAccount);
//            Optional<RoleEntity> roleOptional = roleRepository.findById(Long.valueOf(2));
//            if (roleOptional.isPresent()) {
//                savedAccount.getUserRoles().add(roleOptional.get());
//                accountRepository.save(savedAccount);
//            }
//
//            return "login";
//        }
//    }
}
