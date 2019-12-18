package com.devicedetection.api;

import com.devicedetection.dao.GeraetesignaturRepository;
import com.devicedetection.model.Geraetesignatur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;


@Controller // This means that this class is a Controller
@RequestMapping(path="/geraetesignatur") // This means URL's start with /demo (after Application path)
public class GeraetesignaturController {
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
  private GeraetesignaturRepository geraetesignaturRepository;

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewGeraetesignatur (@RequestParam String parameter) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    Geraetesignatur n = new Geraetesignatur();
    n.setParameter(parameter);
    geraetesignaturRepository.save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<Geraetesignatur> getAllGeraete() {
    // This returns a JSON or XML with the users
    return geraetesignaturRepository.findAll();
  }
}