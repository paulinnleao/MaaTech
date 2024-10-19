package com.maatech.lista.repository;

import com.maatech.lista.entity.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, ListItem.ListItemId> {

    @Query("SELECT l FROM ListItem l WHERE l.user.idUser = :idUser")
    List<ListItem> findUserItemList(@Param("idUser") UUID idUser);

}
