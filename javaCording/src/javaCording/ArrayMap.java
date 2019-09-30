package javaCording;

public class ArrayMap {


	public void put(String key, String value) throws Exception{

		while (next>=10){

			StringBuilder keyBuilder = new StringBuilder();
			StringBuilder valueBuilder = new StringBuilder();

			keyBuilder[next] = key;
			valueBuilder[next] = value;

			for(int i = 0; i<next; i++){
				if (valueBuilder[next] == valueBuilder[i]){
					valueBuilder[i] == value;
				}
				else {
					continue;
				}
				next++;
			}
		}
		
	}
}