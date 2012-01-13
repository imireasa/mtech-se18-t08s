package sg.edu.nus.iss.vms.common.dao.hibernate;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;

import sg.edu.nus.iss.vms.common.dao.QueryParameterDao;
import sg.edu.nus.iss.vms.common.orm.QueryParameter;
import sg.edu.nus.iss.vms.common.orm.QueryProperties;
import sg.edu.nus.iss.vms.common.orm.hibernate.criterion.SimpleExpression;
import sg.edu.nus.iss.vms.common.query.BetweenParameter;
import sg.edu.nus.iss.vms.common.query.GroupByParameter;
import sg.edu.nus.iss.vms.common.query.InParameter;
import sg.edu.nus.iss.vms.common.query.LikeParameter;
import sg.edu.nus.iss.vms.common.query.NullParameter;
import sg.edu.nus.iss.vms.common.query.OperatorParameter;

/**
 * @author zaw.htet
 *
 */
@SuppressWarnings("unchecked")
public class QueryParameterDaoHibernate extends BaseDaoHibernate implements QueryParameterDao {

    public List getObjects(QueryParameter parameter, QueryProperties properties) {
        DetachedCriteria criteria = DetachedCriteria.forClass(parameter.getType());

        ProjectionList projectionList = Projections.projectionList();

        List parameters = parameter.getParameters();
        for (int i = 0, size = parameters.size(); i < size; i++) {
            Object param = parameters.get(i);
            if (param != null) {
                if (param instanceof OperatorParameter) {
                    OperatorParameter p = (OperatorParameter) param;

                    if (properties != null) {
                        criteria.add(new SimpleExpression(p.getPropertyName(), p.getValue(), p.getOperator(), properties.isIgnoreCase()));
                    } else {
                        criteria.add(new SimpleExpression(p.getPropertyName(), p.getValue(), p.getOperator(), p.isIgnoreCase()));
                    }

                    // if propertyName
                    if (p.isDistinctPropertyName()) {
                        projectionList.add(Projections.property(p.getPropertyName()), p.getPropertyName() + "_");
                    }
                } else if (param instanceof BetweenParameter) {
                    BetweenParameter p = (BetweenParameter) param;
                    criteria.add(Restrictions.between(p.getPropertyName(), p.getLowValue(), p.getHighValue()));
                } else if (param instanceof InParameter) {
                    InParameter p = (InParameter) param;
                    criteria.add(Restrictions.in(p.getPropertyName(), p.getValues()));
                } else if (param instanceof NullParameter) {
                    NullParameter p = (NullParameter) param;
                    if (p.isPropertyNull()) {
                        criteria.add(Restrictions.isNull(p.getPropertyName()));
                    } else {
                        criteria.add(Restrictions.isNotNull(p.getPropertyName()));
                    }
                } else if (param instanceof LikeParameter) {
                    LikeParameter p = (LikeParameter) param;
                    if (p.isPropertyNotLike()) {
                        if (p.isIgnoreCase()) {
                            criteria.add(Restrictions.ilike(p.getPropertyName(), p.getValue()));
                        } else {
                            criteria.add(Restrictions.like(p.getPropertyName(), p.getValue()));
                        }
                    } else {
                        if (p.isIgnoreCase()) {
                            criteria.add(Restrictions.not(Restrictions.ilike(p.getPropertyName(), p.getValue())));
                        } else {
                            criteria.add(Restrictions.not(Restrictions.like(p.getPropertyName(), p.getValue())));
                        }
                    }

                    // if propertyName
                    if (p.isDistinctPropertyName()) {
                        projectionList.add(Projections.property(p.getPropertyName()), p.getPropertyName() + "_");
                    }
                } else if (param instanceof GroupByParameter) {
                    GroupByParameter p = (GroupByParameter) param;
                    if ("group".equalsIgnoreCase(p.getPropertyParameter())) {
                        criteria.setProjection(Projections.groupProperty(p.getPropertyName()));
                    } else if ("order".equalsIgnoreCase(p.getPropertyParameter())) {
                        if ("desc".equalsIgnoreCase(p.getOrderBy())) {
                            criteria.addOrder(Order.desc(p.getPropertyName()));
                        } else {
                            criteria.addOrder(Order.asc(p.getPropertyName()));
                        }

                    }
                }
            }
        }

        if (projectionList.getLength() > 0) {
            criteria.setProjection(Projections.distinct(projectionList));
        }

        if (properties != null) {
            return getHibernateTemplate().findByCriteria(criteria, properties.getFirstResult(), properties.getMaxResults());
        } else {
            return getHibernateTemplate().findByCriteria(criteria, -1, -1);
        }
    }
}
