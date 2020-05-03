package com.example.baconator.service;

import com.example.baconator.dao.ItemDao;
import com.example.baconator.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ItemService {
  private final ItemDao itemDao;

  @Autowired
  public ItemService(@Qualifier("ItemDao") ItemDao itemDao) {
    this.itemDao = itemDao;
  }

  public int getItems(Item item) {
    return itemDao.getItems();
  }

  public int getItemsByNum(Item item, int howMuch) {
    return itemDao.getItemsByNum(howMuch);
  }


  public List<Item> getItem(){
    return itemDao.selectItem();
  }

  public Optional<Item> getItemByRunID(UUID id) {
    return itemDao.getItemByRunId(id);
  }

  public int deleteItem(UUID id) {
    return itemDao.deleteItemById(id);
  }
}

