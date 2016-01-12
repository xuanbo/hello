package com.hello.dao.impl;

import com.hello.dao.UserDao;
import com.hello.entity.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xuan on 2015/12/26.
 */
@Repository("userDao")
public class UserDaoimpl extends BaseDaoImpl <User, Integer> implements UserDao {

//    public List<User> getByCriteria() {
//        Property name = Property.forName("name");
//        List list = super.getHibernateSession().createCriteria(User.class)
//                .add(Restrictions.like("name", "张%"))
//                .list();
//        return list;
//    }
}
