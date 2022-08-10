package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.ServiceImp;

@Controller
public class ControllerCars {

    private final ServiceImp serviceImp;

    @Autowired
    public ControllerCars(ServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false, defaultValue = "5") Integer count,
                               Model model) {
        model.addAttribute("cars", serviceImp.getCarsList(count));
        return "cars";
    }
}
