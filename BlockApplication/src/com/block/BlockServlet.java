package com.block;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/blockServlet")
public class BlockServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	BlockChain_Service blockService;
	
	ReadPropFile readPropFile;
	
	DBWrite dw = new DBWrite();
	
	private static List<Transaction> bl = new ArrayList<Transaction>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("sssssss");
		 
		 List<Transaction> l = dw.DBReadToDB();
		 Transaction b = new Transaction(); 
		
		System.out.println("33333"+l.size());
   	    b.setSize(l.size());
        
   	    String tc = readPropFile.readProp();
   	    b.setTransaction_count(tc);
   	    System.out.println("transaction value: " + tc);
   	    
   	    request.setAttribute("block",b);
		request.setAttribute("list", l);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	
		System.out.println("sssssss");
		
		String blockdata = request.getParameter("block_input");
		
		
		//Add the entered block data to the block chain
		//BlockService1.generateNextBlock(blockdata);
		
		Transaction b = new Transaction(); 
		
		b = blockService.generateNextTransaction(blockdata);
		
		System.out.println(blockdata);
		//Create a json object
	
     try {
    	 	
   	    	dw.DBWriteToDB(b);
   	    
   	    
   	    	doGet(request, response);
   	    	

		  } catch (Exception e) {
		      e.printStackTrace();
	      }

	
		}
}
