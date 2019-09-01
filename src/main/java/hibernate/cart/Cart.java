package hibernate.cart;


import hibernate.items.Items;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="CART", catalog = "OneToMany")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "cart_color")
    private String color;

    @OneToMany(mappedBy="cart", cascade = CascadeType.ALL)
    private Set<Items> items = new HashSet<Items>();;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Set<Items> getItems() {
        return items;
    }

    public void setItems(Set<Items> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(color, cart.color) &&
                Objects.equals(items, cart.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color, items);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", color='" + color + '\'' +
                ", items=" + items +
                '}';
    }
}