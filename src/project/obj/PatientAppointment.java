package project.obj;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by Stephen on 2014/12/24.
 */
@Entity
public class PatientAppointment {

    private int patientid;
    private int doctorid;
    private Date appointmentdate;

    @Basic
    @Column(name="patientid")
    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    @Basic
    @Column(name="doctorid")
    public int getDoctorid() {
        return doctorid;
    }

    public void setDoctorid(int doctorid) {
        this.doctorid = doctorid;
    }

    @Basic
    @Column(name="appointmentdate")
    public Date getAppointmentdate() {
        return appointmentdate;
    }

    public void setAppointmentdate(Date appointmentdate) {
        this.appointmentdate = appointmentdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PatientAppointment)) return false;

        PatientAppointment that = (PatientAppointment) o;

        if (doctorid != that.doctorid) return false;
        if (patientid != that.patientid) return false;
        if (!appointmentdate.equals(that.appointmentdate)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = patientid;
        result = 31 * result + doctorid;
        result = 31 * result + appointmentdate.hashCode();
        return result;
    }
}
