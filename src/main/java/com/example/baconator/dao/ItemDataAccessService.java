package com.example.baconator.dao;

import com.example.baconator.model.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("ItemDao")
public class ItemDataAccessService implements ItemDao {


    private static List<Item> DB = new ArrayList<>();
    @Override
    public int getItems() {

        if(!DB.isEmpty()){
            DB.clear();
        }
        Item item = new Item();
        item.AddBaconData(1);
        DB.add(item);
        return 1;
    }

    @Override
    public int getItemsByNum(int howMuch) {
        if(!DB.isEmpty()){
            DB.clear();
        }

        Item item = new Item();
        item.AddBaconData(howMuch);
        DB.add(item);
        return 1;
    }

    @Override
    public List<Item> selectItem(){
        return DB;
    }


    @Override
    public Optional<Item> getItemByRunId(UUID id) {
        return DB.stream()
                .filter(item -> item.getRunId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteItemById(UUID id) {
        Optional<Item> personMaybe = getItemByRunId(id);
        if(personMaybe.isEmpty()){
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }


}
