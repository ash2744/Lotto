package kr.ac.green;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HowManyPlay extends JDialog {
	private LottoGame owner;
	int drawAutoNum;
	int drawManualNum;
	JPanel pnlMain;
	JPanel pnlCenter;
	JPanel pnlSouth;
	JLabel lblHow;
	JLabel lblAuto;
	JLabel lblManual;
	JTextField tfAuto;
	JTextField tfManual;
	JButton btnOk;
	JButton btnCancel;

	public HowManyPlay(LottoGame owner) {
		super(owner,"�ζǱ���", true);
		this. owner = owner;
		init();
		Display();
		addListeners();
		showFrame();
	}

	public void init() {
		pnlMain = new JPanel(new BorderLayout());
		pnlCenter = new JPanel();
		pnlSouth = new JPanel();
		lblHow = new JLabel("��� �����Ͻǰ̴ϱ�?", JLabel.CENTER);
		lblAuto = new JLabel("�ڵ�");
		lblManual = new JLabel("����");
		tfAuto = new JTextField(5);
		tfManual = new JTextField(5);
		btnOk = new JButton("Ȯ��");
		btnCancel = new JButton("���");
	}

	public void Display() {
		pnlMain.add(lblHow, BorderLayout.NORTH);
		pnlCenter.add(lblAuto);
		pnlCenter.add(tfAuto);
		pnlCenter.add(lblManual);
		pnlCenter.add(tfManual);
		pnlSouth.add(btnOk);
		pnlSouth.add(btnCancel);
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlMain.add(pnlSouth, BorderLayout.SOUTH);
		add(pnlMain);
	}

	public void addListeners() {
		class MyActionListener implements ActionListener {
			// ActionListener aListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				try {
					//drawManualNum = Integer.parseInt(tfManual.getText());
					drawAutoNum = Integer.parseInt(tfAuto.getText());
					HowManyPlay.this.owner.setDrawAutoNum(drawAutoNum);
					if (src == btnOk) {
						if ((drawAutoNum > 0 && drawAutoNum < 6)
								|| (drawManualNum > 0 && drawManualNum < 6)) {
							// HowManyPLay.this.owner.setDrawNum(drawAutoNum);
							// owner.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(HowManyPlay.this,
									"1~5�� ���Ϸθ� ��÷Ƚ���� �Է��ϼž� �մϴ�", "���",
									JOptionPane.WARNING_MESSAGE);
							tfAuto.setText("");
							tfAuto.requestFocus();
							tfManual.setText("");
							tfManual.requestFocus();
						}
					}

				} catch (NumberFormatException ne) {
					JOptionPane.showMessageDialog(HowManyPlay.this,
							"���ڸ� �Է��ϼ���", "�ȳ�", JOptionPane.INFORMATION_MESSAGE);
					tfAuto.setText("");
					tfAuto.requestFocus();
					tfManual.setText("");
					tfManual.requestFocus();
				}

			}
		}

		btnOk.addActionListener(new MyActionListener());
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object src = e.getSource();
				if (src == btnCancel) {
					System.exit(0);
				}
			}
		});
	}

	public void showFrame() {

		pack();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(owner);
		setVisible(true);

	}

	public int getDrawAutoNum() {
		return drawAutoNum;
	}
}
