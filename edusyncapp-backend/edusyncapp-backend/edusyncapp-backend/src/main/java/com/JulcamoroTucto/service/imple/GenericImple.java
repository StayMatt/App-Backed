package com.JulcamoroTucto.service.imple;

import com.JulcamoroTucto.model.Estudiante;
import com.JulcamoroTucto.repository.IGeneRepo;
import com.JulcamoroTucto.service.IGenSer;

import java.util.List;

public  abstract class GenericImple<T, ID> implements IGenSer<T,ID> {
    protected abstract IGeneRepo<T,ID>getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(T t, ID id) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().deleteById(id);
    }
}
