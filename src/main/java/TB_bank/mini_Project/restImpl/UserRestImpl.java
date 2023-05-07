package TB_bank.mini_Project.restImpl;

import TB_bank.mini_Project.constents.Constants;
import TB_bank.mini_Project.rest.UserRest;
import TB_bank.mini_Project.service.UserService;
import TB_bank.mini_Project.utils.BtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class UserRestImpl implements UserRest {

    @Autowired
     UserService userService;

    @Override
    public ResponseEntity<String> signUp(Map<String,String> requestMap){
        try{
            return userService.signup(requestMap);
        }catch (Exception exception)
        {
            exception.printStackTrace();
        }
    return BtUtils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
