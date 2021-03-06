package sk.cyklosoft.cykloservice.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import sk.cyklosoft.cykloservice.dao.UserDao;
import sk.cyklosoft.cykloservice.model.User;
import sk.cyklosoft.cykloservice.util.SportType;

@Repository("userDao")
public class UserDaoImpl extends CommonDao implements UserDao {

	@Override
	public void register(final User user) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.save(user);
				return null;
			}
		});
		
	}
	
    @Override
    public User findUserByUsername(final String username) {
        @SuppressWarnings("unchecked")
        User result = hibernateTemplate.execute(new HibernateCallback<User>() {

            @Override
            public User doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(User.class);
                criteria.add(Restrictions.eq("username", username));
                return (User)criteria.uniqueResult();
            }
        });

        return result;
    }


	
	@Override
	public SportType getCurrentActivity(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(String username, SportType sportType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(final String username) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria= session.createCriteria(User.class);
                criteria.add(Restrictions.eq("username", username));
                User user = (User)criteria.uniqueResult();
				session.delete(user);
				return null;
			}
		});
		
	}

    @Override
    public List<User> findAllUsers() {
        @SuppressWarnings("unchecked")
        List<User> result = hibernateTemplate.execute(new HibernateCallback<List<User>>() {

            @Override
            public List<User> doInHibernate(Session session) throws HibernateException, SQLException {
                Criteria criteria = session.createCriteria(User.class);
                return (List<User>)criteria.list();
            }
        });

        return result;
    }




}
