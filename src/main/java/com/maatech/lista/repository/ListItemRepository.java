package com.maatech.lista.repository;

import com.maatech.lista.entity.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ListItemRepository extends JpaRepository<ListItem, UUID> {
}
