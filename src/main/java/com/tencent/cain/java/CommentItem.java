package com.tencent.cain.java;



/**
 * 单条评论详情
 * Created by skindhu on 16/3/2.
 */
public class CommentItem implements Comparable , IDemandVideoItem{

    // 评论ID
    public String commentId;
    // 评论时间（时间戳,单位：秒）
    public long time;
    // 评论内容
    public String content;
    //点赞数量
    public int likeNum;
    //当前用户是否点过赞
    public boolean isLiked;
    // 是否能被删除
    public boolean deleteAuth;

    public CommentItem(String commentId, long time, String content, int likeNum, boolean isLiked, boolean deleteAuth) {
        this.commentId = commentId;
        this.time = time;
        this.content = content;
        this.likeNum = likeNum;
        this.isLiked = isLiked;
        this.deleteAuth = deleteAuth;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "commentId='" + commentId + '\'' +
                ", time=" + time +
                ", content='" + content + '\'' +
                ", likeNum=" + likeNum +
                ", isLiked=" + isLiked +
                ", deleteAuth=" + deleteAuth +
                '}';
    }

    @Override
    public int compareTo(Object comment) {
        if (comment instanceof CommentItem) {
            CommentItem commentItem = (CommentItem) comment;
            return this.time < commentItem.time ? 1 : -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CommentItem)){
            return false;
        }
        CommentItem other = (CommentItem) obj;
        return this.commentId.equals(other.commentId);
    }

    @Override
    public int hashCode() {
        // 始终返回一个固定的值，忽略hashCode的影响
        // 仅仅通过commentId来判断两条弹幕是否相同
        return 1;
    }
}
