package br.com.wellingtoncosta.sjae.repository;

import br.com.wellingtoncosta.sjae.domain.User;
import br.com.wellingtoncosta.sjae.util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
import java.util.List;

public class UserRepository implements Repository<Long, User> {

    private SessionFactory sessionFactory;

    public UserRepository() {
        this.sessionFactory = HibernateUtils.getSessionFactory();
    }

    @Override
    public User save(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(user);
            session.flush();
            session.close();
            return user;
        }
    }

    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.flush();
            session.close();
        }
    }

    @Override
    public List<User> findAll() {
        try (Session session = sessionFactory.openSession()) {
            TypedQuery<User> query = session.createQuery("from User", User.class);
            List<User> users = query.getResultList();
            session.close();
            return users;
        }
    }

    @Override
    public User findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            User user = session.get(User.class, id);
            session.close();
            return user;
        }
    }

}