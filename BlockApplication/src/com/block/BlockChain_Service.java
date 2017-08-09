package com.block;

import java.util.ArrayList;
import java.util.List;

public class BlockChain_Service {

	private static List<Transaction> transaction = new ArrayList<Transaction>();
	
	public static List<Transaction> getChain()
	{
		//block = new ArrayList<Block>();
		
		return transaction;
	}
	
	public static Transaction getGenesisBlock() {
		
		/* Logic to calulate the first hash has to be in place
		 * SHould not be hardcoded
		 */
		String nextHash = calculateHash(1, "0", System.currentTimeMillis(), "hello");
	  
	  
        return new Transaction(1, "0", System.currentTimeMillis(), "hello", nextHash);
    
    }
	
	public static Transaction generateNextTransaction(String blockData) 
	{
		
		/*
		 * Get the block count here. If count == 0, create the first block
		 * else we will invoke the generateNextBlock()
		 */
		Transaction currentBlock;
		
		//System.out.println("sssssss1111");
		
		int blockCnt = transaction.size();
		
		//System.out.println("sssssss222"+blockCnt);
		
		if (blockCnt == 0)
		{
			
			long time_stamp = System.currentTimeMillis();
			String nextHash = calculateHash(1, "0", time_stamp, blockData);
			currentBlock = new Transaction(1, "0", time_stamp, blockData, nextHash);
		}
		
		else
		{
			
			Transaction previousBlock = getLatestTransaction();
		        
	        int nextId = previousBlock.getId() + 1;
	        
	        long nextTimestamp = System.currentTimeMillis();
	        String nextHash = calculateHash(nextId, previousBlock.getHash(), nextTimestamp, blockData);
	        currentBlock =  new Transaction(nextId, previousBlock.getHash(), nextTimestamp, blockData, nextHash);
		}
		
		transaction.add(currentBlock);
		
	    return currentBlock;
	    //add to db --> by calling DBWriteToDB
       //TODO:Rush
	   
    
	}
	
	private static String calculateHash(int id, String previous_Hash, long time_stamp, String data) {
        StringBuilder builder = new StringBuilder(id);
        builder.append(previous_Hash).append(time_stamp).append(data);
        return Sha256.getSHA_256(builder.toString());
    }
	
	public static Transaction getLatestTransaction() {
		
		/* The DBCount has to be used to fetch the latest record from the DB 
		 * 
		 */
        return transaction.get(transaction.size() - 1);
    }
}
