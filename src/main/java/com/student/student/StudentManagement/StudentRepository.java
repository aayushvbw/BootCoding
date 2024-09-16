package com.student.student.StudentManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Student> studentRowMapper = new RowMapper<Student>() {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setId(rs.getLong("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setDob(rs.getString("dob"));
            student.setAge(rs.getInt("age"));

            return student;
        }
    };

    public List<Student> findAll() {
        String sql = "SELECT * FROM students";
        return jdbcTemplate.query(sql, studentRowMapper);
    }


    public int save(Student student) {
        String sql = "INSERT INTO students (name, email, dob, age) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, student.getName(), student.getEmail(), student.getDob(), student.getAge());
    }


    public int update(Student student) {
        String sql = "UPDATE students SET name = ?,email = ?,dob = ?, age = ? WHERE id = ?";
        return jdbcTemplate.update(sql, student.getName(),student.getEmail(), student.getDob(), student.getAge(),  student.getId());
    }


    public int deleteById(Long id) {
        String sql = "DELETE FROM students WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }


    public Student findById(Long id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, studentRowMapper, id);
    }
}
