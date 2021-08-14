package Student;

import javax.persistence.*;
import java.util.Random;



@Entity
@Table(name = "STUDENT_DETAIL")

//@NamedQueries({
//        @NamedQueries(name="StudentLogDetail.GetAll", query="select s from StudentLogDetail s")
//        @NamedQueries(name="StudentLogDetail.GetAll", query="select s from StudentLogDetail s")
//})

public class StudentLogDetail {
    @Id
    @Column(name = "S_ID")
    private int id;
    @Column(name = "S_NAME")
    private String name;
    @Column(name = "S_ROLLNO")
    private String roll;
    @Column(name = "S_PASSWORD")
    private int password;
    @Embedded
    public Marks mark;

    public StudentLogDetail( String name,int password, Marks mark) {
        this.id = new Random().nextInt(9999);
        this.name = name;
        this.password=password;
        this.roll = "j/2021/"+new Random().nextInt(1000);
        this.mark = mark;
    }

    public StudentLogDetail( String name,int password) {
        this.id = new Random().nextInt(9999);
        this.name = name;
        this.password=password;
        this.roll = "j/2021/"+new Random().nextInt(1000);
    }

    public StudentLogDetail() {

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

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public Marks getMark() {
        return mark;
    }

    public void setMark(Marks mark) {
        this.mark = mark;
    }


}
