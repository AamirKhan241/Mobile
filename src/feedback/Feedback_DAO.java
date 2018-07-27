package feedback;

import java.util.List;

public interface Feedback_DAO {
    
    boolean insert(Feedback f);
    boolean update(Feedback f);
    boolean delete(int serial_no);
    
    Feedback display(int serial_no);
    List<Feedback> display();
        
}
