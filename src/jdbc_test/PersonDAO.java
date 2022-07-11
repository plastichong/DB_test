package jdbc_test;


//data access object == DAO

import jdbc_test.common.JDBCutil;
import oracle.jdbc.proxy.annotation.Pre;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PersonDAO {

    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;

    //C.R.U.D

    //Create - 삽입
    //Read - 조회
    //Update - 수정
    //Delete - 삭제


    //자료 삽입 Create
    public void insertPerson(Person person) {

        conn = JDBCutil.getConnection();
        String sql = "INSERT INTO person(USERID,USERPW,NAME,AGE) VALUES (?, ?, ?, ?)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, person.getUserId());
            pstmt.setString(2, person.getUserPw());
            pstmt.setString(3, person.getName());
            pstmt.setInt(4, person.getAge());
            pstmt.executeUpdate(); //DB에 업데이트
            System.out.println(person.getUserId()+"삽입");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("삽입 끝");
            JDBCutil.close(conn, pstmt);
        }


    }


    //자료 조회 Read
    public ArrayList<Person> getPersonList() {
        ArrayList<Person> personlist = new ArrayList<>();

        conn = JDBCutil.getConnection();//연결

        String sql = "SELECT * FROM person";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            System.out.println("조회 시작");
            while (rs.next()) {
                Person person = new Person();
                person.setUserId(rs.getString("userid"));
                person.setUserPw(rs.getString("userpw"));
                person.setName(rs.getString("name"));
                person.setAge(rs.getInt("age"));

                personlist.add(person); //생성된 객체를 ArrayList에 저장
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("조회끝");
            JDBCutil.close(conn, pstmt, rs);
        }
        return personlist;
    }


    //자료 수정

    public void upDatePerson( Person person) {
        conn = JDBCutil.getConnection();
        String sql = "UPDATE person SET userPw = ?, name = ?, age = ?    WHERE userid = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,person.getUserPw());
            pstmt.setString(2,person.getName());
            pstmt.setInt(3,person.getAge());
            pstmt.setString(4,person.getUserId());
            System.out.println(person.getUserId()+" 수정");
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println(person.getUserId()+" 수정 끝");
            JDBCutil.close(conn,pstmt);
        }
    }


    //자료 삭제

    public void deletePerson(Person person){
        conn = JDBCutil.getConnection();
        String sql = "DELETE FROM person WHERE userId = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,person.getUserId());
            pstmt.executeUpdate();
            System.out.println(person.getUserId()+"삭제");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            System.out.println(person.getUserId()+"삭제 완료");
            JDBCutil.close(conn,pstmt);
        }

    }


    //1명 조회 (상세보기)

    public Person getPerson(String userId){
        Person person = new Person();
        conn = JDBCutil.getConnection();
        String sql = "SELECT * FROM person WHERE userId = ?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"userId");
            rs = pstmt.executeQuery();
            if (rs.next()){
                person.setUserId(rs.getString("userId"));//db에 있는 userId를 가져옴
                person.setUserPw(rs.getString("userPw"));
                person.setName(rs.getString("Name"));
                person.setAge(rs.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutil.close(conn,pstmt,rs);
        }


        return person;
    }



}
