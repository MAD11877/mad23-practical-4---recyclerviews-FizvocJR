package sg.edu.np.mad.practical4;


public class User {
    private String Username;
    private String Description;
    private int Id;
    private boolean Follow;

    public User(String username, String description,int id,boolean follow){
        Username = username;
        Description = description;
        Id = id;
        Follow = follow;
    }

    public User(){

    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
