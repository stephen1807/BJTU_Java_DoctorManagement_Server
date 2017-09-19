package project.interfaces;

import project.obj.DepartmentInfo;
import project.obj.DoctorInfo;
import project.obj.MedicalRecord;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Stephen on 2014/12/24.
 */
@WebService(targetNamespace = "http://dcproject3.org/wsdl")
public interface CustomerServiceWS {

    public boolean checkLogin(int patientID, String patientName);

    public ArrayList<DepartmentInfo> getAllDepartments();

    public ArrayList<DoctorInfo> getAllDoctors();

    public DoctorInfo getDoctorByID(int doctorID);

    public ArrayList<DoctorInfo> getDoctorsByDepartment(int departmentID);

    public boolean makeAppointment(int patientID, int doctorID, Date appointmentDate);

    public ArrayList<MedicalRecord> getMedicalRecord(int patientID);
}
