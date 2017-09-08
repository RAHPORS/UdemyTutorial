package com.rahpors.UdemyTutorial.repository;

import com.rahpors.UdemyTutorial.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by ramon on 7/09/17.
 */

@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log,Serializable>{

}
