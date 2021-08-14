package Teacher;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Random;

@Entity
@Table(name = "TEACHER_LOGIN_TABLE")
public class TeacherLogDetails {
    @Id
    @Column(name = "T_ID")
    private int id;
    @Column(name = "T_NAME")
    private String name;
    @Column(name = "T_PASSWORD")
    private int password;


    public TeacherLogDetails(String name, int password) {
        this.id = new Random().nextInt(1000);
        this.name = name;
        this.password = password;
    }

    public TeacherLogDetails() {

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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
