package project.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import project.obj.DepartmentInfo;
import project.util.DBSession;

import java.util.ArrayList;

/**
 * Created by Stephen on 2014/12/25.
 */
public class DepartmentInfoService {

    public ArrayList<DepartmentInfo> getAllDepartments(){

        DBSession dbs = DBSession.getInstance();

        Session session = dbs.getSession();

        Transaction tr = null;

        ArrayList<DepartmentInfo> result = null;

        try {

            tr = session.beginTransaction();

            result = (ArrayList<DepartmentInfo>) session.createQuery("FROM DepartmentInfo").list();

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
