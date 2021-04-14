package work.darkforest.acowzon.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import work.darkforest.acowzon.entity.dto.LoginDto;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    private String userId;  // 用户id
    private String userName;    // 登录用户名
    private String userPwd; // 登录密码

    public Login(String userName, String userPwd) {
        this.userId = UUID.randomUUID().toString();
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public Login(LoginDto loginDto) {
        this.userId = UUID.randomUUID().toString();;
        this.userName = loginDto.getUsername();
        this.userPwd = loginDto.getPassword();
    }
}
