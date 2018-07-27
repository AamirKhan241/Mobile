package login_History;

import java.util.List;

public interface Login_History_DAO {
    
    boolean insert(Login_History lh);
    boolean update(Login_History lh);
    boolean delete(int serial_no);
    
    Login_History display(int serial_no);
    List<Login_History> display();
    
}
