package project.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.obj.PatientInfo;
import project.util.DBSession;

import java.util.ArrayList;

/**
 * Created by Stephen on 2014/12/24.
 */
public class PatientInfoService {

    public PatientInfo getLoginInfo(int patientID) {

        DBSession dbs = DBSession.getInstance();

        Session session =dbs.getSession();

        Transaction tr = null;

        PatientInfo patient = null;

        try {
            tr = session.beginTransaction();

            ArrayList<PatientInfo> temp = (ArrayList<PatientInfo>) session.createQuery("FROM PatientInfo p where p.patientId = :PatientID").setParameter("PatientID", patientID).setFirstResult(0).setMaxResults(1).list();

            if (temp.isEmpty()) {
                return null;
            }

            patient = temp.get(0);

            tr.commit();
        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return patient;
    }
}
