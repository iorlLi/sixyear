package sc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sc.mapper.CityMapper;
import sc.model.City;

@Service
public class ICityService {
    @Autowired
    CityMapper cityMapper;

    public City select(Integer id){
        return cityMapper.selectById(id);
    }

    public void insert(City city){
        cityMapper.insert(city);
    }

}
