package com.file;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Register {
	JFrame jf;
	JLabel jl_id, jl_password, jl_age, jl_sex, jl5;
	JTextField jt_id, jt_password, jt_age, jt_sex;
	JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp_group, jp_img;
	JButton jb1;
	ButtonGroup group;
	JRadioButton radioButton_student, radioButton_teacher, radioButton_manage;

	public Register() {
		jf = new JFrame("注册界面");
		jf.setSize(500, 700);
		jf.setLocation(1300,100);
		jf.setVisible(true);
		jf.setLayout(new GridLayout(7, 2));

		Icon img = new ImageIcon("tu1.gif");
		jp_img = new JPanel();
		jp_img.add(new JLabel(img));

		jl_id = new JLabel("用户名");
		jt_id = new JTextField(15);
		jp1 = new JPanel();
		jp1.add(jl_id);
		jp1.add(jt_id);
		jl_password = new JLabel("密码");
		jt_password = new JTextField(15);
		jp2 = new JPanel();
		jp2.add(jl_password);
		jp2.add(jt_password);

		jp_group = new JPanel();
		radioButton_student = new JRadioButton("学生");
		jp_group.add(radioButton_student);
		radioButton_teacher = new JRadioButton("老师");
		jp_group.add(radioButton_teacher);
		radioButton_manage = new JRadioButton("教务");
		jp_group.add(radioButton_manage);
		group = new ButtonGroup();
		group.add(radioButton_student);
		group.add(radioButton_teacher);
		group.add(radioButton_manage);

		jb1 = new JButton("完成");
		jp5 = new JPanel();
		jp5.add(jb1);
		jl5 = new JLabel("注册成功");
		jp6 = new JPanel();
		jf.add(jp_img);
		jf.add(jp1);
		jf.add(jp2);
		jf.add(jp_group);
		jf.add(jp5);
		jf.add(jp6);
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//学生
				if (radioButton_student.isSelected()) {
					Student stu = new Student(jt_id.getText(), jt_password
							.getText());
					if (IOStreamStudent.file.length() == 0) {
						DB.arrStu.add(stu);
						IOStreamStudent.writeToFile();
						jp6.add(jl5);
						jf.setVisible(true);
						jt_id.setText("");
						jt_password.setText("");
					} else {
						DB.arrStu.clear();
						DB.arrStu = IOStreamStudent.readFromFile();
						Iterator<Student> it = DB.arrStu.iterator();
						boolean flag = true;
						while (it.hasNext()) {
							Student newstu = it.next();
							if (newstu.getId().equals(jt_id.getText())) {
								flag = false;
								JOptionPane.showMessageDialog(null,
										"此用户名已存在，请重新输入");
							}
						}
						if (flag) {
							if (!(jt_id.getText().isEmpty() || jt_password
									.getText().isEmpty())) {
								DB.arrStu.add(stu);
								IOStreamStudent.writeToFile();
								jp6.add(jl5);
								jf.setVisible(true);
								jt_id.setText("");
								jt_password.setText("");
							} else {
								JOptionPane.showMessageDialog(null,
										"密码，用户名不能为空");
							}
						}
					}
				}
				//老师
				if (radioButton_teacher.isSelected()) {
					Teacher tea = new Teacher(jt_id.getText(), jt_password
							.getText());
					if (IOStreamTeacher.file.length() == 0) {
						DB.arrTea.add(tea);
						IOStreamTeacher.writeToFile();
						jp6.add(jl5);
						jf.setVisible(true);
						jt_id.setText("");
						jt_password.setText("");
					} else {
						DB.arrTea.clear();
						DB.arrTea = IOStreamTeacher.readFromFile();
						Iterator<Teacher> it = DB.arrTea.iterator();
						boolean flag = true;
						while (it.hasNext()) {
							Teacher newtea = it.next();
							if (newtea.getId().equals(jt_id.getText())) {
								flag = false;
								JOptionPane.showMessageDialog(null,
										"此用户名已存在，请重新输入");
							}
						}
						if (flag) {
							if (!(jt_id.getText().isEmpty() || jt_password
									.getText().isEmpty())) {
								DB.arrTea.add(tea);
								IOStreamTeacher.writeToFile();
								jp6.add(jl5);
								jf.setVisible(true);
								jt_id.setText("");
								jt_password.setText("");
							} else {
								JOptionPane.showMessageDialog(null,
										"密码，用户名不能为空");
							}

						}
					}

				}
				//管理员
				if (radioButton_manage.isSelected()) {
					Manage man = new Manage(jt_id.getText(), jt_password
							.getText());
					if (IOStreamManage.file.length() == 0) {
						DB.arrMan.add(man);
						IOStreamManage.writeToFile();
						jp6.add(jl5);
						jf.setVisible(true);
						jt_id.setText("");
						jt_password.setText("");
					} else {
						DB.arrMan.clear();
						DB.arrMan = IOStreamManage.readFromFile();
						Iterator<Manage> it = DB.arrMan.iterator();
						boolean flag = true;
						while (it.hasNext()) {
							Manage newman = it.next();
							if (newman.getId().equals(jt_id.getText())) {
								flag = false;
								JOptionPane.showMessageDialog(null,
										"此用户名已存在，请重新输入");
							}
						}
						if (flag) {
							if (!(jt_id.getText().isEmpty() || jt_password
									.getText().isEmpty())) {
								DB.arrMan.add(man);
								IOStreamManage.writeToFile();
								jp6.add(jl5);
								jf.setVisible(true);
								jt_id.setText("");
								jt_password.setText("");
							} else {
								JOptionPane.showMessageDialog(null,
										"密码，用户名不能为空");
							}

						}
					}

				}
			}

		});
	}
}