package Student;

import Factory.FactoryProvider;
import Teacher.TeacherLogDetails;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Random;

public class Demo {
    public static void main(String[] args) {

        try{
//            StudentLogDetail sd=new StudentLogDetail("rabin",7908);

            Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();

            TeacherLogDetails t = (TeacherLogDetails) s.get(TeacherLogDetails.class,971);
            t.setPassword(4567);

            s.save(t);
            tx.commit();
            s.close();

            //saving in to table...

//            s.save(sd);



            //modify the table content...

//            StudentLogDetail sdd=(StudentLogDetail) s.get(StudentLogDetail.class,6655);
//            sdd.setMark(new Marks(56,89));



            //get all student...
//            String name="debasish";
//            String HQL="FROM StudentLogDetail where name=:name";
//
//            Query<StudentLogDetail> query = s.createQuery(HQL, StudentLogDetail.class);
//            query.setParameter("name",name);
//
//            List<StudentLogDetail> list = query.list();
//            for(int i=0;i<list.size();i++){
//                System.out.println(list.get(i).mark.getC());
//            }


//
//
            tx.commit();
            s.close();





        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
