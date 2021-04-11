package work.darkforest.acowzon.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment implements Serializable{
    private String commentId; // 评论id
    private String parentId;  // 评论的父id
    private String goodsId; // 评论的商品id
    private String userId; // 用户id
    private String commentText; // 评论内容
    private int commentScore; // 分数
    private Date commentTime; // 评论时间

    public Comment(String parentId, String goodsId, String userId, String commentText, int score) {
        this.commentId = UUID.randomUUID().toString();
        this.parentId = parentId;
        this.goodsId = goodsId;
        this.userId = userId;
        this.commentText = commentText;
        this.commentScore = score;
        this.commentTime = new Date();
    }
}
