import entity.Student;

import org.hibernate.Session;
import persistence.HibernateUtil;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        HibernateUtil.createRecord();
        System.out.println("Number of students created: " + HibernateUtil.displayRecords().size());

        System.out.println("Before update: " + HibernateUtil.findRecordById(10));
        HibernateUtil.updateRecord(10 , "UpdateTest");
        System.out.println("After update: " + HibernateUtil.findRecordById(10));

        HibernateUtil.deleteRecord(1000);
        System.out.println("Students after delete one record: " + HibernateUtil.displayRecords().size());

        HibernateUtil.deleteAllRecords();
        System.out.println("Students after delete all records: " + HibernateUtil.displayRecords().size());

        System.exit(0);
    }

}
