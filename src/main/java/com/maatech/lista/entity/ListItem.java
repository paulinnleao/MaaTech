package com.maatech.lista.entity;

import com.maatech.item.entity.Item;
import com.maatech.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "LIST_ITEMS")
public class ListItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idList;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idItem")
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User user;

    public ListItem() {
    }

    public ListItem(UUID idList, Item item, User user) {
        this.idList = idList;
        this.item = item;
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListItem listItem = (ListItem) o;
        return Objects.equals(idList, listItem.idList) && Objects.equals(item, listItem.item) && Objects.equals(user, listItem.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idList, item, user);
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "idList=" + idList +
                ", item=" + item +
                ", user=" + user +
                '}';
    }
}
