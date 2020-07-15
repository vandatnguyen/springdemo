package hellospring.business;

import hellospring.model.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserBusiness {
    private UserInfo info;

    public UserInfo getUserInfo(){
         info = new UserInfo();
        info.setId("123456");
        info.setName("Van Dat Nguyen");
        info.setAge(18);
        return info;
    }

    public void updateNameInfo(String name){
        if (info != null){
            info.setName(name);
        }
    }

    public void deleteInfoById(String id){
        if (info.getId().equals(id)){
            info= null;
        }
    }
}
