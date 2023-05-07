package TB_bank.mini_Project.utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class BtUtils {

    public static ResponseEntity<String> getResponseEntity(String response, HttpStatus httpStatus) {
        return new ResponseEntity<String>("{\"message\":\"" + response + "\"}", httpStatus);
    }
}