package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Result extends JDialog {
	private LottoGame owner;
	private JPanel pnlC;
	private JPanel pnlN;
	private JPanel pnlS;
	private JPanel[] pnlResult;
	
	private JLabel lblResult;
	private JLabel lblGoal;
	private JLabel lbl1;// ****1���ȣ
	private JLabel lbl2;// ������ ��ȣ��
	
	public Result(LottoGame owner) {
		super(owner, "���Ȯ��", true);
		this.owner = owner;
		init();
		setDisplay();
		showFrame();
	}

	public void init() {
		pnlC = new JPanel(new BorderLayout());
		pnlN = new JPanel(new BorderLayout());
		lblGoal = new JLabel(String.valueOf(owner.getGoal()), JLabel.CENTER);
		lblGoal.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		//lblResult = new JLabel();
		lbl1 = new JLabel("*** 1�� ��ȣ ***", JLabel.CENTER);
		lbl1.setFont(new Font(Font.DIALOG, Font.BOLD, 40));
		lbl2 = new JLabel("������ ��ȣ�� ���ʽ� ��ȣ", JLabel.CENTER);
		lbl2.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

		pnlS = new JPanel(new GridLayout(0, 1));

		pnlResult = new JPanel[owner.getDrawAutoNum()];
		
		for (int idx = 0; idx < pnlResult.length; idx++) {

			pnlResult[idx] = new JPanel();
			lblResult = new JLabel(owner.getResult(idx), JLabel.CENTER);
			lblResult.setFont(new Font(Font.DIALOG, Font.BOLD, 30));

			pnlResult[idx].add(lblResult);
		}

		for (JPanel pnl : pnlResult) {

			pnl.setBorder(new TitledBorder(new LineBorder(Color.GRAY, 1),"��÷���"));
			pnlS.add(pnl);
		}
	}

	public void setDisplay() {
		pnlN.add(lbl1, BorderLayout.NORTH);
		pnlN.setBorder(new LineBorder(Color.RED, 2));
		pnlN.add(lbl2, BorderLayout.CENTER);
		pnlN.add(lblGoal, BorderLayout.SOUTH);
		pnlC.add(pnlN,BorderLayout.NORTH);
		pnlC.add(pnlS,BorderLayout.CENTER);
		add(pnlC);
	}

	public void showFrame() {

		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(owner);
		setVisible(true);

	}
}
