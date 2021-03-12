package sc.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class TbUser {
    private Long id;
    private String userName;
    private String passWord;
}
