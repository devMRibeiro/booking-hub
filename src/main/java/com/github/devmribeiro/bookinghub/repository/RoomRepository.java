package com.github.devmribeiro.bookinghub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.devmribeiro.bookinghub.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	List<Room> findByType(String type);
	List<Room> findByCapacity(Integer capacity);
	List<Room> findByTypeAndCapacity(String type, Integer capacity);
}