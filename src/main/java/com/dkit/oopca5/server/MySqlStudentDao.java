package com.dkit.oopca5.server;

import com.dkit.oopca5.core.Student;
import com.dkit.oopca5.core.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MySqlStudentDao extends MySqlDAO implements StudentDaoInterface
{
    @Override
    public boolean registerStudent(Student student) throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean registered = false;

        try
        {
            con = this.getConnection();

            String query = "INSERT INTO student VALUES(?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, student.getCaoNumber());
            ps.setString(2, student.getDateOfBirth());
            ps.setString(3, student.getPassword());

            ps.executeUpdate();

            registered = true;
        }catch (SQLException e)
        {
            throw new DaoException("registerStudent() " + e.getMessage());
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
                throw new DaoException("registerStudent() " + e.getMessage());
            }
        }

        return registered;
    }

    @Override
    public boolean login(Student student) throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean loggedIn = false;

        try
        {
            con = this.getConnection();

            String query = "SELECT * FROM student WHERE caoNumber = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, student.getCaoNumber());

            rs = ps.executeQuery();

            if (rs.next())
            {
                String dateOfBirth = rs.getString("dateOfBirth");
                String password = rs.getString("Password");

                if(password == student.getPassword() && dateOfBirth == student.getDateOfBirth())
                {
                    loggedIn = true;
                }
            }
        }catch (SQLException e)
        {
            throw new DaoException("login() " + e.getMessage());
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
                throw new DaoException("login() " + e.getMessage());
            }
        }

        return loggedIn;
    }

    @Override
    public boolean checkIfStudentRegistered(Student student) throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean registered = false;

        try
        {
            con = this.getConnection();

            String query = "SELECT * FROM student WHERE caoNumber = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, student.getCaoNumber());

            rs = ps.executeQuery();

            if (rs.next())
            {
                String dateOfBirth = rs.getString("dateOfBirth");
                String password = rs.getString("Password");

                if(password == student.getPassword() && dateOfBirth == student.getDateOfBirth())
                {
                    registered = true;
                }
            }
        }catch (SQLException e)
        {
            throw new DaoException("checkIfStudentRegistered() " + e.getMessage());
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
                throw new DaoException("checkIfStudentRegistered() " + e.getMessage());
            }
        }

        return registered;
    }
}
