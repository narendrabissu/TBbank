package TB_bank.mini_Project.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UserService {
    ResponseEntity<String> signup(Map<String, String> requestMap);

    private boolean validateSignUpMap(Map<String, String> requestMap) {
        return false;
    }
}
