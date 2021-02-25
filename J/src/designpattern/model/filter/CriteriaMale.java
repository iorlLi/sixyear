package designpattern.model.filter;

import java.util.List;
import java.util.stream.Collectors;

public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> collect = persons.stream().filter(p -> "MALE".equalsIgnoreCase(p.getGender())).collect(Collectors.toList());
        return collect;
    }
}
