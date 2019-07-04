package top.daoyang.contentcenter.domain.content;

import javax.persistence.*;

@Table(name = "mid_user_share")
public class MidUserShare {
    /**
     * id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * share.id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * share.id
     */
    @Column(name = "share_id")
    private Integer shareId;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取share.id
     *
     * @return user_id - share.id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置share.id
     *
     * @param userId share.id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取share.id
     *
     * @return share_id - share.id
     */
    public Integer getShareId() {
        return shareId;
    }

    /**
     * 设置share.id
     *
     * @param shareId share.id
     */
    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }
}