package sc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sc.model.City;
import sc.service.ICityService;
import sc.util.RedisUtils;

@Controller
public class CityController {
    Logger logger = LoggerFactory.getLogger(CityController.class);

    @Autowired
    ICityService iCityService;
    @Autowired
    RedisUtils redisUtils;

    @ResponseBody
    @GetMapping("/city")
    public City select(Integer id) {
        return iCityService.select(id);
    }

    @ResponseBody
    @PostMapping("/city")
    public City insert(City city) {
        logger.info("insert ====>>>>>");
        redisUtils.set(city.getName(), city.getName());
        logger.info("insert ====>>>>>222");
        iCityService.insert(city);
       redisUtils.getKeys(city.getName());
        return city;
    }
}
