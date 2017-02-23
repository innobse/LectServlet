package LectServlet.db.POJO;

import java.sql.Date;

/**
 * Created by bse71 on 22.02.2017.
 */
public class Student {
    private int id;
    private int group_id;
    private String name;
    private java.sql.Date birthday;
    private char sex;

    public int getId() {
        return id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public char getSex() {
        return sex;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public Student(int id, int group_id, String name, Date birthday, char sex) {
        this.id = id;
        this.group_id = group_id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return id + "\t" + group_id + "\t" + name + "\t" + birthday + "\t" + sex;
    }

    public Student() {
    }
}
