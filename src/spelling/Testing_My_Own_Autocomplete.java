package spelling;

public class Testing_My_Own_Autocomplete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutoCompleteDictionaryTrie pk=new AutoCompleteDictionaryTrie();
		pk.addWord("step");
		
		
		pk.addWord("stem");
		pk.addWord("stew");
		pk.addWord("stepper");
		pk.addWord("downhill");
		
           System.out.println(pk.size());
         System.out.println(pk.predictCompletions("st",5));
         System.out.println(pk.isWord("downhil"));
	}

}
