package ru.ranepa;

public class Main {

    public static void main(String[] args) {
        // TODO: создать университет
        University university = new University();

        // TODO: зачислить 2–3 студентов и поставить оценки
        long id1 = university.enroll("Иванов Николай");
        long id2 = university.enroll("Петров Евгений");
        long id3 = university.enroll("Кашина Алиса");

        // Иванов — хорошист (средний балл > 2.5)
        university.giveGrade(id1, 5);
        university.giveGrade(id1, 4);
        university.giveGrade(id1, 5);

        // Петров — двоечник (средний балл <= 2.5)
        university.giveGrade(id2, 2);
        university.giveGrade(id2, 3);
        university.giveGrade(id2, 2);

        // Кашина — отличница, до 4 курса
        university.giveGrade(id3, 4);
        university.giveGrade(id3, 5);
        university.giveGrade(id3, 4);
        university.transferToNextCourse(id3); // 1 -> 2
        university.transferToNextCourse(id3); // 2 -> 3
        university.transferToNextCourse(id3); // 3 -> 4

        // TODO: перевести студента со средним баллом больше 2.5
        university.transferToNextCourse(id1);
        System.out.println("Иванов переведен на курс: " + university.getStudentCourse(id1));

        // TODO: перевести студента со средним баллом 2.5 или меньше
        university.transferToNextCourse(id2);

        // TODO: перевести студента с 4 курса
        university.transferToNextCourse(id3);
        System.out.println("Сидоров статус: " + university.getStudentState(id3));

        // TODO: отчислить студента и показать отказ
        university.expel(id1);
        try {
            university.transferToNextCourse(id1); // Здесь должно вылететь исключение
        } catch (IllegalArgumentException e) {
            System.out.println("Отказ: " + e.getMessage());
        }

        // TODO: [вариант N] — выполнить свой кейс, строки начинать с [вариант N]
        // TODO: напечатать сводку — в ней должна быть информация из кейса
        university.printSummary();
    }
}