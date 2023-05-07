package TB_bank.mini_Project.serviceImpl;

import TB_bank.mini_Project.POJO.User1;
import TB_bank.mini_Project.constents.Constants;
import TB_bank.mini_Project.dao.UserDao;
import TB_bank.mini_Project.service.UserService;
import TB_bank.mini_Project.utils.BtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;
@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public ResponseEntity<String> signup(Map<String,String> requestMap){
        log.info("Inside signup {}",requestMap);

        try {
            if(this.validateSignUpMap(requestMap)){


                User1 user = (User1) userDao.findByEmailId(requestMap.get("email"));
                if(Objects.isNull(user)){
                    userDao.save(getUserFromMap(requestMap));
                    return BtUtils.getResponseEntity("Successfully Registered", HttpStatus.OK);
                } else {
                    return BtUtils.getResponseEntity(Constants.EMAIL_EXISTS, HttpStatus.BAD_REQUEST);
                }

            } else {
                return BtUtils.getResponseEntity(Constants.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }
        return BtUtils.getResponseEntity(Constants.SOMETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private boolean validateSignUpMap(Map<String,String> requestMap){
        if(requestMap.containsKey("name")  && requestMap.containsKey("email") && requestMap.containsKey("mobile"))
        {
            return true;
        }else
            return false;
    }

 private User1 getUserFromMap(Map<String,String> requestMap){
        User1 user = new User1();
        user.setName(requestMap.get("name"));
        user.setSurname(requestMap.get("surname"));
        user.setPassword(requestMap.get("password"));
        user.setEmail(requestMap.get("email"));
     user.setMobile(requestMap.get("mobile"));
     user.setDateOfBirth(requestMap.get("date_of_birth"));
     user.setStatus("false");
     user.setRole("user");
     return user;
        



 }
    }

