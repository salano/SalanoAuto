/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gy.salano.salanoauto.bean;

import gy.salano.salanoauto.entity.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author Salano
 */
public class LazyUserModel extends LazyDataModel<User> {

    private List<User> datasource;

    public LazyUserModel(List<User> model) {
        this.datasource = model;
    }

    @Override
    public List<User> load(int first, int pageSize, String sortField, SortOrder sortOrder,
            Map<String, Object> filters) {
        List<User> data = new ArrayList<>();
        for (User user : datasource) {
            data.add(user);
        }

        if (sortField != null) {
            //Collection.sort(data,new lazySorter(sortField, sortOrder)) ; 
        }
        int dataSize = data.size();
        this.setRowCount(dataSize);
        return data;
    }

    @Override
    public Object getRowKey(User user) {
        return user.getId();
    }

    @Override
    public User getRowData(String rowKey) {
        for (User user : datasource) {
            if (user.getId().toString().equals(rowKey)) {
                return user;
            }
        }
        return null;
    }
}
