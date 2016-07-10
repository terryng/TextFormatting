import java.util.ArrayList;
import java.util.List;

public class JustifyText {

	public static List<String> justifyText (String[] array, int n){
		ArrayList<String> aL = new ArrayList<String>();
		ArrayList<String> returnAl = new ArrayList<String>();
		int i = 0;
		StringBuilder sb = new StringBuilder("");
		int combinedLength = 0;
		while (true){
			int length = array[i].length();
			if (combinedLength + length <= n){
				aL.add(array[i]);
				combinedLength = combinedLength + 1 + length;
				i++;
			}
			else {
				int numUnderscores = n-(combinedLength-aL.size());
				int numSpaces = aL.size()-1;
				int spaceSize = numUnderscores/numSpaces;
				int extraSpace = numUnderscores % numSpaces;
				for (int j = 0; j < aL.size(); j++){
					sb.append(aL.get(j));
					if (j != aL.size() - 1){
						for (int m = 0; m < spaceSize; m++){
							sb.append(" ");
						}
						if (extraSpace > 0){
							sb.append(" ");
							extraSpace--;
						}
					}
				}	
				returnAl.add(sb.toString());
				aL = new ArrayList<String>();
				combinedLength = 0;
				sb = new StringBuilder("");
			}

			if (i == array.length){


				for (int j = 0; j < aL.size(); j++){
					sb.append(aL.get(j));
					if (j != aL.size()-1){
						sb.append(" ");
					}
				}
				if (sb.toString().length() < n){
					int len = sb.toString().length();
					for (int j = 0; j < n - len; j++){
						sb.append(" ");
					}
				}
				returnAl.add(sb.toString());
				return returnAl;
			}


		}


	}

	public static void main (String[] args){
		List<String> returnList = justifyText (new String[]{"the","quick","brown","fox","jumped","over","the","lazy","dog"},11);
		for (String s : returnList){
			System.out.println(s);
		}
	}

}
