package project.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.obj.DoctorInfo;
import project.util.DBSession;

import java.util.ArrayList;

/**
 * Created by Stephen on 2014/12/24.
 */
public class DoctorInfoService {

    public ArrayList<DoctorInfo> getAllDoctors(){

        DBSession dbs = DBSession.getInstance();

        Session session = dbs.getSession();

        Transaction tr = null;

        ArrayList<DoctorInfo> result = null;

        try{
            tr = session.beginTransaction();

            result = (ArrayList<DoctorInfo>) session.createQuery("FROM DoctorInfo").list();

            tr.commit();
        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;
    }

    public DoctorInfo getDoctorByID(int doctorID){

        DBSession dbs = DBSession.getInstance();

        Session session =dbs.getSession();

        Transaction tr = null;

        DoctorInfo doctor = null;

        try {
            tr = session.beginTransaction();

            ArrayList<DoctorInfo> temp = (ArrayList<DoctorInfo>) session.createQuery("FROM DoctorInfo d where d.doctorId = :DoctorID").setParameter("DoctorID", doctorID).setFirstResult(0).setMaxResults(1).list();

            if (temp.isEmpty()) {
                return null;
            }

            doctor = temp.get(0);

            tr.commit();
        } catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }

        return doctor;

    }

    public ArrayList<DoctorInfo> getDoctorByDepartment(int departmentID){

        DBSession dbs = DBSession.getInstance();

        Session session = dbs.getSession();

        Transaction tr = null;

        ArrayList<DoctorInfo> result = null;

        try{
            tr = session.beginTransaction();

            result = (ArrayList<DoctorInfo>) session.createQuery("FROM DoctorInfo WHERE departmentID=:DepartmentID").setParameter("DepartmentID", departmentID).list();

            tr.commit();
        }catch (HibernateException e) {
            if (tr != null) tr.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return result;

    }
}
