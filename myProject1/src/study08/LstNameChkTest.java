package study08;

public class LstNameChkTest{
	public static void main(String[] args) {
		String str = "간";
		LstNmChk lstNm = new LstNmChk();
		try {
			lstNm.setLstNm(str);
			System.out.println(str + "은 올바른 성입니다.");
		} catch (InvalidNmException e ) {
			System.out.println(e.toString());
		}
	}
}