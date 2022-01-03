
public class sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "http://www.example.com/abc?page=6030.";
		String number = test.substring(test.lastIndexOf("=") + 1);
		int num = Integer.parseInt(number.substring(0, number.length()-1));
		System.out.println(num);

	}

}
