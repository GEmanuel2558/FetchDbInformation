package hibernate.items;


import hibernate.cart.Cart;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="ITEMS")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "ited_description")
    private String description;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

    public Items() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items items = (Items) o;
        return Objects.equals(id, items.id) &&
                Objects.equals(description, items.description) &&
                Objects.equals(cart, items.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, cart);
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", cart=" + cart +
                '}';
    }
}