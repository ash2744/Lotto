package kr.ac.green;

public class LottoNums extends MyAutoNums{
	public static final int BONUS = 6;

	public LottoNums() {
		setNums(autoSelect(7));
	}
	public LottoNums(Integer... nums) {
		super(nums);
	}
	public Integer getBonusNum() {
		return getNums()[BONUS];
	}
	/*@Override
	public String toString() {
		return super.toString() + "������ ��ȣ�� ���ʽ� ��ȣ�Դϴ�.";
	}*/
}

