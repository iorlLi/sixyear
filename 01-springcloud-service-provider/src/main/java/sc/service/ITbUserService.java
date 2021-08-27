package sc.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sc.mapper.TbUserMapper;
import sc.model.TbUser;

import javax.el.ELContext;
import javax.el.Expression;
import javax.el.MethodExpression;
import javax.el.MethodInfo;

@Slf4j
@Service
public class ITbUserService {
    @Autowired
    TbUserMapper tbUserMapper;
    Logger logger = LoggerFactory.getLogger(ITbUserService.class);

    public TbUser get(Long id) {
        logger.info("get");
        logger.debug("get");

        return tbUserMapper.get(id);
    }
}
