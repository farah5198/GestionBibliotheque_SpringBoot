package com.isetN.romans.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.isetN.romans.entities.Genre;
import com.isetN.romans.entities.Roman;

@RepositoryRestResource(path = "rest")

public interface RomanRepository extends JpaRepository<Roman,Long> {

	 List<Roman> findByTitreRoman(String titre);
	 List<Roman> findByTitreRomanContains(String titre);

	/* @Query("select r from Roman r where r.titreRoman like %?1 and r.prixRoman > ?2")
	 List<Roman> findByNomPrix (String titre, Double prix);*/

	 @Query("select r from Roman r where r.titreRoman like %:titre and r.prixRoman > :prix")
	 List<Roman> findByTitrePrix (@Param("titre") String titre ,@Param("prix") Double prix);

	 
	 @Query("select r from Roman r where r.genre = ?1")
	 List<Roman> findByGenre (Genre genre);
	 
	 List<Roman> findByGenreIdGenr(Long id);
	 
	 List<Roman> findByOrderByTitreRomanAsc();

	 @Query("select r from Roman r order by r.titreRoman ASC, r.prixRoman DESC")
	 List<Roman> trierRomansTitresPrix ();

}
