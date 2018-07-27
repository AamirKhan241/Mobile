package sale;

import java.util.List;

public interface Sales_Report_DAO {
    
    boolean insert(Sales_Report sr);
    boolean update(Sales_Report sr);
    boolean delete(int invoice_no);
    int getId();
    
    Sales_Report display(int invoice_no);
    List<Sales_Report> display();
    
}
