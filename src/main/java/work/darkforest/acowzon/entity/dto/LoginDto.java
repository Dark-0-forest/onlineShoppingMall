package work.darkforest.acowzon.entity.dto;

import lombok.Data;
import work.darkforest.acowzon.entity.po.Login;

@Data
public class LoginDto {
    private String username;
    private String password;


    public LoginDto() {
    }

    public LoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginDto(Login login) {
        this.username = login.getUserName();
        this.password = login.getUserPwd();
    }
}
