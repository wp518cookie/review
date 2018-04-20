package test.steamtest;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ping.wu on 2018/4/19.
 */
public class SteamTest {

    public static List<Student> generateStudent() {
        return new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };
    }

    @Test
    public void testFilter() {
        List<Integer> nums = new ArrayList();
        int j = 2;
        while (j-- > 0) {
            for (int i = 0; i < 10; i++) {
                nums.add(i);
            }
        }
        List<Integer> result = nums.stream().filter(num -> num % 2 == 0).distinct().sorted((s1, s2) -> s2 - s1).
        limit(2).skip(1).collect(Collectors.toList());
        System.out.println(Arrays.toString(result.toArray()));
    }

    @Test
    public void testMap() {
        List<Student> students = generateStudent();
//        List<String> result = students.stream()
//                .filter(student -> "武汉大学".equals(student.getSchool()))
//                .map(Student::getName).collect(Collectors.toList());
        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .mapToInt(Student::getAge).sum();
        System.out.println(totalAge);
    }

    @Test
    public void testMatch() {
        List<Student> students = generateStudent();
        boolean result = students.stream().anyMatch(student -> student.getGrade() > 4);
        System.out.println(result);
    }

    @Test
    public void testMap1() {
        List<Student> students = generateStudent();
        List<Person> result = students.stream().map(student -> new Person(student.getName(), student.getId())).collect(Collectors.toList());
        for (Person person : result) {
            System.out.println(person);
        }
    }
}
