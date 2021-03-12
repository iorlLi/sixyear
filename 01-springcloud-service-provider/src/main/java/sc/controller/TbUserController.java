package sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sc.model.TbUser;
import sc.service.ITbUserService;

@RestController
public class TbUserController {
    @Autowired
    ITbUserService iTbUserService;

    @GetMapping("/tb")
    public TbUser get(@RequestParam("id") Long id){
        return iTbUserService.get(id);
    }

}
