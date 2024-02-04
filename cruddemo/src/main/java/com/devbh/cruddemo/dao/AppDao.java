package com.devbh.cruddemo.dao;

import com.devbh.cruddemo.entity.Instructor;
import com.devbh.cruddemo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    InstructorDetail findInstructorDetailById(int theId);
    void deleteInstructorDetailById(int theId);
}
