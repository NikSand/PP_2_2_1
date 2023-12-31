package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }


   @Override
   public List <User> findUserByCar(String carModel, int carSeries) {

      String HQL = "from User us where us.car.series = :Series and us.car.model = :Model";
      System.out.println("Car found:");

      TypedQuery <User> query = sessionFactory.getCurrentSession().createQuery(HQL).setParameter("Model", carModel).setParameter("Series", carSeries);

      return query.getResultList();
   }

}
