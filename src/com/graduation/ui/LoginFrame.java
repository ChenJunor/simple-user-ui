package com.graduation.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class LoginFrame extends JFrame {
	
	private static final long serialVersionUID = 5835041664161623018L;
	
	private JPanel editPnl = null;
	private JPanel rstPnl = null;
	private JPanel btnPnl = null;
	private JPanel infoPnl = null;
	
	private JLabel classJlb = null;
	private JLabel snoJlb = null;
	private JLabel snameJlb = null;
	
	private JTextField classJtfld = null;
	private JTextField snoJtfld = null;
	private JTextField snameJtfld = null;
	
	private JButton comfirmBtn = null;
	private JButton cancelBtn = null;
	
	private JTextArea infoJta = null;
	
	public LoginFrame(){
		super();
		this.setTitle("信息获取");
		this.setSize(350, 300);
		this.setResizable(true);
		
		JPanel conPnl = new JPanel();
		this.setLayout(new BorderLayout());
		this.add(conPnl,BorderLayout.CENTER);
		conPnl.setLayout(new GridLayout(2,1));
		
		editPnl = new JPanel();
		conPnl.add(editPnl);
		
		rstPnl = new JPanel();
		conPnl.add(rstPnl);
				
		iniEditPnl();
		
		iniRstPnl();
				
		centerFrame();
		editPnl.setBackground(Color.YELLOW);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rstPnl.setBackground(Color.YELLOW);
		this.setVisible(true);
	}
	
	private void iniEditPnl(){
		classJlb = new JLabel("班级");
		snoJlb = new JLabel("学号");
		snameJlb = new JLabel("姓名");
		
		classJtfld = new JTextField();
		snoJtfld = new JTextField();
		snameJtfld = new JTextField();
		
		editPnl.setLayout(new GridBagLayout());
		
		editPnl.add(classJlb,new GridBagConstraints(0,0,1,1,0.2,1.0,GridBagConstraints.NORTH,GridBagConstraints.BOTH,new Insets(6, 12, 3, 0),0,0));
		editPnl.add(classJtfld,new GridBagConstraints(1,0,2,1,0.8,1.0,GridBagConstraints.NORTH,GridBagConstraints.BOTH,new Insets(12, 0, 9, 12),0,0));
		editPnl.add(snoJlb,new GridBagConstraints(0,1,1,1,0.2,1.0,GridBagConstraints.NORTH,GridBagConstraints.BOTH,new Insets(6, 12, 3, 0),0,0));
		editPnl.add(snoJtfld,new GridBagConstraints(1,1,3,1,0.8,1.0,GridBagConstraints.NORTH,GridBagConstraints.BOTH,new Insets(12, 0, 9, 12),0,0));
		editPnl.add(snameJlb,new GridBagConstraints(0,2,1,1,0.2,1.0,GridBagConstraints.NORTH,GridBagConstraints.BOTH,new Insets(6, 12, 3, 0),0,0));
		editPnl.add(snameJtfld,new GridBagConstraints(1,2,3,1,0.8,1.0,GridBagConstraints.NORTH,GridBagConstraints.BOTH,new Insets(12, 0, 9, 12),0,0));
	}
	
	private void iniRstPnl(){
		rstPnl.setLayout(new BorderLayout());
		btnPnl = new JPanel();
		infoPnl = new JPanel();
		rstPnl.add(btnPnl,BorderLayout.NORTH);
		rstPnl.add(infoPnl,BorderLayout.CENTER);
		btnPnl.setBackground(Color.YELLOW);

		Dimension btnDim = new Dimension(60,20);
		comfirmBtn = new JButton("确定");
		cancelBtn = new JButton("取消");
		
		comfirmBtn.setSize(btnDim);
		comfirmBtn.setMaximumSize(btnDim);
		comfirmBtn.setPreferredSize(btnDim);
		
		cancelBtn.setSize(btnDim);
		cancelBtn.setMaximumSize(btnDim);
		cancelBtn.setPreferredSize(btnDim);

		btnPnl.setLayout(new FlowLayout());
		
		btnPnl.add(comfirmBtn);
		btnPnl.add(cancelBtn);
		
		infoJta = new JTextArea();
		infoJta.setLineWrap(true);
		JScrollPane js =new JScrollPane(infoJta);
		js.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		infoPnl.setLayout(new GridLayout());
		infoPnl.add(js);
		infoPnl.setVisible(false);
		infoPnl.setBackground(Color.YELLOW);

		infoPnl.setBorder(BorderFactory.createEmptyBorder(6, 12, 6, 12));
				
		comfirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuffer sBuffer = new StringBuffer();
				sBuffer.append(classJlb.getText() + ": " + classJtfld.getText()).append("\n");
				sBuffer.append(snoJlb.getText() + ": " + snoJtfld.getText()).append("\n");
				sBuffer.append(snameJlb.getText() + ": " + snameJtfld.getText()).append("\n");
				infoJta.setText(sBuffer.toString());
				
				infoPnl.setVisible(true);
			}
		});
		
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void centerFrame(){
		int windowWidth = this.getWidth();                     //获得窗口宽
        int windowHeight = this.getHeight();                   //获得窗口高
        Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
        Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
        int screenWidth = screenSize.width;                     //获取屏幕的宽
        int screenHeight = screenSize.height;                   //获取屏幕的高
        this.setLocation(screenWidth/2-windowWidth/2, screenHeight/2-windowHeight/2);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LoginFrame();
	}

}
