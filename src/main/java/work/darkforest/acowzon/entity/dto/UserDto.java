package work.darkforest.acowzon.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import work.darkforest.acowzon.entity.po.User;
import work.darkforest.acowzon.utils.constant.DateFormatConstant;
import work.darkforest.acowzon.utils.constant.GenderConstant;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto implements Serializable{
    private String userId;  // 用户id
    private String userRealname;    // 用户真实姓名
    private String userNickname;    // 用户昵称
    private String userImage;   // 用户头像的路径
    private String userPhone;   // 用户电话
    private String userEmail;   // 用户邮箱
    private char userSex; // 用户性别 0男 1女
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date userBirth; // 用户生日
    private char userType;   // 用户类型，0买家，1卖家
    private String userAddressId;   // 用户地址id

    public UserDto(User user) {
        this.userId = user.getUserId();
        this.userRealname = user.getUserRealname();
        this.userNickname = user.getUserNickname();
        this.userImage = user.getUserImage();
        this.userPhone = user.getUserPhone();
        this.userEmail = user.getUserEmail();
        this.userSex = user.getUserSex();
        this.userBirth = user.getUserBirth();
        this.userType = user.getUserType();
        this.userAddressId = user.getUserAddressId();
    }

    public UserDto(String userId, String userRealname, String userNickname, String userImage, String userPhone,
                   String userEmail, String userSex, String userBirth, char userType, String userAddressId) throws ParseException {
        this.userId = userId;
        this.userRealname = userRealname;
        this.userNickname = userNickname;
        this.userImage = userImage;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        if (userSex.equals("女")){
            this.userSex = GenderConstant.WOMAN;
        } else {
            this.userSex = GenderConstant.MAN;
        }
        this.userBirth = DateFormatConstant.DATE_FORMAT.parse(userBirth);
        this.userType = userType;
        this.userAddressId = userAddressId;
    }

    public static List<UserDto> toUserDto(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(new UserDto(user));
        }
        return userDtos;
    }
}
