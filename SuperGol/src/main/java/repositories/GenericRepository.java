package repositories;

import java.util.List;

import model.SuperGol;
import model.User;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;


public abstract class GenericRepository<T> extends HibernateDaoSupport {

    protected Class<T> persistentClass = this.getDomainClass();

    public SuperGol getAGameInstance(){
        SuperGol game = new SuperGol();
        game.setUsers(this.getHibernateTemplate().findByExample(new User()));

        return game;
    }

    @Transactional
    public void delete(Integer id) {
        T obj = this.find(id);
        this.getHibernateTemplate().delete(obj);
    }

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<T> all() {
        return (List<T>) this.getHibernateTemplate().find("from " + this.persistentClass.getName() + " o");
    }

    public T find(Integer id) {
        return this.getHibernateTemplate().get(this.persistentClass, id);
    }

    @Transactional
    public void save(T entity) {
        this.getHibernateTemplate().save(entity);
        this.getHibernateTemplate().flush();
    }

    @Transactional
    public void update(T entity) {
        this.getHibernateTemplate().update(entity);
    }

    protected abstract Class<T> getDomainClass();

}