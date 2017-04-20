package in.jsroyal.apiconsume.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jsroyal on 12/4/17.
 */

public class Item {


    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("html_url")
    @Expose
    private String htmlUrl;


    public Item(String login, String avatarUrl, String htmlUrl){
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
    }


    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getAvatarUrl(){
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl){
        this.avatarUrl = avatarUrl;
    }

    public String getHtmlUrl(){
        return htmlUrl;
    }

    public void setHtmlUrl(String htmlUrl){
        this.htmlUrl = htmlUrl;
    }
}
