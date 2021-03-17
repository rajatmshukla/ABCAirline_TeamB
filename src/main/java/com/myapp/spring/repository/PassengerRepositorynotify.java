package com.myapp.spring.repository;

import java.util.List;

import com.myapp.spring.model.Productnotify;

public interface PassengerRepositorynotify {

	List<Productnotify> findAllnotify();

	Productnotify Notifyusers(String username);

}
