package com.github.devmribeiro.bookinghub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.devmribeiro.bookinghub.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
	@Query(value = "select r.room_id, r.hotel_id, r.capacity, r.label, r.type from room r left join booking b on b.room_id = r.room_id where b.room_id is null", nativeQuery = true)
	List<Room> findAll();

	@Query(value = "select r.room_id, r.hotel_id, r.capacity, r.label, r.type from room r left join booking b on b.room_id = r.room_id where b.room_id is null and r.room_id = :roomId", nativeQuery = true)
	Room findByRoomId(@Param("roomId") Integer roomId);

	@Query(value = "select r.room_id, r.hotel_id, r.capacity, r.label, r.type from room r left join booking b on b.room_id = r.room_id where b.room_id is null and r.type = :type", nativeQuery = true)
	List<Room> findByType(@Param("type") String type);

	@Query(value = "select r.room_id, r.hotel_id, r.capacity, r.label, r.type from room r left join booking b on b.room_id = r.room_id where b.room_id is null and r.capacity = :capacity", nativeQuery = true)
	List<Room> findByCapacity(@Param("capacity") Integer capacity);

	@Query(value = "select r.room_id, r.hotel_id, r.capacity, r.label, r.type from room r left join booking b on b.room_id = r.room_id where b.room_id is null and r.type = :type and r.capacity = :capacity", nativeQuery = true)
	List<Room> findByTypeAndCapacity(@Param("type") String type, @Param("capacity") Integer capacity);
}