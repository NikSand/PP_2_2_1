package hiber.dao;

import hiber.model.Car;
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
   public void add(User user, Car car) {
      sessionFactory.getCurrentSession().save(user);
      sessionFactory.getCurrentSession().save(car);
   }


   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   public List<Car> listCars() {
      TypedQuery<Car> query=sessionFactory.getCurrentSession().createQuery("from Car ");
      return query.getResultList();
   }


   @Override
   public List <User> findUserByCar(String carModel, int carSeries) {

      //String HQL = "from Car myCar LEFT OUTER JOIN FETCH myCar.user where myCar.model = :carModel and myCar.series = :carSeries";
      String HQL = "from User us where us.car.series = :Series and us.car.model = :Model";
      System.out.println("Car found:");

      TypedQuery <User> query = sessionFactory.getCurrentSession().createQuery(HQL, User.class).setParameter("Model", carModel).setParameter("Series", carSeries);

      return query.getResultList();
   }

}
