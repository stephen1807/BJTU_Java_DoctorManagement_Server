package project.obj;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Stephen on 2014/12/23.
 */
@Entity
public class DoctorInfo {
    private int doctorId;
    private String doctorName;
    private int departmentID;
    private String telephone;


    @Id
    @Column(name = "doctorID")
    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    @Basic
    @Column(name = "doctorName")
    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Basic
    @Column(name="departmentID")
    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DoctorInfo)) return false;

        DoctorInfo that = (DoctorInfo) o;

        if (departmentID != that.departmentID) return false;
        if (doctorId != that.doctorId) return false;
        if (doctorName != null ? !doctorName.equals(that.doctorName) : that.doctorName != null) return false;
        if (telephone != null ? !telephone.equals(that.telephone) : that.telephone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = doctorId;
        result = 31 * result + (doctorName != null ? doctorName.hashCode() : 0);
        result = 31 * result + departmentID;
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        return result;
    }
}
