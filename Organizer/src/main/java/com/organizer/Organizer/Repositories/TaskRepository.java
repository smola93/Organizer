package com.organizer.Organizer.Repositories;

import com.organizer.Organizer.Models.Task;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    @Query(value = "SELECT * FROM tasks WHERE task_date = :date", nativeQuery = true)
    List<Task> findByDate(@Param("date") Date date);

    @Query(value = "SELECT * FROM tasks WHERE task_type = :type", nativeQuery = true)
    List<Task> findByType(@Param("type") String type);
}
