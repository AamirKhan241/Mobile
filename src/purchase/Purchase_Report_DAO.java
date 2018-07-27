package purchase;

import java.util.List;

public interface Purchase_Report_DAO {
    
    boolean insert(Purchase_Report pr);
    boolean update(Purchase_Report pr);
    boolean delete(int purchase_note);
    int getId();
    
    Purchase_Report display(int purchase_note);
    List<Purchase_Report> display();
    
}
