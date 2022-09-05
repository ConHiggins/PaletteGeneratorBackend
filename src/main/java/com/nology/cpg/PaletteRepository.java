package com.nology.cpg;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.awt.*;

@Repository
public interface PaletteRepository extends JpaRepository<Palette, Integer> {

    //List<Palette> findPalettesCreatedBy(String createdBy);

    @Modifying
    @Query("delete Palette p where p.createdBy = :createdBy")
    int deletePalettesByCreator(String createdBy);

}
