package com.example.baconator.dao;

import com.example.baconator.model.Item;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemDao {

    int getItems();

    int getItemsByNum(int howMuch);
    
    List<Item> selectItem();

    Optional<Item> getItemByRunId(UUID id);

    int deleteItemById(UUID id);

}
