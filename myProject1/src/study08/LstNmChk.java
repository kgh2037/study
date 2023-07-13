package study08;

public class LstNmChk {
	public static final String[] lstNmArr = {"김","이","박","조","최","송","허","강"};
	//return 없음/ 호출 지점에 예외 처리 강제 try-catch
	void setLstNm(String lastName) throws InvalidNmException {
		if (isLstNm(lastName)) throw new InvalidNmException();
	}
	private boolean isLstNm(String str) {
		for(int i=0; i<lstNmArr.length; i++) {
			if(lstNmArr[i].equals(str)) return false;
		}
		return true;
	}
}
