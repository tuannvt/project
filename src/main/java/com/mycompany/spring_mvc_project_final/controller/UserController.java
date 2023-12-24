package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.entities.ProductEntity;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.repository.AuctionRepository;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
  @Autowired
  ProductRepository productRepository;
  @Autowired
  AuctionRepository auctionRepository;
  @Autowired
  AccountRepository accountRepository;

  @RequestMapping(value = "/auction/{id}",method = RequestMethod.GET)
  public String addAuction(Model model,@PathVariable long id){
    ProductEntity pr = productRepository.findById(id).orElse(new ProductEntity());
    model.addAttribute("product", pr);
    AuctionEntity auction=auctionRepository.findByViewPrice(id);
    model.addAttribute("auction",auction);
    return "user/auction";
  }
  @RequestMapping(value = "/auction/auction1",method = RequestMethod.POST)
  public String saveAuction(AuctionEntity auction, @RequestParam long id1,@RequestParam double startPrice,HttpServletRequest request){
    HttpSession session=request.getSession();
    String username=(String) session.getAttribute("username");
    if (username != null){
      AccountEntity ac =accountRepository.findByEmail(username);
      auction.setAccount(ac);
      ProductEntity pro = productRepository.findById(id1).orElse(new ProductEntity());
      auction.setProduct(pro);
      auction.setStatus(UserStatus.PENDING);
      auction.setStartPrice(startPrice);
      auctionRepository.save(auction);
    }
    else {

    }
    return "redirect:/";
  }
}
