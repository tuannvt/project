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
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.repository.AuctionRepository;
import com.mycompany.spring_mvc_project_final.repository.BidRepository;
import com.mycompany.spring_mvc_project_final.repository.CreditRepository;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        List<ProductEntity> productEntityList = productRepository.findByView1("2", UserStatus.ACTIVE.name());
        List<AuctionEntity> auctionEntityList=auctionRepository.findByViewEndTime();
        model.addAttribute("auctionEntityList",auctionEntityList);
        model.addAttribute("productEntityList",productEntityList);
        return "home";
    }
    @RequestMapping(value = {"/user/hethan/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public String hathan(@PathVariable long id,HttpServletRequest request) {
        auctionRepository.updateAuctionById(id);

        ProductEntity product=productRepository.findByView2(id);
        AuctionEntity auction=auctionRepository.findByViewPro(product.getProduct_id());
            BidEntity bid=new BidEntity();
            bid.setAuction(auction);
            bid.setAmount(auction.getStartPrice());
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = now.format(formatter);
            bid.setTimeStamp(formattedDateTime);
            bid.setAccount(auction.getAccount());
            bid.setStatus(UserStatus.ACTIVE);
            bidRepository.save(bid);
        return "";
    }
    @RequestMapping(value = {"/account"})
    public String account(Model model,HttpServletRequest request) {
        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("username");
        AccountEntity ac =accountRepository.findByEmail(username);
        long account_id=ac.getId();
        CreditEntity credit=creditRepository.findByAccount_id(account_id);
        List<BidEntity> bid=bidRepository.findByAccount_id(account_id);
        List<BidEntity> bidList = bid.stream()
            .collect(Collectors.toMap(BidEntity::getAuction, p -> p, (existing, replacement) -> existing))
            .values()
            .stream()
            .collect(Collectors.toList());
        for (BidEntity b:bidList);
        List<BidEntity> bidEntityList=bidRepository.findByAccount1(account_id);
        model.addAttribute("ac",ac);
        model.addAttribute("credit",credit);
        model.addAttribute("bidList",bidList);
        model.addAttribute("bidEntityList",bidEntityList);
        return "account";
    }
    @RequestMapping(value = {"/thanhToan/{id}"},method = RequestMethod.GET)
    public String thanhToan(Model model,HttpServletRequest request,@PathVariable long id) {
        BidEntity bid=bidRepository.findById(id).get();
        HttpSession session=request.getSession();
        String username=(String) session.getAttribute("username");
        AccountEntity ac =accountRepository.findByEmail(username);
        long account_id=ac.getId();
        CreditEntity credit=creditRepository.findByAccount_id(account_id);
        double blance=credit.getBalance()-bid.getAmount();
        if (blance>=0){
            credit.setBalance(blance);
            creditRepository.save(credit);
            bid.setStatus(UserStatus.UNACTIVE);
            bidRepository.save(bid);
        }else {
            model.addAttribute("message","Bạn không đử tiền để thanh toán vui lòng nạp thêm");
        }
        return "redirect:/account";
    }
    @RequestMapping(value = {"/register"})
    public String showRegister(Model model) {
        model.addAttribute("account", new AuctionEntity());
        return "register";
    }
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public String register(@ModelAttribute("account") AccountEntity newAccount, Model model) {
//        if (accountRepository.existsByEmail(newAccount.getEmail())) {
//            model.addAttribute("error", "Email already exists");
//            return "register";
//        } else {
//            UserStatus activeStatus = UserStatus.ACTIVE;
//            newAccount.setStatus(activeStatus);
//
//            String encryptedPassword = bCryptPasswordEncoder.encode(newAccount.getPassword());
//            newAccount.setPassword(encryptedPassword);
//
//            AccountEntity savedAccount = accountRepository.save(newAccount);
//
//            // Creating account_role relationship
//            // Thêm user đã đăng ký vào ROLE_USER
//            if (savedAccount.getUserRoles() == null) {
//                savedAccount.setUserRoles(new HashSet<>());
//            }
//
//            Optional<RoleEntity> roleOptional = roleRepository.findById(Long.valueOf(2));
//            if (roleOptional.isPresent()) {
//                savedAccount.getUserRoles().add(roleOptional.get());
//                accountRepository.save(savedAccount);
//            } else {
//                // Xử lý khi không tìm thấy role
//            }
//
//            return "redirect:/login";
//        }
//    }
}


