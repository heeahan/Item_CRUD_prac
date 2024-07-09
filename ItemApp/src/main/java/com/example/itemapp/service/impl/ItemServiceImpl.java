package com.example.itemapp.service.impl;

import com.example.itemapp.domain.Item;
import com.example.itemapp.service.ItemService;
import com.example.itemapp.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item creatNewItem(Item item){
        Item _item = itemRepository.save(new Item(item.getTitle(), item.getDescription(), item.getQuantity()));
        return _item;
    }

    public Item getItemById(long id){
        Optional<Item> itemData = itemRepository.findById(id); /* findById() returns an Optional<Item>,
        which is a container object that may or may not contain a Tutorial object.
        This helps avoid NullPointerException. */
        // This if can use 'return itemData.orElse(null);' in 1 line
        if (itemData.isPresent()){
            return itemData.get();
        }
        else {
            return null;
        }
    }

    public List<Item> getAllItems(String title){
        List<Item> items = new ArrayList<Item>();
        if (title == null){
            items = itemRepository.findAll();
        }
        else {
            items = itemRepository.findByTitleContaining(title);
        }
        return items;
    }

    public Item updateItem(long id, Item item){
        Optional<Item> itemData = itemRepository.findById(id);
        if (itemData.isPresent()){
            Item _item = itemData.get();
            _item.setTitle(item.getTitle()); // From the argument item
            _item.setDescription(item.getDescription());
            _item.setQuantity(item.getQuantity());
            return itemRepository.save(_item);
        }
        else {
            return null;
        }
    }

    void deleteItem(long id){
        itemRepository.deleteById(id);
    }

    void deleteAllItems(){
        itemRepository.deleteAll();
    }
}
