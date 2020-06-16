import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.sql.Date;
import java.sql.SQLException;

import com.FFFANS.bean.Account;
import com.FFFANS.dao.BankDAO;

public class javaDemo {

	public static void main(String[] args) throws SQLException {
		BankDAO cDao=new BankDAO();
		Account acc=new Account();
		acc.setAccountID(6052003);
		int x=cDao.getadhar(acc.getAccountID());
		    Date date=Date.valueOf(LocalDate.now());
		    System.out.println(date);
		    System.out.println(cDao.showbwtransactionBydates(date)); 
	}

}
