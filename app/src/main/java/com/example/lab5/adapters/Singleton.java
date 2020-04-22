package com.example.lab5.adapters;

import com.example.lab5.models.LikedItem;

import java.util.List;

//Класс Singleton нужен нам для того , чтобы передать наш массив данных из одного активити в другое

public class Singleton {
    private static Singleton singleObject;
    private List<LikedItem> items;

    public static Singleton getInstance()
    {
        if(singleObject == null)
        {
            singleObject = new Singleton();
        }
        return singleObject;
    }

    public void setItems(List<LikedItem> items) {
        this.items = items;
    }

    public List<LikedItem> getItems() {
        return items;
    }

    public LikedItem getItem(String name)
    {
        for(int i = 0; i < items.size(); i++)
        {
            if(items.get(i).getImageUrl().equals(name)) {
                return items.get(i);
            }
        }
        return null;
    }
}