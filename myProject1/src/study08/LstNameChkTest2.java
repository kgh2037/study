package study08;

public class LstNameChkTest2 {
	public class LstNameChkTest{
		public static void main(String[] args) {
			String str = "김";
			LstNmChk2 lstNm = new LstNmChk2();
			try {
				lstNm.setLstNm(str);
				System.out.println(str + "바보");
			} catch (InvalidNmException e ) {
				System.out.println(e.toString());
			}
		}
	}
}