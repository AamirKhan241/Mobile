package profile;

import java.util.List;

public interface Profile_DAO {
    
    boolean insert(Profile p);
    boolean update(Profile p);
    boolean delete(int user_id);
    int count();
    
    Profile display(int user_id);
    List<Profile> display();
    
}
