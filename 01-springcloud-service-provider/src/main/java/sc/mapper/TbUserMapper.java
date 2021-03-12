package sc.mapper;

import org.apache.ibatis.annotations.Mapper;
import sc.model.TbUser;
@Mapper
public interface TbUserMapper {
    TbUser get(Long id);
}
