package sk.cyklosoft.cykloservice.dao.impl;

import java.sql.SQLException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import sk.cyklosoft.cykloservice.dao.AuthorityDao;
import sk.cyklosoft.cykloservice.model.Authority;

@Repository("authorityDao")
public class AuthorityDaoImpl extends CommonDao implements AuthorityDao {

	@Override
	public void remove(final String username) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria= session.createCriteria(Authority.class);
                criteria.add(Restrictions.eq("username", username));
                Authority authority = (Authority)criteria.uniqueResult();
				session.delete(authority);
				return null;
			}
		});
	}

	@Override
	public void save(final Authority authority) {
        hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                session.save(authority);
                return null;
            }
        });
		
	}

	@Override
	public void update(Authority authority) {
		// TODO Auto-generated method stub
		
	}

}
