package jdbc_test.common;

import jdbc_test.PersonDAO;
import jdbc_test.Person;
import java.util.ArrayList;

public class PersonMain {
    public static void main(String[] args) {

        ArrayList<Person> personList = new ArrayList<Person>();
        PersonDAO dao = new PersonDAO();
        //삽입

//        Person p1 = new Person();
//        p1.setUserId("today");
//        p1.setUserPw("today11");
//        p1.setName("오늘");
//        p1.setAge(28);
//
//        dao.insertPerson(p1);
//




        //조회
        personList = dao.getPersonList();

        for (int i = 0; i <personList.size() ; i++) {
            Person person = personList.get(i);
            System.out.println("아이디 : "+person.getUserId());
            System.out.println("비밀번호 : "+person.getUserPw());
            System.out.println("이름 : "+person.getName());
            System.out.println("나이 : "+person.getAge()+"\n");
        }


    }
}
