package com.block;

public class Transaction {
	
	
	private int    id;
	private String previous_Hash;
    private long   time_stamp;
    private String data;
    private String hash;
    private int size;
    private String transaction_count;
    
    public Transaction() {
    	
    }
	
	
	  public Transaction(int id, String previous_Hash, long times_tamp, String data, String hash) {
	        this.id = id;
	        this.previous_Hash = previous_Hash;
	        this.time_stamp = times_tamp;
	        this.data = data;
	        this.hash = hash;
	    }
	    
		
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPrevious_Hash() {
		return previous_Hash;
	}

	public void setPrevious_Hash(String previous_Hash) {
		this.previous_Hash = previous_Hash;
	}

	public long getTime_stamp() {
		return time_stamp;
	}

	public void setTime_stamp(long time_stamp) {
		this.time_stamp = time_stamp;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getTransaction_count() {
		return transaction_count;
	}

	public void setTransaction_count(String transaction_count) {
		this.transaction_count = transaction_count;
	}

	

  
}
