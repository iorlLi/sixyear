package iorl.beans;

import lombok.Data;
import lombok.ToString;

import javax.annotation.PostConstruct;
import java.io.Serializable;

@Data
@ToString
public class UserAddress implements Serializable {
    @PostConstruct//JSR250
    public void init(){

    }
    private Integer id;
    private String userAddress; //用户地址
    private String userId; //用户id
    private String consignee; //收货人
    private String phoneNum; //电话号码
    private String isDefault; //是否为默认地址    Y-是     N-否

    public UserAddress(Integer id, String userAddress, String userId, String consignee, String phoneNum, String isDefault) {
        this.id = id;
        this.userAddress = userAddress;
        this.userId = userId;
        this.consignee = consignee;
        this.phoneNum = phoneNum;
        this.isDefault = isDefault;
    }
}
