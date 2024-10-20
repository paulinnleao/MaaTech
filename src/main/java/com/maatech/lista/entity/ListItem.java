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
    @Column(name = "idUser", insertable = false, updatable = false)
    private UUID idUser;

    @Id
    @Column(name = "idItem", insertable = false, updatable = false)
    private UUID idItem;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idItem", referencedColumnName = "idItem", insertable = false, updatable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", insertable = false, updatable = false)
    private User user;

    public ListItem(User user, Item item) {
        this.item = item;
        this.user = user;
        this.idUser = user.getIdUser();
        this.idItem = item.getIdItem();
    }

    @Data
    public static class ListItemId implements Serializable {
        private UUID idItem;
        private UUID idUser;

        public ListItemId() {
        }

        public ListItemId(UUID idItem, UUID idUser) {
            this.idItem = idItem;
            this.idUser = idUser;
        }

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
