package com.wtench.StormCloud.services;

public interface StormService<T> {

    void publish(T entity);

}
