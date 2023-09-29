package org.exhibition.lab2.service;

import org.exhibition.lab2.model.Model;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface Service <T extends Model>{

    CrudRepository<T, Long> getRepository();

    default List<T> getAll(){
        List<T> authorList = new ArrayList<>();
        getRepository().findAll().forEach(authorList::add);
        return authorList;
    }

    default T findById(int id){
        var check = getRepository().findById(Long.valueOf(id));
        if(check.isPresent()){
            return check.get();
        }
        T res = null;
        return res;
    }

    default void save(T model){getRepository().save(model);
    }

    default void deleteById(int id){
        getRepository().deleteById(Long.valueOf(id));
    }
}
