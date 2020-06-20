package com.FFFANS.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.FFFANS.bean.Account;
import com.FFFANS.bean.BankCustomer;
import com.FFFANS.bean.Transaction;
import com.FFFANS.service.BankService;



public class BankController extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
		String action=req.getParameter("action");
		System.out.println(action);
		BankService bs=new BankService();
		if(action.equalsIgnoreCase("Logout")) {
			HttpSession session=req.getSession(true);
			session.invalidate();
			res.sendRedirect("BankexecLogin.jsp");
		}
		if(action.equalsIgnoreCase("showCustomer")) {
			try {
				List<BankCustomer> lst=bs.showCustomers();
				RequestDispatcher rd= req.getRequestDispatcher("customerStatus.jsp");
				req.setAttribute("listcust", lst);
				rd.forward(req, res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(action.equalsIgnoreCase("showAccount")) {
			try {
				List<Account> lst=bs.showAllAccounts();
				RequestDispatcher rd= req.getRequestDispatcher("AccountStatus.jsp");
				req.setAttribute("listcust", lst);
				rd.forward(req, res);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(action.equalsIgnoreCase("regcus")) {
			HttpSession session=req.getSession(true);
			res.sendRedirect("Registration.jsp");
		}
		if(action.equalsIgnoreCase("home")) {
			HttpSession session=req.getSession(true);
			res.sendRedirect("home.jsp");
		}
		if(action.equalsIgnoreCase("delcus")) {
			HttpSession session=req.getSession(true);
			res.sendRedirect("deleteCustomer.jsp");
		}
		if(action.equalsIgnoreCase("searAus")) {
			HttpSession session=req.getSession(true);
			res.sendRedirect("AccountSearch.jsp");
		}
		if(action.equalsIgnoreCase("delAcc")) {
			HttpSession session=req.getSession(true);
			res.sendRedirect("deleteAccount.jsp");
		}
		if(action.equalsIgnoreCase("searCus")) {
			HttpSession session=req.getSession(true);
			res.sendRedirect("CustomerSearch.jsp");
		}
		if(action.equalsIgnoreCase("creaus")) {
			HttpSession session=req.getSession(true);
			res.sendRedirect("createAccount.jsp");
		}
		
		if(action.equalsIgnoreCase("getTrans")) {
			res.sendRedirect("showTransaction.jsp");
			/*try {
				//List<BankCustomer> lst=bs.showCustomers();
				//RequestDispatcher rd= req.getRequestDispatcher("customerStatus.jsp");
				//req.setAttribute("listcust", lst);
				//rd.forward(req, res);
				req.getRequestDispatcher("showTransaction");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
		
		
		
		
		
	}
	
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
		PrintWriter pw=res.getWriter();
		BankService bs=new BankService();
		BankCustomer cst=new BankCustomer();
		String action=req.getParameter("action");

		if(action.equalsIgnoreCase("Register")) {
			cst.setCustomer_name(req.getParameter("Cname"));
			cst.setAccount_type(req.getParameter("acctype"));
			cst.setCustomerAdhar(Integer.parseInt(req.getParameter("adhar")));
			cst.setAge(Integer.parseInt(req.getParameter("age")));
			cst.setAddress(req.getParameter("address"));
			cst.setState(req.getParameter("state"));
			cst.setCity(req.getParameter("city"));
			System.out.println("Customer Details: \n "+cst);
			try {
				boolean flag=bs.addCustomer(cst);					
			if(flag) {
			pw.print("Record saved Successfully \n Account Id is: " +cst.getAccountId() + "Customer Id is : "+cst.getCustomerId());
		   RequestDispatcher rd= req.getRequestDispatcher("Registration.jsp");
		   String succ_msg="User Registered Successful with Customer Id: "+cst.getCustomerId();
		    req.setAttribute("succ_msg",succ_msg);
			rd.forward(req,res);
			}
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
	/*	if(action.equalsIgnoreCase("Login")) {
			String usrname=req.getParameter("username");
			String pass=req.getParameter("password");
			try {
				boolean flag=bs.verifyCustomer(usrname,pass);	
				
			if(flag) {
				
			pw.print("Login Successful "+ usrname);
			
			HttpSession sessin=req.getSession(true);
			sessin.setMaxInactiveInterval(5*60);
			sessin.setAttribute("name", usrname);
			res.sendRedirect("home.jsp");
			
			
		}
			else {pw.println("Sorry,Username Password not correct try again");
			
			}
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		*/

		if(action.equalsIgnoreCase("execLogin")) {
			String usrname=req.getParameter("username");
			String pass=req.getParameter("password");
			try {
			
				boolean flag=bs.verifyexecUser(usrname,pass);	
				
			if(flag) {
				
			pw.print("Login Successful "+ usrname);
			
			HttpSession sessin=req.getSession(true);
			sessin.setMaxInactiveInterval(5*60);
			sessin.setAttribute("name", usrname);
			res.sendRedirect("home.jsp");
			
			
		}
			else {
			 RequestDispatcher rd= req.getRequestDispatcher("BankexecLogin.jsp");
			 String errormsg="Sorry,Username Password not correct try again";
			req.setAttribute("ermsg",errormsg);
			rd.forward(req, res);
			
			}
			}
			catch(ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(action.equalsIgnoreCase("EditCustomer")) {
			String updateopt=req.getParameter("search");
			System.out.println(updateopt);
			try {
			if(updateopt.equalsIgnoreCase("cadhar")) {
				int updateopt1=Integer.parseInt(req.getParameter("adhar"));
				System.out.println(updateopt1);
				cst=bs.searchCustomerByAdhar(updateopt1);
				if(cst!=null) {
				RequestDispatcher rd= req.getRequestDispatcher("updateCustomer.jsp");
				req.setAttribute("class", cst);
				rd.forward(req, res);}
				else {
					RequestDispatcher rd= req.getRequestDispatcher("updateCustomer.jsp");
					String smsg="No data found  ";
					req.setAttribute("upmsg", smsg);
					rd.forward(req, res);
				}
			}
			else if(updateopt.equalsIgnoreCase("cid")){
				int updateopt2=Integer.parseInt(req.getParameter("CusID"));
				System.out.println(updateopt2);
				cst=bs.searchCustomerByCusID(updateopt2);
				if(cst!=null) {
				RequestDispatcher rd= req.getRequestDispatcher("updateCustomer.jsp");
				req.setAttribute("class", cst);
				rd.forward(req, res);}
				else {RequestDispatcher rd= req.getRequestDispatcher("updateCustomer.jsp");
				String smsg="No data found  ";
				req.setAttribute("upmsg", smsg);
				rd.forward(req, res);}
			}
			else {
				res.sendRedirect("updateCustomer.jsp");
			}
			}
			catch( SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	if(action.equalsIgnoreCase("UpdateCustomer")) {
		System.out.println(cst);
		cst.setCustomerId(Integer.parseInt(req.getParameter("vbn")));
		System.out.println("given idd"+cst.getCustomerId());
		cst.setCustomer_name(req.getParameter("Cname"));
		cst.setAddress(req.getParameter("Caddress"));
		int x=Integer.parseInt(req.getParameter("Cage"));
		System.out.println(x);
		cst.setAge(x);
		try {
			bs.updateUser(cst);
			RequestDispatcher rd= req.getRequestDispatcher("updateCustomer.jsp");
			String smsg="User updated successfully "+cst.getCustomerId();
			req.setAttribute("upmsg", smsg);
			rd.forward(req, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	if(action.equalsIgnoreCase("createAcc")) {
		Account acc=new Account(Integer.parseInt(req.getParameter("CID")),req.getParameter("AccType"),Integer.parseInt(req.getParameter("amount")));
		System.out.println(acc);
		try {
			int x=bs.getAdhar(acc.getCustomerID());
			if(x==0) { System.out.println("Enter Correct CID");
			RequestDispatcher rd= req.getRequestDispatcher("createAccount.jsp");
			String suucc="Enter Correct Customer  id";
			req.setAttribute("sumsg", suucc);
			rd.forward(req, res);
			}
			else {acc.setCustomerAdhar(x);
			System.out.println(acc);
			boolean flag=bs.createAccount(acc);
			if(flag) {System.out.println("Succesfully Executed");
			RequestDispatcher rd= req.getRequestDispatcher("createAccount.jsp");
			String suucc="Account created successfully "+acc.getAccountID();
			req.setAttribute("sumsg", suucc);
			rd.forward(req, res);
			}
		}} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	System.out.println("searched:"+action);
	if(action.equalsIgnoreCase("searchCust")) {
		System.out.println("got IT");
		cst=null;
		int updateopt=Integer.parseInt(req.getParameter("CID"));
		System.out.println("Value of search is: "+updateopt);
		try {
			cst=bs.searchCustomerByCusID(updateopt);
			if(cst!=null) {
				System.out.println("executed");
			RequestDispatcher rd= req.getRequestDispatcher("deleteCustomer.jsp");
			req.setAttribute("class", cst);
			rd.forward(req, res);	}
			else {
				RequestDispatcher rd= req.getRequestDispatcher("deleteCustomer.jsp");
				String rsms="Account not found, Try Again";
				req.setAttribute("sumsg", rsms);
				rd.forward(req, res);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	if(action.equalsIgnoreCase("deleteCust")) {
		int z=Integer.parseInt(req.getParameter("vbn"));
		try {
			bs.deleteCustomer(z);
			System.out.println("success delete: "+z);
			RequestDispatcher rd= req.getRequestDispatcher("deleteCustomer.jsp");
			String rsms="Customer Account deleted having id:  "+z;
			req.setAttribute("sumsg", rsms);
			rd.forward(req, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	if(action.equalsIgnoreCase("searchAcc")) {
		System.out.println("got IT");
		Account acc=null;
		int updateopt=Integer.parseInt(req.getParameter("Acid"));
		System.out.println("Value of search is: "+updateopt);
		try {
			acc=bs.searchAccountByAccID(updateopt);
			System.out.println(acc);
			if(acc!=null) {
				System.out.println("executed");
			if(req.getParameter("searchvbn").equalsIgnoreCase("deposit")) {
				RequestDispatcher rd= req.getRequestDispatcher("depositmoney.jsp");
				req.setAttribute("class", acc);
				rd.forward(req, res);
			}
			if(req.getParameter("searchvbn").equalsIgnoreCase("withdraw")) {
				RequestDispatcher rd= req.getRequestDispatcher("withdrawmoney.jsp");
				req.setAttribute("class", acc);
				rd.forward(req, res);
			}
			if(req.getParameter("searchvbn").equalsIgnoreCase("searchAcc1")) {
				RequestDispatcher rd= req.getRequestDispatcher("AccountSearch.jsp");
				req.setAttribute("class", acc);
				rd.forward(req, res);
			}
			if(req.getParameter("searchvbn").equalsIgnoreCase("delete")) {
			RequestDispatcher rd= req.getRequestDispatcher("deleteAccount.jsp");
			req.setAttribute("class", acc);
			rd.forward(req, res);	}}
			else {
				if(req.getParameter("searchvbn").equalsIgnoreCase("delete")) {
				RequestDispatcher rd= req.getRequestDispatcher("deleteAccount.jsp");
				String rsms="Account not found, Try Again";
				req.setAttribute("sumsg", rsms);
				rd.forward(req, res);}
				if(req.getParameter("searchvbn").equalsIgnoreCase("withdraw")) {
					RequestDispatcher rd= req.getRequestDispatcher("withdrawmoney.jsp");
					String rsms="Account not found, Try Again";
					req.setAttribute("sumsg", rsms);
					rd.forward(req, res);}
				if(req.getParameter("searchvbn").equalsIgnoreCase("deposit")) {
					RequestDispatcher rd= req.getRequestDispatcher("depositmoney.jsp");
					String rsms="Account not found, Try Again";
					req.setAttribute("sumsg", rsms);
					rd.forward(req, res);}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
	
	if(action.equalsIgnoreCase("deleteAcc")) {
		int z=Integer.parseInt(req.getParameter("vbn"));
		try {
			bs.deleteAccount(z);
			System.out.println("success delete: "+z);
			RequestDispatcher rd= req.getRequestDispatcher("deleteAccount.jsp");
			String rsms="Customer Account deleted having id:  "+z;
			req.setAttribute("sumsg", rsms);
			rd.forward(req, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	if(action.equalsIgnoreCase("depBalance")) {
		int aid=Integer.parseInt(req.getParameter("vbn"));
		int upbal=Integer.parseInt(req.getParameter("DeBal"));
		Transaction tsa=new Transaction();
		try {
			Account acc=bs.depositBalance(aid, upbal);
			tsa.setTransDesc("Deposit");
			bs.insertintotransaction(tsa, acc, upbal);
			RequestDispatcher rd= req.getRequestDispatcher("depositmoney.jsp");
			req.setAttribute("setdep", acc);
			String sbal=""+upbal;
			req.setAttribute("beBal", sbal);
			rd.forward(req, res);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(" vbn is: "+z+" Deal is;" +y);
	}
	
	
	if(action.equalsIgnoreCase("witBalance")) {
		int aid=Integer.parseInt(req.getParameter("vbn"));
		int upbal=Integer.parseInt(req.getParameter("WeBal"));
		Transaction tsa=new Transaction();
		try {
			Account acc=bs.withdrawBalance(aid, upbal);
			System.out.println("Balnce is low"+acc.getAmount());
			if(acc.getAmount()<0) {
				RequestDispatcher rd= req.getRequestDispatcher("withdrawmoney.jsp");
				String rsms="Insufficient Balance in Account,please try again "+acc.getAccountID();
				req.setAttribute("sumsg", rsms);
				rd.forward(req, res);
			}
			else {
				tsa.setTransDesc("Withdraw");
				bs.insertintotransaction(tsa, acc, upbal);
			RequestDispatcher rd= req.getRequestDispatcher("withdrawmoney.jsp");
			req.setAttribute("setdep", acc);
			String sbal=""+upbal;
			req.setAttribute("witBal", sbal);
			rd.forward(req, res);}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(" vbn is: "+z+" Deal is;" +y);
	}
	
	if(action.equalsIgnoreCase("transfer")) {
		int Source=Integer.parseInt(req.getParameter("Sacc")) ;
		int dest=Integer.parseInt(req.getParameter("Tacc"));
		int amo=Integer.parseInt(req.getParameter("Tamo"));
		Account acc;
		Transaction tsa=new Transaction();
		try {
			acc = bs.withdrawBalance(Source, amo);
			if(acc.getAmount()==0) {
				RequestDispatcher rd= req.getRequestDispatcher("transfermoney.jsp");
				String rsms="Insufficient Balance in Account,please try again "+acc.getAccountID();
				req.setAttribute("sumsg", rsms);
				rd.forward(req, res);
			}
			else {
				
				Account acc1=bs.depositBalance(dest, amo);
				tsa.setTransDesc("Transfer");
				tsa.setSourceAccountType(acc.getAccount_type());
				tsa.setTargetAccountType(acc1.getAccount_type());
				tsa.setSoureAccountId(acc.getAccountID());
				tsa.setTargetAccountId(acc1.getAccountID());
				
			RequestDispatcher rd= req.getRequestDispatcher("transfermoney.jsp");
			
			String sbal="Transfer Done" ;
			req.setAttribute("transBal", sbal);
			req.setAttribute("acc", acc);
			req.setAttribute("acc1", acc1);
			req.setAttribute("acc2", tsa);
			String rsms="Transfer Successfully completed of amount "+amo;
			req.setAttribute("sumsg", rsms);
			rd.forward(req, res);}
			
		}
	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	if(action.equalsIgnoreCase("transdetail")) {
		int acid=Integer.parseInt(req.getParameter("ais"));
		boolean flag=false;
		try {
			flag=bs.verifyAccountByAccID(acid);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(flag) {
		if(req.getParameter("trans").equalsIgnoreCase("nTransac"))
			{int num=Integer.parseInt(req.getParameter("numtrans"));
			try {
				List<Transaction> lst=bs.showbwtransactionBycount(acid,num);
				System.out.println("Found id is:"+lst.get(0).getTargetAccountId());
				
				if(lst!=null){
					
					System.out.println(lst.get(0));
					RequestDispatcher rd= req.getRequestDispatcher("showTransaction.jsp");
					req.setAttribute("listcust", lst);
					rd.forward(req, res);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else if(req.getParameter("trans").equalsIgnoreCase("rangeTrans")) {
			
			String sdate=req.getParameter("sdate");
			String edate=req.getParameter("edate");
			try {
				List<Transaction> lst=bs.showbwtransactionBydates(sdate, edate, acid);
				System.out.println(lst.get(0));
				RequestDispatcher rd= req.getRequestDispatcher("showTransaction.jsp");
				req.setAttribute("listcust", lst);
				rd.forward(req, res);
			} catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		else {
			RequestDispatcher rd= req.getRequestDispatcher("showTransaction.jsp");
			String msgs="Account id not find";
			req.setAttribute("msgs", msgs);
			rd.forward(req, res);
		}
		
	}
	
	if(action.equalsIgnoreCase("SearchCustomer")) {
		String updateopt=req.getParameter("search");
		System.out.println(updateopt);
		try {
		if(updateopt.equalsIgnoreCase("cadhar")) {
			int updateopt1=Integer.parseInt(req.getParameter("adhar"));
			System.out.println(updateopt1);
			
			List<Integer> l1=bs.showAccountsByAdharId(updateopt1);
			if(l1 !=null) {
			RequestDispatcher rd= req.getRequestDispatcher("CustomerSearch.jsp");
			req.setAttribute("class", l1);
			rd.forward(req, res);
		}
			else {RequestDispatcher rd= req.getRequestDispatcher("CustomerSearch.jsp");
			String geterm="No Accounts Found";
			req.setAttribute("geterm", geterm);
			rd.forward(req, res);}	
		}
		else if(updateopt.equalsIgnoreCase("cid")){
			int updateopt2=Integer.parseInt(req.getParameter("CusID"));
			System.out.println(updateopt2);
			List<Integer> l1=bs.showAccountsByCustomerId(updateopt2);
			cst=bs.searchCustomerByCusID(updateopt2);
			RequestDispatcher rd= req.getRequestDispatcher("CustomerSearch.jsp");
			req.setAttribute("class", l1);
			rd.forward(req, res);
		}
		else {
			RequestDispatcher rd= req.getRequestDispatcher("CustomerSearch.jsp");
			String geterm="No Accounts Found";
			req.setAttribute("geterm", geterm);
			rd.forward(req, res);
			
		}
		}
		catch( SQLException e) {
			e.printStackTrace();
		}
	}
	
	if(action.equalsIgnoreCase("secc")) {
		int id=Integer.parseInt(req.getParameter("accid"));
		RequestDispatcher rd= req.getRequestDispatcher("AccountSearch.jsp");
		List<Integer> xid=new ArrayList<Integer>();
		xid.add(id);
		req.setAttribute("sout", xid);
		rd.forward(req, res);
	}
	
	
}
}
