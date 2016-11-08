package sk.cyklosoft.cykloservice.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.joda.time.DateTime;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import sk.cyklosoft.cykloservice.dao.SportDao;
import sk.cyklosoft.cykloservice.model.CykloData;
import sk.cyklosoft.cykloservice.model.User;
import sk.cyklosoft.cykloservice.util.SportType;
import sk.cyklosoft.cykloservice.util.TrainType;
import sk.cyklosoft.cykloservice.vo.SportActivity;

@Repository("sportDao")
public class SportDaoImpl extends CommonDao implements SportDao {

	@Override
	public void setTrainingDataIndoorCyclo(final CykloData hrm) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.save(hrm);
				return null;
			}
		});
	}

	@Override
	public SportActivity getTrainingDataRun(String username, SportType runnig,
			TrainType trainType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CykloData getTrainingDataIndoorCyclo(final String username, final SportType sportType) {
		@SuppressWarnings("unchecked")
		CykloData result = hibernateTemplate.execute(new HibernateCallback<CykloData>() {

			@Override
			public CykloData doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(CykloData.class,"data");
				criteria.createAlias("data.users", "users");
				criteria.add(Restrictions.eq("users.username", username));
				criteria.add(Restrictions.eq("data.sportActivity", sportType));
				criteria.addOrder(Order.desc("data.datetime"));
				criteria.setMaxResults(1);
				return (CykloData)criteria.uniqueResult();
	          }
	      });

		 return result;
	}

	@Override
	public List<CykloData> getTrainingStatisticList(final String username,
			final SportType sportType, final DateTime dateFrom, final DateTime dateTo) {
		@SuppressWarnings("unchecked")
		List<CykloData> result = (List<CykloData>) hibernateTemplate.execute(new HibernateCallback<List<CykloData>>() {

			@Override
			public List<CykloData> doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = session.createCriteria(CykloData.class,"data");
				criteria.createAlias("data.users", "users");
				criteria.add(Restrictions.between("data.datetime", dateFrom, dateTo));
				criteria.add(Restrictions.eq("users.username", username));
				criteria.add(Restrictions.eq("data.sportActivity", sportType));
				criteria.addOrder(Order.asc("data.datetime"));
				return (List<CykloData>)criteria.list();
	          }
	      });

		 return result;
	}

	@Override
	public void setTrainingDataRun(String username, SportType runnig,
			long datetime, double hrm) {
		// TODO Auto-generated method stub
		
	}

	
	@Override
	public void deleteTrainingDataHRM(final String username, final SportType sportType, final DateTime deleteDate) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
        		Criteria criteria = session.createCriteria(CykloData.class,"data");
				criteria.createAlias("data.users", "users");
				criteria.add(Restrictions.between("data.datetime", 
						new DateTime(deleteDate.getYear(), deleteDate.getMonthOfYear(),deleteDate.getDayOfMonth(),0,0), 
						new DateTime(deleteDate.getYear(), deleteDate.getMonthOfYear(),deleteDate.getDayOfMonth(),23,59)));
				criteria.add(Restrictions.eq("users.username", username));
				criteria.add(Restrictions.eq("data.sportActivity", sportType));
				criteria.addOrder(Order.asc("data.datetime"));
				List<CykloData> result = (List<CykloData>)criteria.list();
				for(CykloData item : result) {
					session.delete(item);	
				}
				return null;
            }
        });
		
	}
	
	@Override
	public void deleteTrainingDataHRM(final User user, final SportType sportType) {
		hibernateTemplate.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                String hql = "delete from CykloData where users = :user ";
                if(sportType != null) {
                    hql += " and sportActivity = " + sportType.ordinal();                	
                }
                Query query = session.createQuery(hql);
                query.setEntity("user", user);
                query.executeUpdate();
                return null;
            }
        });
		
	}

}
