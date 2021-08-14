package Student;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Marks {
    @Column(name = "C")
     int c;
    @Column(name = "JAVA")
    int java;

    public Marks(int c, int java) {
        this.c = c;
        this.java = java;
    }

    public Marks() {
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }
}
