package project.implementation;

import project.interfaces.CustomerServiceWS;
import project.obj.*;
import project.service.*;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Stephen on 2014/12/24.
 */
@WebService(
        portName="CustomerServicePort",
        serviceName="CustomerServiceService",
        targetNamespace="http://dcproject3.org/wsdl",
        endpointInterface="project.interfaces.CustomerServiceWS"
)
public class CustomerService implements CustomerServiceWS {

    public boolean checkLogin(int patientID, String patientName) {

        PatientInfoService pis = new PatientInfoService();

        PatientInfo patient = pis.getLoginInfo(patientID);

        return (patient == null) ? false : patient.getPatientName().equals(patientName);
    }

    public ArrayList<DepartmentInfo> getAllDepartments() {

        DepartmentInfoService dis = new DepartmentInfoService();

        return dis.getAllDepartments();
    }

    public ArrayList<DoctorInfo> getAllDoctors() {

        DoctorInfoService dis = new DoctorInfoService();

        return dis.getAllDoctors();
    }

    public DoctorInfo getDoctorByID(int doctorID) {
        DoctorInfoService dis = new DoctorInfoService();

        return dis.getDoctorByID(doctorID);
    }

    public ArrayList<DoctorInfo> getDoctorsByDepartment(int departmentID) {

        DoctorInfoService dis = new DoctorInfoService();

       return dis.getDoctorByDepartment(departmentID);
    }

    public boolean makeAppointment(int patientID, int doctorID, Date appointmentDate) {

        PatientAppointmentService pas = new PatientAppointmentService();

        PatientAppointment pa = new PatientAppointment();

        pa.setPatientid(patientID);
        pa.setDoctorid(doctorID);
        pa.setAppointmentdate(appointmentDate);

        return pas.insertAppointment(pa);
    }

    @Override
    public ArrayList<MedicalRecord> getMedicalRecord(int patientID) {

        MedicalRecordService mds = new MedicalRecordService();

        return mds.getMedicalRecord(patientID);
    }
}


