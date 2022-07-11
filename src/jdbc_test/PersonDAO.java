package jdbc_test;


//data access object == DAO

import jdbc_test.common.JDBCutil;
import oracle.jdbc.proxy.annotation.Pre;

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
            pstmt.executeUpdate(); //DB에
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutil.close(conn,pstmt);
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
            while(rs.next()){
                Person person = new Person();
                person.setUserId(rs.getString("userid"));
                person.setUserPw(rs.getString("userpw"));
                person.setName(rs.getString("name"));
                person.setAge(rs.getInt("age"));

                personlist.add(person); //생성된 객체를 ArrayList에 저장
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutil.close(conn,pstmt,rs);
        }
        return personlist;
    }
}
