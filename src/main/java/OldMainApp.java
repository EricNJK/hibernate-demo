import model.Actor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class OldMainApp {

    private static Actor[] actors = new Actor[]{
            new Actor("Jane", "Doe"),
            new Actor("John", "Doe")
    };

    public static void main(String[] a) {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.postgresql.Driver");
        settings.put(Environment.USER, "remote");
        settings.put(Environment.PASS, "4444");
        settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/dvdrentalHBN");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        settings.put(Environment.HBM2DDL_AUTO, "create");
        //
        settings.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.setProperties(settings);
        configuration.addAnnotatedClass(Actor.class);

        ServiceRegistry standardServiceRegistry = configuration.getStandardServiceRegistryBuilder()
                .applySettings(settings)
                .build();

        SessionFactory factory = configuration.buildSessionFactory(standardServiceRegistry);
        Session session1 = factory.openSession();
        Transaction transaction = session1.beginTransaction();
        try {
            Object res = session1.save(actors[0]);
            transaction.commit();
            System.out.println(" -> new id: " + res.toString());

        } catch (Exception ex) {
            if (transaction != null)
                transaction.rollback();
        }
        session1.close();
        factory.close();


        return;
    }
}
