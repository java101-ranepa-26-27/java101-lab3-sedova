package ru.ranepa;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Student> students;

    public University() {
        students = new ArrayList<>();
    }

    public long enroll(String name) {
        Student student = Student.create(name);
        students.add(student);
        return student.getStudentID();
    }

    private Student findStudent(long studentId) {
        for (Student student : students) {
            if (student.getStudentID() == studentId) {
                return student;
            }
        }
        throw new IllegalArgumentException("Студент с номером " + studentId + " не найден");
    }

    public void giveGrade(long studentId, int grade) {
        Student student = findStudent(studentId);
        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException("Студент не учится");
        }
        student.addGrade(grade);
    }

    public void expel(long studentId) {
        Student student = findStudent(studentId);
        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException("Студент уже отчислен или выпустился");
        }
        student.setState(State.DISMISSED);
    }

    public void transferToNextCourse(long studentId) {
        Student student = findStudent(studentId);

        if (student.getState() != State.ACTIVE) {
            throw new IllegalArgumentException("Студент уже отчислен или выпустился");
        }

        if (student.average() > 2.5) {
            if (student.getCourse() == 4) {
                student.setState(State.GRADUATED);
            } else {
                student.setCourse(student.getCourse() + 1);
            }
        } else {
            System.out.println("Студент " + student.getName() + " отчислен из-за низкого среднего балла.");
            student.setState(State.DISMISSED);
        }
    }

    public void printSummary() {
        System.out.println("Сводка по университету");
        for (Student student : students) {
            student.printReport();
            System.out.println("-");
        }
    }

    public int getStudentCourse(long studentId) {
        return findStudent(studentId).getCourse();
    }

    public State getStudentState(long studentId) {
        return findStudent(studentId).getState();
    }
}