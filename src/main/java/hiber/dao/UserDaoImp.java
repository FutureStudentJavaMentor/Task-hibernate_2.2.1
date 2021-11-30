package hiber.dao;

import hiber.config.AppConfig;
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
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }


    @Override
    public User getCarUser(Car car) {
        TypedQuery<User> query;
        try (SessionFactory sessionFactory1 = (SessionFactory) new AppConfig().getSessionFactory()) {
            query = sessionFactory1.getCurrentSession()
                    .createQuery("select User from User u inner join fetch u.car where u.car.model=:model and u.car.series =:series", User.class)
                    .setParameter("model", car.getModel())
                    .setParameter("series", car.getSeries());
        }
        return query.getSingleResult();
    }

}



