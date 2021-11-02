package miniproject2;

public class Contact implements Cloneable{

    private String name;
    private String mobile;
    private String work;

    private String home;
    private String city;
    private String email;

    public String getName() {
        return this.name;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getWork() {
        return this.work;
    }

    public String getCity() {
        return this.city;
    }

    public String getEmail() {
        return this.email;
    }

    public String getHome() {
        return this.home;
    }

    public void setHome(String h) {
        this.home = h;
    }

    public void setName(String n) {this.name = n;}

    public void setMobile(String m) {
        this.mobile = m;
    }

    public void setWork(String w) {
        this.work = w;
    }

    public void setCity(String c) {
        this.city = c;
    }

    public void setEmail(String e) {
        this.email = e;
    }

    Contact() {
        this.name = getName();
        this.mobile = getMobile();
        this.work = getWork();
        this.city = getCity();
        this.email = getEmail();
    }

    Contact(String name, String mobile, String work, String city) {
        this.name = name;
        this.mobile = mobile;
        this.work = work;
        this.city = city;
    }

}
