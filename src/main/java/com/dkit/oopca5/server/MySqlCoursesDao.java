package com.dkit.oopca5.server;

import com.dkit.oopca5.core.Course;
import com.dkit.oopca5.core.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;

public class MySqlCoursesDao extends MySqlDAO implements CourseDaoInterface{
    @Override
    public List<Course> findAllCourses() throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Course> courseList = new LinkedList<>();

        try
        {
            con = this.getConnection();

            String query = "SELECT * FROM course";
            ps = con.prepareStatement(query);

            rs = ps.executeQuery();

            while(rs.next())
            {
                String courseId = rs.getString("courseid");
                int level = rs.getInt("level");
                String title = rs.getString("title");
                String institution = rs.getString("institution");
                Course c = new Course(courseId, level, title, institution);
                courseList.add(c);
            }
        }catch (SQLException e)
        {
            throw new DaoException("findAllCourses() " + e.getMessage());
        }finally
        {
            try
            {
                if(rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            }catch (SQLException e)
            {
                throw new DaoException("findAllCourses() " + e.getMessage());
            }
        }

        return courseList;
    }

    @Override
    public Course findSpecificCourse(String courseID) throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Course c = null;

        try
        {
            con = this.getConnection();

            String query = "SELECT * FROM course WHERE courseid = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, courseID);

            rs = ps.executeQuery();

            if(rs.next())
            {
                String courseId = rs.getString("courseid");
                int level = rs.getInt("level");
                String title = rs.getString("title");
                String institution = rs.getString("institution");
                c = new Course(courseId, level, title, institution);
            }
        }catch (SQLException e)
        {
            throw new DaoException("findSpecificCourse() " + e.getMessage());
        }finally
        {
            try
            {
                if(rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            }catch (SQLException e)
            {
                throw new DaoException("findSpecificCourse() " + e.getMessage());
            }
        }

        return c;
    }

    @Override
    public List<String> findCoursesForUser(int caoNumber) throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<String> choices = new LinkedList<>(); //Linked list will store the elements in order, which is important here
        try
        {
            con = this.getConnection();

            String query = "SELECT 'courseid' FROM student_courses WHERE caoNumber = ? ORDER BY priority ASC";
            ps = con.prepareStatement(query);
            ps.setInt(1, caoNumber);

            rs = ps.executeQuery();

            while(rs.next())
            {
                String courseId = rs.getString("courseid");
                choices.add(courseId);
            }
        }catch (SQLException e)
        {
            throw new DaoException("findSpecificCourse() " + e.getMessage());
        }finally
        {
            try
            {
                if(rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            }catch (SQLException e)
            {
                throw new DaoException("findSpecificCourse() " + e.getMessage());
            }
        }

        return choices;
    }

    @Override
    public void updateCoursesForUser(int caoNumber, List<String> courses) throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            con = this.getConnection();

            for (int i = 0; i < 10; i++)
            {
                String query = "UPDATE student_courses SET courseid = ? WHERE caoNumber = ? AND priority = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, courses.get(i));
                ps.setInt(2, caoNumber);
                ps.setInt(3, i+1);

                ps.executeQuery();
            }
        }catch (SQLException e)
        {
            throw new DaoException("updateCoursesForUser() " + e.getMessage());
        }finally
        {
            try
            {
                if(rs != null)
                {
                    rs.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (con != null)
                {
                    freeConnection(con);
                }
            }catch (SQLException e)
            {
                throw new DaoException("updateCoursesForUser() " + e.getMessage());
            }
        }
    }
}
