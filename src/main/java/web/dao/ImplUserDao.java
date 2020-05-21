package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.*;

@Repository
public class ImplUserDao implements UserDao{



    @Autowired
    SessionFactory sessionFactory;


    @Override
    public User getUserById(int id) {
        Session session = sessionFactory.openSession();
        TypedQuery<User> query = session.createQuery("from User where id = :id");
        query.setParameter("id",id);
        User user = query.getSingleResult();
        session.close();
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<User> userList =session.createQuery("from User").list();
        session.close();
        return userList;
    }



    @Override
    public void deleteUser(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("DELETE FROM User WHERE id = :id");
        query.setParameter("id",id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }


    @Override
    public void updateUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query =session.createQuery("UPDATE User set name=:name,age = :age,password=:password,role=:role where id=:id");
        query.setParameter("name",user.getName());
        query.setParameter("age", user.getAge());
        query.setParameter("password",user.getPassword());
        query.setParameter("role",user.getRole());
        query.setParameter("id",user.getId());
        query.executeUpdate();
        transaction.commit();
        session.close();
    }


    @Override
    public void insertUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }
}
