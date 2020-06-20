import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;
import java.sql.SQLException;

import com.FFFANS.bean.Account;
import com.FFFANS.bean.Transaction;
import com.FFFANS.dao.BankDAO;
import com.FFFANS.util.DateUtil;

public class javaDemo {

	public static void main(String[] args) throws SQLException, ParseException {
		BankDAO cDao=new BankDAO();
		Account acc=new Account();
		//acc.setAccountID(6052003);
		//int x=cDao.getadhar(acc.getAccountID());
		    /*Date date=Date.valueOf(LocalDate.now());
		    System.out.println(date);
		    System.out.println(cDao.showbwtransactionBydates(date)); */
		/*Transaction t=new Transaction();
		System.out.println(t.getLast_time());
		t.setTransactionId(10100);
		System.out.println("TID now:"+t.getTransactionId());*/
		//Date date=Date.valueOf(LocalDate.now());
		/*String date="17/06/2020";
		SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date dq=formatter.parse(date);
		System.out.println((java.sql.Date)dq.getTime());*/
		/*String date="2020/06/16";
		String date1="2020/06/17";
		int accid=1062002;
		List<Transaction> l1=cDao.showbwtransactionBydates(date,date1,accid);*/
		//System.out.println(l1);
		/*DateUtil d=new DateUtil();
		d.convertStringToDate("12-04-2020", "dd-MM-yyyy");*/
		/*try {
			cDao.createTable();
			System.out.println("done");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
