package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AccountEntity;
import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.entities.ProductEntity;
import com.mycompany.spring_mvc_project_final.enums.UserStatus;
import com.mycompany.spring_mvc_project_final.repository.AccountRepository;
import com.mycompany.spring_mvc_project_final.repository.AuctionRepository;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/seller")
public class SellerController {
  @Autowired
  ProductRepository productRepository;
  @Autowired
  AuctionRepository auctionRepository;
  @Autowired
  AccountRepository accountRepository;
  @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
  public String viewSeller(Model model, HttpServletRequest request) {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    String username = principal.toString();
    if (principal instanceof UserDetails) {
      username = ((UserDetails) principal).getUsername();
    }
    HttpSession session=request.getSession();
    session.setAttribute("username",username);
    List<ProductEntity> products=(List<ProductEntity>)productRepository.findAll();
    model.addAttribute("products",products);
    return "seller/home";
  }
  @RequestMapping(value = "/add",method = RequestMethod.GET)
  public String addProduct(Model model){
    model.addAttribute("product",new ProductEntity());
    model.addAttribute("msg","Thêm vật phẩm");
    model.addAttribute("action","add");
    return "seller/product";
  }
  @RequestMapping(value = "/add",method = RequestMethod.POST)
  public String saveProduct(ProductEntity product){
    productRepository.save(product);
    return "redirect:/";
  }
  @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
  public String editProduct(Model model,@PathVariable long id){
    model.addAttribute("product",productRepository.findById(id));
    model.addAttribute("msg","Sửa vật phẩm");
    model.addAttribute("type","update");
    model.addAttribute("action","update");
    return "seller/product";
  }
  @RequestMapping(value = "/update/update",method = RequestMethod.POST)
  public String updateProduct(@ModelAttribute ProductEntity product){
    productRepository.save(product);
    return "redirect:/";
  }
  @RequestMapping(value = "/delete/{product_id}",method = RequestMethod.GET)
  public String deleteProduct(@PathVariable long id){
    productRepository.deleteById(id);
    return "redirect:/";
  }
  @RequestMapping(value = "/auction/{id}",method = RequestMethod.GET)
  public String addAuction(Model model,@PathVariable long id){
    ProductEntity pr = productRepository.findById(id).orElse(new ProductEntity());
    model.addAttribute("product", pr);
    AuctionEntity auction=new AuctionEntity();
    model.addAttribute("auction",auction);
    model.addAttribute("msg","Vật phẩm đấu giá");
    return "seller/auction";
  }
  @RequestMapping(value = "/auction/auction1",method = RequestMethod.POST)
  public String saveAuction(AuctionEntity auction, @RequestParam long id1,HttpServletRequest request){
    HttpSession session=request.getSession();
    String username=(String) session.getAttribute("username");
    AccountEntity ac =accountRepository.findByEmail(username);
    auction.setAccount(ac);
    ProductEntity pro = productRepository.findById(id1).orElse(new ProductEntity());
    auction.setProduct(pro);
    auctionRepository.save(auction);
    return "redirect:/";
  }

}
