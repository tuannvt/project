package com.mycompany.spring_mvc_project_final.controller;

import com.mycompany.spring_mvc_project_final.entities.AuctionEntity;
import com.mycompany.spring_mvc_project_final.entities.ProductEntity;
import com.mycompany.spring_mvc_project_final.repository.AuctionRepository;
import com.mycompany.spring_mvc_project_final.repository.ProductRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/seller")
public class SellerController {
  @Autowired
  ProductRepository productRepository;
  @Autowired
  AuctionRepository auctionRepository;
  @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
  public String viewSeller(Model model) {
    List<ProductEntity> products=(List<ProductEntity>)productRepository.findAll();
    model.addAttribute("products",products);
    return "home";
  }

}
