package kr.code6150.data;

public class User {

    private String name;
    private String phone;
    private String id;
    private String pw;

   public User(String name, String phone, String id, String pw) {
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.pw = pw;
   }

   public String getName() { return name; }
   public String getPhone() { return phone; }
   public String getId() { return id; }
   public String getPw() { return pw; }

}
