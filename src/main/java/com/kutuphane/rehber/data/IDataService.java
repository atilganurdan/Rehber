/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kutuphane.rehber.data;

import java.util.List;

/**
 *
 * @author vektorel
 */
public interface IDataService<T> {
    public T save(T nesne);
    public T update(T nesne);
    public Boolean delete(T nesne);
    public List<T> getAll();
    public T getById(Long Id);
}
