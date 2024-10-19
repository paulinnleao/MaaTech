package com.maatech.lista.entity;

import com.maatech.item.entity.Item;
import com.maatech.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@Table(name = "LIST_ITEMS")
@IdClass(ListItem.ListItemId.class)
public class ListItem {

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idItem")
    private Item item;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User user;

    public ListItem(User user, Item item) {
        this.item = item;
        this.user = user;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ListItemId implements Serializable {
        private UUID idItem;
        private UUID idUser;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListItemId that = (ListItemId) o;
            return Objects.equals(idItem, that.idItem) && Objects.equals(idUser, that.idUser);
        }

        @Override
        public int hashCode() {
            return Objects.hash(idItem, idUser);
        }
    }
}
