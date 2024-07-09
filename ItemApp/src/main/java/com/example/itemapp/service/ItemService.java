package com.example.itemapp.service;

import com.example.itemapp.domain.Item;

import java.util.List;

/* Think about CRUD
Create, Read, Update, Delete 순서 */
public interface ItemService {
    Item creatNewItem(Item item); // C
    Item getItemById(long id); // R
    List<Item> getAllItems(String title); // R > if input null, return all > else return 해당 id인 아이템
    Item updateItem(long id, Item item); // U
    void deleteItem(long id); // D
    void deleteAllItems(); // D
}
