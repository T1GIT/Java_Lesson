package attestation_2.databases.users_autos.utils;

import attestation_2.databases.utils.Dao;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class DaoImpl<T> implements Dao<T> {
    protected final List<T> items = new ArrayList<>();

    public DaoImpl() {}

    public abstract T findById(int id);

    @Override
    public Optional<T> get(int id) {
        return Optional.ofNullable(items.get(id));
    }

    @Override
    public abstract List<T> getAll();

    @Override
    public void save(T item) {
        Session session = HibernateSession.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(item);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(T item) {
        Session session = HibernateSession.getSession();
        Transaction transaction = session.beginTransaction();
        session.update(item);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(T item) {
        Session session = HibernateSession.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(item);
        transaction.commit();
        session.close();
    }
}
