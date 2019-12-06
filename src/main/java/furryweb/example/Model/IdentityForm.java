package furryweb.example.Model;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/12/6.
 */
public class IdentityForm {
    private List<String> picturesName = new ArrayList<>();
    private String explicate;

    public List<String> getPicturesName() {
        return picturesName;
    }

    public void setPicturesName(List<String> picturesName) {
        this.picturesName = picturesName;
    }

    public String getExplicate() {
        return explicate;
    }

    public void setExplicate(String explicate) {
        this.explicate = explicate;
    }
}