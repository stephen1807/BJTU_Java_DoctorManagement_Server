package project.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.obj.PatientAppointment;
import project.util.DBSession;

/**
 * Created by Stephen on 2014/12/24.
 */
public class PatientAppointmentService {

    public boolean insertAppointment(PatientAppointment pa){

        DBSession dbs = DBSession.getInstance();

        Session session = dbs.getSession();

        Transaction tr = null;


        try {

            tr = session.beginTransaction();

            session.save(pa);

            tr.commit();

        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }

        return true;
    }
}
