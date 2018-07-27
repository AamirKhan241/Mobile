package mobiles;

import java.util.List;

public interface Mobiles_DAO {
    
    boolean insert(Mobiles m);
    boolean update(Mobiles m);
    boolean delete(int mobile_id);
    int available(String manufacture,String model);
    int getId();
    
    Mobiles display(int mobile_id);
    Mobiles displayM(String model_no,String manufacturer);
    List<Mobiles> display();
    List<Mobiles> display(String manufacturer);
}
