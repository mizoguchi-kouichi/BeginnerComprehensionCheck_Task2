package com.kouichi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    List<Student> studentList = new ArrayList<>();
    String studentName;
    int studentScore;
    Scanner scanner = new Scanner(System.in);
    int ProcessingNumber = 0;

    while (ProcessingNumber != 6) {

      System.out.print(
          "\r\n1. 学生を追加\r\n2. 学生を削除\r\n3. 点数を更新\r\n4. 平均点を計算\r\n5. 全学生の情報を表示\r\n6. 終了\r\n選択してください:");
      ProcessingNumber = scanner.nextInt();

      switch (ProcessingNumber) {
        case 1:
          System.out.print("\r\n学生の名前を入力してください:");
          studentName = scanner.next();
          System.out.print(studentName + "の点数を入力してください:");
          studentScore = scanner.nextInt();
          Student student = new Student(studentName, studentScore);
          studentList.add(student);
          break;
        case 2:
          System.out.print("\r\n削除する学生の名前を入力してください:");
          String deleteStudentName = scanner.next();
          studentList.removeIf(student1 -> student1.getName().equals(deleteStudentName));
          break;
        case 3:
          System.out.print("\r\n点数を変更する学生の名前を教えてください:");
          String SearchStudent = scanner.next();

          studentList.stream()
              .filter(student1 -> student1.getName().equals(SearchStudent))
              .forEach(student1 -> System.out.println(
                  "現在は" + student1.getName() + "の点数は" + student1.getScore() + "点です。"));

          System.out.print("\r\n変更する点数を入力してください：");
          int UpdateScore = scanner.nextInt();

          studentList.stream()
              .filter(student1 -> student1.getName().equals(SearchStudent))
              .forEach(student1 -> student1.setScore(UpdateScore));

          studentList.stream()
              .filter(student1 -> student1.getName().equals(SearchStudent))
              .forEach(student1 -> System.out.println(
                  student1.getName() + "の点数を" + student1.getScore() + "に更新しました。"));

          break;
        case 4:
          int totalScore = studentList.stream()
              .mapToInt(Student::getScore)
              .sum();

          int averageScore = totalScore / studentList.size();

          System.out.println("平均点:" + averageScore + "点");
          break;
        case 5:
          System.out.println("\r\n学生一覧");
          studentList.stream()
              .forEach(student1 -> System.out.println(
                  student1.getName() + ": " + student1.getScore() + "点"));
          break;
        case 6:
          System.out.print("\r\nプログラムを終了します。");
          break;
      }
    }
  }
}