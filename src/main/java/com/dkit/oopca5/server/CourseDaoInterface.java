package com.dkit.oopca5.server;
import com.dkit.oopca5.core.Course;
import com.dkit.oopca5.core.DaoException;
import java.util.List;

public interface CourseDaoInterface {
    public List<Course> findAllCourses() throws DaoException;
    public Course findSpecificCourse(String courseID) throws DaoException;
    public List<String> findCoursesForUser(int caoNumber) throws DaoException;
    public void updateCoursesForUser(int caoNumber, List<String> courses) throws DaoException;
}
