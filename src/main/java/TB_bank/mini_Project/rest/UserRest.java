package TB_bank.mini_Project.rest;


import TB_bank.mini_Project.restImpl.UserRestImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/user")
public interface UserRest {
@PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Map<String,String> requestMap);


}
