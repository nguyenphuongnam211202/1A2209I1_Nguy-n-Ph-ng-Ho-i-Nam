package main;

public class SinhVien {
    private String id;
    private String name;
    private int dob;
    private float dtb;

    public SinhVien(String id, String name, int dob, float dtb) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.dtb = dtb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public float getDtb() {
        return dtb;
    }

    public void setDtb(float dtb) {
        this.dtb = dtb;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", dtb=" + dtb +
                '}';
    }
}
