package io.counterapp.demo.controller;

import io.service.api_client.service.Implementations.WebServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/stat")
public class WebController {
    private final WebServiceImp webServiceImp;

    public WebController(WebServiceImp webServiceImp) {
        this.webServiceImp = webServiceImp;
    }

    @GetMapping(value = "/")
    public ModelAndView getAllCountriesInfo(){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("data", webServiceImp.getAllCountriesInfo());
        return  modelAndView;
    }

    @GetMapping(value = "/by")
    public ModelAndView getCountryInfo(@RequestParam String country){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("country");
        modelAndView.addObject("data", webServiceImp.getCountryInfo(country).getLatest_stat_by_country()[0]);
        return  modelAndView;
    }
}
