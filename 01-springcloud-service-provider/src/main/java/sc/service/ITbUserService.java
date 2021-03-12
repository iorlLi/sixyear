package sc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sc.mapper.TbUserMapper;
import sc.model.TbUser;

@Service
public class ITbUserService {
    @Autowired
    TbUserMapper tbUserMapper;

    public TbUser get(Long id){
        return tbUserMapper.get(id);
    }
}
