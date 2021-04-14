package work.darkforest.acowzon.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private String userId;  // 用户id
    private String userRealname;    // 用户真实姓名
    private String userNickname;    // 用户昵称
    private String userImage;   // 用户头像的路径
    private String userPhone;   // 用户电话
    private String userEmail;   // 用户邮箱
    private char userSex; // 用户性别 0男 1女
    private Date userBirth; // 用户生日
    private char userType;   // 用户类型，0买家，1卖家
    private String userAddressId;   // 用户地址id
    private Date createTime;    // 用户创建时间
    private Date updateTime;    // 用户修改时间

    public User(String userId, String username){
        this.userId = userId;
        this.userNickname = username;
        createTime = new Date();
        updateTime = new Date();
    }

    public User(String userId,String userRealname, String userNickname, String userImage,
                String phone, String userEmail, char sex, Date userBirth, char userType) {
        this.userId = userId;
        this.userRealname = userRealname;
        this.userNickname = userNickname;
        this.userImage = userImage;
        this.userPhone = phone;
        this.userEmail = userEmail;
        this.userSex = sex;
        this.userBirth = userBirth;
        this.userType = userType;
        this.userAddressId = "";
        this.createTime = new Date();
        this.updateTime = new Date();
    }
}
