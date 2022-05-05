package com.neuro.simplev6.ui.home.Database;




import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {

    @Insert
    void insertAll(EntityClass entityClass);

    @Query("SELECT * FROM myTable")
    List<EntityClass> getAllData();

    @Query("DELETE FROM myTable")
    void delete();

    @Query("DELETE FROM myTable WHERE eventname=:eventname")
    void deleteevent(String eventname);

}
