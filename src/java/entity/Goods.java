package entity;

import org.springframework.web.multipart.MultipartFile;

public class Goods {
    private Integer id;
    private String gname;
    private String typename;
    private Integer goodstype_id;
    private MultipartFile logoImage;
    private String gpicture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getGoodstype_id() {
        return goodstype_id;
    }

    public void setGoodstype_id(Integer goodstype_id) {
        this.goodstype_id = goodstype_id;
    }

    public MultipartFile getLogoImage() {
        return logoImage;
    }

    public void setGpicture(String gpicture) {
        this.gpicture = gpicture;
    }
}
