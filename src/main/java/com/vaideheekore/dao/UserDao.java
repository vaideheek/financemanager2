package com.vaideheekore.dao;

import com.vaideheekore.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserDao {

    private SessionFactory factory;
    private Session session = null;
    private Transaction tx = null;

    public UserDao(SessionFactory factory) {
        super();
        this.factory = factory;
    }

    public boolean saveuser(User user){
        boolean f=false;
        try {
            session = factory.openSession();
            tx=session.beginTransaction();
            session.save(user);
            tx.commit();
            f=true;
        }
        catch (Exception e){
            if(tx!=null){
                f= false;
                e.printStackTrace();
            }
        }
        return f;
    }
}
