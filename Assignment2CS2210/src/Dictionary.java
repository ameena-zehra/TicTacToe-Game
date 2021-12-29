import java.util.LinkedList;

public class Dictionary implements DictionaryADT{
	
	private LinkedList<Record>[] Table; // Table initialized in the constructor

	/**
	* Constructor
	* returns an empty dictionary of the specified size
	* @param int size is used to specify the size of the Table
	*/
	@SuppressWarnings("unchecked")
	public Dictionary(int size) {
		Table  = new LinkedList[size];
	}
	
	
	/**
	* Public Insert method
	* inserts the given record in the dictionary
	* throws dictionary exception if pair.getConfig() is already in the dictionary
	* implements the dictionary using a hash table with separate chaining
	* uses the hash private helper function to see if the insertion produces a collision
	* if collision is produced returns 1
	* else returns 0
	* @param Record pair is the record object given to insert into the dictionary
	* @return int returns 1 or 0 depending on if a collision is produced
	*/
	public int insert(Record pair) throws DictionaryException{
		int index = h(pair.getConfig());
		LinkedList<Record> listatindex = Table[index];
		if ((listatindex==null)||(listatindex.isEmpty()==true)) {
			LinkedList<Record> newlist = new LinkedList<Record>();
			newlist.addFirst(pair);
			Table[index] = newlist;
			return 0;
		}
	
		else {
			int i = 0;
			Record nodesintheinnerlist = (Record) listatindex.get(i);
			while ((i<listatindex.size())&&(nodesintheinnerlist!=null)) {
				nodesintheinnerlist = (Record) listatindex.get(i);
				if ((nodesintheinnerlist.getConfig().equals(pair.getConfig()))){
					throw new DictionaryException();
				}
				i++;
			}
			listatindex.add(pair);
			Table[index] = listatindex;
			return 1;
		}
	}
	
	/**
	* Private hash function
	* uses horners law to return the index of a given string based on the ASCII values of its characters 
	* @param String input provided
	* @return int score of the String based on the values of its characters
	*/
	private int h(String s) {
		int x = 33; 
		int val =(int)s.charAt(0);
		for(int i=1; i<s.length(); i++) {
			val = ((val*x + ((int)s.charAt(i)) )% Table.length);
		}
		return val;
	}
	
	
	/**
	* Public Remove method
	* removes the entry with the given config from the dictionary
	* throws a dictionary exception if the configuration is not in the dictionary
	* @param String configuration to remove
	*/
    public void remove(String config) throws DictionaryException{
    	int index = h(config);
    	LinkedList<Record> listatindex = Table[index];
    	if (listatindex!=null) {
			int i =0;
			Record nodesintheinnerlist = (Record) listatindex.get(i);
			while ((nodesintheinnerlist!=null)&&(nodesintheinnerlist.getConfig().equals(config)==false)) {
				nodesintheinnerlist = (Record) listatindex.get(i);
				i++;
			}
			if (nodesintheinnerlist==null){
				throw new DictionaryException();
			}
			else {
				listatindex.remove(i);
				Table[index] = listatindex;
			}
			
    	}
    	else {
    		throw new DictionaryException();
    	}  	
    }
    
    /**
	* Public getter method
	* returns the score stored in the dictionary or -1 if the configuration is not in the dictionary
	* @param String config input trying to calculate the score for
	* @return the score in the dictionary  or -1 if the configurations not in the dictionary
	*/
    public int get(String config) {
    	int index = h(config);
    	LinkedList<Record> listatindex = Table[index];
    	if (listatindex!=null) {
			int i =0;
			Record nodesintheinnerlist = (Record) listatindex.get(i);
			while ((i<listatindex.size())&&(nodesintheinnerlist!=null)&&(nodesintheinnerlist.getConfig().equals(config)==false)) {
				nodesintheinnerlist = (Record) listatindex.get(i);
				i++;
			}
			if (nodesintheinnerlist==null){
				System.out.println(nodesintheinnerlist);
				return -1;
			}
			return nodesintheinnerlist.getScore();
    	}
    	return -1;
    }
    
    /**
	* Public getter method
	* @return the number of objects stored in the dictionary
	*/
    public int numElements() {
    	int numElements=0;
    	for (int i=0; i<Table.length;i++) {
    		if (Table[i]!=null) {
    			LinkedList<Record> listatindex = Table[i];
    			numElements+=listatindex.size();
    		}
    	}
    	return numElements;
    }

}
