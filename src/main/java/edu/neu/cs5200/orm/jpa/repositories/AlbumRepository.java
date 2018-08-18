package edu.neu.cs5200.orm.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.neu.cs5200.orm.jpa.entities.Album;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
	@Query("SELECT a FROM Album a WHERE a.name = :name")
	public List<Album> findAlbumsByName(@Param("name") String name);

}
