package hellospring.controller;

import hellospring.business.UserBusiness;
import hellospring.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserBusiness userBusiness;

    @GetMapping("/get")
    public ResponseEntity<UserInfo> getUserInfo(){
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(userBusiness.getUserInfo());
    }

    @PostMapping("/post")
    public ResponseEntity<String> getStringPostMan(@RequestBody String data){
        System.out.println(data);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.TEXT_PLAIN)
                .body(data);
    }

    @PutMapping("/put")
    public ResponseEntity<Void> saveData(@RequestBody String name){
        userBusiness.updateNameInfo(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteData(@RequestBody String id){
        userBusiness.deleteInfoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
