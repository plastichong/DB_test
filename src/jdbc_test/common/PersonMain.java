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
//        p1.setUserId("SKY");
//        p1.setUserPw("SKY11");
//        p1.setName("하늘");
//        p1.setAge(22);
//
//        dao.insertPerson(p1);


        //자료 수정
//        Person p2 = new Person();
//        p2.setUserId("SKY");
//        p2.setUserPw("스카이");
//        p2.setAge(50);
//        p2.setName("가을하늘");
//
//        dao.upDatePerson(p2);



//        자료 삭제
//        Person delete1= new Person();
//        delete1.setUserId("SKY");
//
//        dao.deletePerson(delete1);


        //조회
//        personList = dao.getPersonList();
//
//        for (int i = 0; i <personList.size() ; i++) {
//            Person person = personList.get(i);
//            System.out.println("아이디 : "+person.getUserId());
//            System.out.println("비밀번호 : "+person.getUserPw());
//            System.out.println("이름 : "+person.getName());
//            System.out.println("나이 : "+person.getAge()+"\n");
//        }


        //1명 조회

        Person select1 = dao.getPerson("CLOUD");
        System.out.println(select1);
        System.out.println("아이디 : "+select1.getUserId());
        System.out.println("비밀번호 : " + select1.getUserPw());
        System.out.println("이름 : " + select1.getName());
        System.out.println("나이 : " + select1.getAge() + "\n");







    }
}
