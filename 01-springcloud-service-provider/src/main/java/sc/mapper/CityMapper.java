package sc.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import sc.model.City;

@Mapper
public interface CityMapper {
    @Select("select * from city where id = #{id}")
    public City selectById(Integer id);

    @Insert(" insert into city (id, name) VALUES (#{id}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insert(City city);
}
