package homework.work.pojo;

/**
 * Created by Daniel on 2020/2/18.
 */
public class Student {
    private Integer Sno;
    private String Sname;
    private String Ssex;
    private Integer Sage;
    private String Sdept;

    public Student() {
    }

    public Student(String sname, String ssex, Integer sage, String sdept) {
        Sname = sname;
        Ssex = ssex;
        Sage = sage;
        Sdept = sdept;
    }

    public Student(Integer sno, String sname, String ssex, Integer sage, String sdept) {
        Sno = sno;
        Sname = sname;
        Ssex = ssex;
        Sage = sage;
        Sdept = sdept;
    }

    public Integer getSno() {
        return Sno;
    }

    public void setSno(Integer sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsex() {
        return Ssex;
    }

    public void setSsex(String ssex) {
        Ssex = ssex;
    }

    public Integer getSage() {
        return Sage;
    }

    public void setSage(Integer sage) {
        Sage = sage;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }

    @Override
    public String toString() {
        return "Stuend{" +
                "Sno=" + Sno +
                ", Sname='" + Sname + '\'' +
                ", Ssex='" + Ssex + '\'' +
                ", Sage=" + Sage +
                ", Sdept='" + Sdept + '\'' +
                '}';
    }
}
