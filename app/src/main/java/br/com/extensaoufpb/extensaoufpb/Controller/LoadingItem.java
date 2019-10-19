package br.com.extensaoufpb.extensaoufpb.Controller;

import java.util.ArrayList;
import java.util.List;

public class LoadingItem<Item> {

    private List<Item> items;
    private List<Item> listDate;

    public LoadingItem(List<Item> listItem,List<Item> listDate){

        this.items = listItem;
        this.listDate = listDate;

    }

    public LoadingItem() {

        this.items = new ArrayList<>();
        this.listDate = new ArrayList<>();

    }


    public List<Item> loading(int offset){

        if(items.size() < listDate.size()){

            if((items.size() + offset) > listDate.size()) {

                offset = listDate.size();

            }

            for(int i = items.size(); i < offset; i++){

                items.add(listDate.get(i));

            }

        }

        return items;

    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getListDate() {
        return listDate;
    }

    public void setListDate(List<Item> listDate) {
        this.listDate = listDate;
    }
}
