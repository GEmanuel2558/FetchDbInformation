package hibernate.runner;

import hibernate.cart.Cart;
import hibernate.items.Items;
import hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class ApplicationRunner {

    public static void main(String[] args) {
        System.out.println("Hibernate one to many (Annotation)");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

        Cart cart = new Cart();
        cart.setColor("Red");
        session.save(cart);

        Items firstItem = new Items();
        firstItem.setDescription("Item 1");
        Items secondItem = new Items();
        secondItem.setDescription("Item 2");

        firstItem.setCart(cart);
        secondItem.setCart(cart);
        cart.getItems().add(firstItem);
        cart.getItems().add(secondItem);

        session.save(firstItem);
        session.save(secondItem);

        session.getTransaction().commit();
        session.beginTransaction();

        Cart fetchInfo = session.get(Cart.class, 1L);
        System.out.println(fetchInfo);

        session.getTransaction().commit();
        System.out.println("Done");
    }

}
