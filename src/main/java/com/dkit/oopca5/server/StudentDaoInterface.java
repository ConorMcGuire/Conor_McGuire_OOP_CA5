package com.dkit.oopca5.server;

import com.dkit.oopca5.core.Student;
import com.dkit.oopca5.core.DaoException;

public interface StudentDaoInterface {
    public boolean registerStudent(Student student) throws DaoException;
    public boolean login(Student student) throws DaoException;
    public boolean checkIfStudentRegistered(Student student) throws DaoException;
}
