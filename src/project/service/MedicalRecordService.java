package project.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.obj.MedicalRecord;
import project.util.DBSession;

import java.util.ArrayList;

/**
 * Created by Stephen on 2014/12/25.
 */
public class MedicalRecordService {

    public ArrayList<MedicalRecord> getMedicalRecord(int patientID){

        DBSession dbs = DBSession.getInstance();

        Session session = dbs.getSession();

        Transaction tr = null;

        ArrayList<MedicalRecord> result = null;

        try {

            tr = session.beginTransaction();

            result = (ArrayList<MedicalRecord>) session.createQuery("FROM MedicalRecord m WHERE m.patientID = :PatientID ORDER BY diagnosisDate DESC").setParameter("PatientID", patientID).list();

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;

    }

}
