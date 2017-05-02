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
    @SerializedName("followers_url")
    @Expose
    private String followersUrl;
    @SerializedName("repos_url")
    @Expose
    private String reposUrl;


    public Item(String login, String avatarUrl, String htmlUrl, String followersUrl, String reposUrl){
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.htmlUrl = htmlUrl;
        this.followersUrl = followersUrl;
        this.reposUrl = reposUrl;
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

    public String getFollowers(){
      return followersUrl;
    }
    public String getRepos(){
      return reposUrl;
    }

}
