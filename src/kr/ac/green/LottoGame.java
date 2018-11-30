package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class LottoGame extends JFrame {

	public static final Dimension size = new Dimension(200, 30);
	private MyAutoNums[] autoNums;
	// private MyManualNum[] manualNums;
	private int drawAutoNum;
	private JPanel pnlC;
	private JPanel[] pnlAuto;
	// private JPanel pnlManual;
	private JLabel lblAutoNums;
	private JButton btnGoal;
	private LottoNums goal;
	private LottoGame shoResult;
	private JPanel pnlS;// 확인버튼패널
	
	
	List<Integer> myList;
	//int no = 0;
	String[] result; 
	
	public LottoGame() {
		super("LottoGame");
		System.out.println(drawAutoNum);
		howManyPlay();
		setGameDisplay();
		getGoal();
		showResult();
		addListeners();
	}

	public int getDrawAutoNum() {
		return drawAutoNum;
	}

	public void setDrawAutoNum(int drawAutoNum) {
		this.drawAutoNum = drawAutoNum;
	}

	private void howManyPlay() {
		setVisible(false);
		new HowManyPlay(this);

		autoNums = new MyAutoNums[drawAutoNum];
		for (int idx = 0; idx < autoNums.length; idx++) {
			autoNums[idx] = new MyAutoNums();
		}

	}

	private void setGameDisplay() {
		pnlC = new JPanel(new GridLayout(0, 1));

		pnlAuto = new JPanel[drawAutoNum];
		for (int idx = 0; idx < pnlAuto.length; idx++) {

			pnlAuto[idx] = new JPanel();
			lblAutoNums = new JLabel(String.valueOf(autoNums[idx]));
			lblAutoNums.setFont(new Font(Font.DIALOG, Font.BOLD, 50));

			pnlAuto[idx].add(lblAutoNums);
		}
		for (JPanel pnl : pnlAuto) {

			pnl.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1),
					"자동번호"));
			pnlC.add(pnl);
		}
		pnlS = new JPanel(new BorderLayout());
		btnGoal = new JButton("결과확인");
		pnlS.add(btnGoal);
		pnlC.add(pnlS);
		add(pnlC, BorderLayout.CENTER);

		pack();
		// setSize(500,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	public LottoNums getGoal() {
		goal = new LottoNums();
		return goal;
	}

	public void  showResult() {
		System.out.println("당첨번호는" + goal);

		Integer[] excBonus = Arrays.copyOfRange(goal.getNums(), 0,
				LottoNums.BONUS);

		List<Integer> goalList = new Vector<Integer>(Arrays.asList(excBonus));
		int no = 0;
		result = new String[drawAutoNum];
		//String result = "";
		for (MyAutoNums temp : autoNums) {
			myList = new Vector<Integer>(Arrays.asList(temp.getNums()));
			myList.retainAll(goalList);
			int count = myList.size();
			int rank = 0;

			switch (count) {
			case 6:
				rank = 1;
				break;
			case 5:
				// 5개 맞을경우 보너스 번호 비교
				int indexOfBonus = Arrays.binarySearch(temp.getNums(),
						goal.getBonusNum());
				if (indexOfBonus >= 0) {
					rank = 2;
				} else {
					rank = 3;
				}
				break;

			case 4:
				rank = 4;
				break;
			case 3:
				rank = 5;
				break;
			}

			if (rank == 0) {
				System.out.println(result.length);
				result[no] = "꽝";
			} else {
				result[no] = rank + "등";
			}
			
			System.out.println(no + "회 게임 결과: " + result[no]);
			System.out.println("\t일치번호 ->" + myList);
			no++;
		}
	}
	public List<Integer> getMyList (){
		return myList;
	}
	public String getResult(int idx) {
		return result[idx];
	}
	public String getResult(String idx) {
		return idx;
	}
	public void addListeners() {
		btnGoal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				new Result(LottoGame.this);
			}
		});
	}
	/*@Override
	public String toString() {
		String info = no + "회 게임 결과: " +" \n";
		info += result + "일치번호 ->" + myList;
		return   info;
	}*/

	public static void main(String[] args) {
		new LottoGame();

	}
}
