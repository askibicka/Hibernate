package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "TYPES")
public class ORMTypes {
    //POJO = Plain Old Java Object
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int anInt;
    private short aShort;
    private float aFloat;
    private double aDouble;
    private String string;
    public ORMTypes() {}
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public int getAnInt() { return anInt; }
    public void setAnInt(int anInt) { this.anInt = anInt; }
    public short getaShort() { return aShort; }
    public void setaShort(short aShort) { this.aShort = aShort; }
    public float getaFloat() { return aFloat; }
    public void setaFloat(float aFloat) { this.aFloat = aFloat; }
    public double getaDouble() { return aDouble; }
    public void setaDouble(double aDouble) { this.aDouble = aDouble; }
    public String getString() { return string; }
    public void setString(String string) { this.string = string; }

    public void setPoryRoku(PoryRoku lato) {
    }

    public void setIntArray(int[] ints) {
    }

    public void setDate(Date from) {
    }

    public void setTimestamp(Date from) {
    }

    public void setTime(Date from) {
    }

    public void setPassword(String zimna_wiosna) {
    }
}