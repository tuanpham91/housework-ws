

public class User {
    private int id= 0;
    private String name;
    private String realName;
    private String password;

    public User () {

    }


    public User (int i, String n, String rN , String p) {
        setId(i);
        setName(n);
        setRealName(rN);
        setPassword(p);

    }

    public void setName(String n) {
        this.name = n;
    }

    public void setRealName(String n) {
        this.realName= n;
    }

    public void setPassword(String n) {
        this.password = n;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
    public String getPassword() {
        return password;
    }
    public void setId(int n) {
        this.id = n;
    }

    public int getId() {
        return id;
    }
}
