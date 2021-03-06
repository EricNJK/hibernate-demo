import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import java.util.List;
import java.util.Properties;

public class MainApp {

    public static void main(String[] g) {
        Properties settings = new Properties();
        settings.put(Environment.DRIVER, "org.postgresql.Driver");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL95Dialect");
        settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/dvdrental");
        settings.put(Environment.HBM2DDL_AUTO, "none"); //or "update" to create db
        //settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/newdvdrental");
        //settings.put(Environment.HBM2DDL_AUTO, "update");
        settings.put(Environment.USER, MyConfigParams.USER); // redacted :)
        settings.put(Environment.PASS, MyConfigParams.PASS);
        //settings.put(Environment.SHOW_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.setProperties(settings);
        // add all Annotated Classes (@Entity...)
        {
            configuration.addAnnotatedClass(Actor.class);
            configuration.addAnnotatedClass(Address.class);
            configuration.addAnnotatedClass(Category.class);
            configuration.addAnnotatedClass(City.class);
            configuration.addAnnotatedClass(Country.class);
            configuration.addAnnotatedClass(Customer.class);
            configuration.addAnnotatedClass(Film.class);
            configuration.addAnnotatedClass(Inventory.class);
            configuration.addAnnotatedClass(Language.class);
            configuration.addAnnotatedClass(Payment.class);
            configuration.addAnnotatedClass(Rental.class);
            configuration.addAnnotatedClass(Staff.class);
            configuration.addAnnotatedClass(Store.class);
        }

        StandardServiceRegistry ssr = configuration.getStandardServiceRegistryBuilder()
                .applySettings(settings)
                .build();

        // fetch Addresses and print to screen
        try (SessionFactory factory = configuration.buildSessionFactory(ssr);
             Session session = factory.openSession()) { // session & factory is AutoCloseable, Transaction is not
            Transaction t = session.beginTransaction();
            String qry = "from Address";
            List<Address> result = session.createQuery(qry, Address.class)
                    .setMaxResults(10) // sql equivalent: offset 0 rows fetch next 10 rows only
                    .getResultList();
            result.forEach(System.out::println); // using toString() generated by lombok
            t.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
