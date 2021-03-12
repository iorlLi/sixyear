package sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sc.model.City;
import sc.service.ICityService;

@Controller
public class CityController {
    @Autowired
    ICityService iCityService;

    @ResponseBody
    @GetMapping("/city")
    public City select(Integer id) {
        return iCityService.select(id);
    }

    @ResponseBody
    @PostMapping("/city")
    public City insert(City city) {
        iCityService.insert(city);
        return city;
    }
}
