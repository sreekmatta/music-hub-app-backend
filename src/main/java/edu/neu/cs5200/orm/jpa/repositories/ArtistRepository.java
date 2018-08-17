package edu.neu.cs5200.orm.jpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.neu.cs5200.orm.jpa.entities.Album;
import edu.neu.cs5200.orm.jpa.entities.Artist;

public interface ArtistRepository extends CrudRepository<Artist, Integer> {

	@Query("SELECT a.albums FROM Artist a WHERE a.id like :artistId")
	public List<Album> findAlbumsByArtistId(@Param("artistId") int artistId);
	
}
