package main.com.ts.entity;

public class Hero {
    private int id;
    private String name;
    private  String  force_name;
    private  String addr;
    private  String info;

    public Hero() {
    }

    public Hero( String name, String force_name, String addr, String info) {
        this.name = name;
        this.force_name = force_name;
        this.addr = addr;
        this.info = info;
    }
    public Hero(int id, String name, String force_name, String addr, String info) {
       this.id = id;
        this.name = name;
        this.force_name = force_name;
        this.addr = addr;
        this.info = info;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getForce_name() {
        return force_name;
    }

    public void setForce_name(String force_name) {
        this.force_name = force_name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
