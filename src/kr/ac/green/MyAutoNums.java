package kr.ac.green;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class MyAutoNums {
	private Integer[] autoNums;
	//ÀÚµ¿
	public MyAutoNums() {
		autoNums = autoSelect(6);
	}
	public MyAutoNums(Integer... autoNums) {
		Arrays.sort(autoNums);
		this.autoNums = autoNums;
	}
	protected Integer[] autoSelect(int drawAutoNum) {
		Random r = new Random();
		HashSet<Integer> set = new HashSet<Integer>();

		while(set.size() < drawAutoNum) {
			set.add(r.nextInt(45) + 1);
		}
		Integer[] autoNums = set.toArray(new Integer[0]);
		Arrays.sort(autoNums, 0 , 6);
		return autoNums;
	}
	public Integer[] getNums() {
		return autoNums;
	}
	public void setNums(Integer... autoNums) {
		this.autoNums = autoNums;
	}
	@Override
	public String toString() {
		return Arrays.toString(autoNums);
	}
}
