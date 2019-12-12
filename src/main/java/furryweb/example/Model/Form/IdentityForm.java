package furryweb.example.Model.Form;


import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 */
public class IdentityForm {
    @NotEmpty(message = "图片不能为空")
    private String picturesName;
    private String explicate;

    public String getPicturesName() {
        return picturesName;
    }

    public void setPicturesName(String picturesName) {
        this.picturesName = picturesName;
    }

    public String getExplicate() {
        return explicate;
    }

    public void setExplicate(String explicate) {
        this.explicate = explicate;
    }
}