package com.file;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URL;
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

	public class Login extends JFrame{
		static String administration_id = "111";
		static String administration_password = "111";
		String zhiwu;
		JFrame jf;
		JLabel jl_id,jl_password,jl3;
		public static JTextField jt_id,jt_password;
		JPanel jp1,jp2,jp3,jp4,jp_group,jp_img;
		JButton jb_login;
		JRadioButton radioButton_student,radioButton_teacher,radioButton_manage,radioButton_administration;
		ButtonGroup group;
		ImageIcon img = null;
		public Login(){
			jf = new JFrame();
			jf.setSize(500,700);
			jf.setLocation(500,100);
			jf.setDefaultCloseOperation(EXIT_ON_CLOSE);
			jf.setLayout(new GridLayout(6,2));
			
			Icon img = new ImageIcon("tu1.gif");
			jp_img = new JPanel();
			jp_img.add(new JLabel(img));			
			
			jl_id = new JLabel("用户名");
			jt_id = new JTextField(15);
			jp1  =new JPanel();
			jp1.add(jl_id);
			jp1.add(jt_id);
			jl_password = new JLabel("密码");
			jt_password = new JTextField(15);
			jp2 = new JPanel();
			jp2.add(jl_password);
			jp2.add(jt_password);
			jl3 = new JLabel("学生管理系统");
			jp3 = new JPanel();
			jp3.add(jl3);
			
			jp_group = new JPanel();
			radioButton_student = new JRadioButton("学生");
			jp_group.add(radioButton_student);
			radioButton_teacher = new JRadioButton("老师");
			jp_group.add(radioButton_teacher);
			radioButton_manage = new JRadioButton("教务");
			jp_group.add(radioButton_manage);
			radioButton_administration = new JRadioButton("管理员");
			jp_group.add(radioButton_administration);
			group = new ButtonGroup();
			group.add(radioButton_student);
			group.add(radioButton_teacher);
			group.add(radioButton_manage);
			group.add(radioButton_administration);
			
			jb_login = new JButton("登录");
			jp4 = new JPanel();
			jp4.add(jb_login);
			
			jf.add(jp_img);
			jf.add(jp3);
			jf.add(jp1);
			jf.add(jp2);
			jf.add(jp_group);
			jf.add(jp4);
			jf.setVisible(true);
			//登录按钮监听
		jb_login.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				boolean flow = true;
				//学生
				if (radioButton_student.isSelected()) {
					if (IOStreamStudent.file.length() == 0) {
						JOptionPane.showMessageDialog(null, "用户名不存在", "提示信息",JOptionPane.ERROR_MESSAGE);
					} else {
						ArrayList<Student> arr = IOStreamStudent.readFromFile();
						Iterator<Student> it = arr.iterator();
						while (it.hasNext()) {
							Student newstu = it.next();
							if (newstu.getId().equals(jt_id.getText())) {
								if (newstu.getPassword().equals(jt_password.getText())) {
									new StudentLogin(newstu);									
								} else {
									JOptionPane.showMessageDialog(null,"密码或用户名错误");									
								}
								flow = false;
							} 
						}if(flow){
							JOptionPane.showMessageDialog(null, "用户名不存在");
						}
						
					}
				}
				
				//老师
				if (radioButton_teacher.isSelected()) {
					if (IOStreamTeacher.file.length() == 0) {
						JOptionPane.showMessageDialog(null, "用户名不存在", "提示信息",JOptionPane.ERROR_MESSAGE);
					} else {
						ArrayList<Teacher> arr = IOStreamTeacher.readFromFile();
						Iterator<Teacher> it = arr.iterator();
						while (it.hasNext()) {
							Teacher newtea = it.next();
							if (newtea.getId().equals(jt_id.getText())) {
								if (newtea.getPassword().equals(jt_password.getText())) {
									new TeacherLogin(newtea);
								} else {
									JOptionPane.showMessageDialog(null,"密码或用户名错误");
								}
								flow = false;
							}
						}
						if (flow) {
							JOptionPane.showMessageDialog(null, "用户名不存在");
						}
					}
				}
				//教务
				if (radioButton_manage.isSelected()) {
					if(IOStreamManage.file.length() == 0){
						JOptionPane.showMessageDialog(null, "用户名不存在","提示信息",JOptionPane.ERROR_MESSAGE);
					}else{						
						ArrayList<Manage> arr = IOStreamManage.readFromFile();
						Iterator<Manage> it = arr.iterator();
						while (it.hasNext()) {
							Manage newman = it.next();
							if (newman.getId().equals(jt_id.getText())) {
								if (newman.getPassword().equals(jt_password.getText())) {
									new ManageLogin(newman);										
								} else {
									JOptionPane.showMessageDialog(null, "密码或用户名错误");
								}
								flow = false;
							}
						}if(flow){
							JOptionPane.showMessageDialog(null, "用户名不存在");
						}
					}
				}
				//系统管理员
				if (radioButton_administration.isSelected()) {
					if (administration_id.equals(jt_id.getText())) {
						if (administration_password.equals(jt_password.getText())) {
							new Register();
						} else {
							JOptionPane.showMessageDialog(null, "密码错误");
						}
					} else {
						JOptionPane.showMessageDialog(null, "请重新登录");
					}

				}
			}
		});
		}
		//学生查寻返回元素下标
		public static int searchStudent(){
			int index = -1;
			String userid = jt_id.getText();
			if(IOStreamStudent.file.length() == 0){
				return index;
			}else{
				ArrayList<Student> arr  = IOStreamStudent.readFromFile();
				for(int i=0; i<arr.size(); i++){
					if(userid.equals(arr.get(i).getId())){
						index = i;
						return index;
					}
				}
			}
			return index;
		}
		//老师查询返回元素下标
		public static int searchTeacher(){
			int index = -1;
			String userid = jt_id.getText();
			if(IOStreamTeacher.file.length() == 0){
				return index;
			}else{
				ArrayList<Teacher> arr  = IOStreamTeacher.readFromFile();
				for(int i=0; i<arr.size(); i++){
					if(userid.equals(arr.get(i).getId())){
						index = i;
						return index;
					}
				}
			}
			return index;
		}
		//管理员查询返回下标
		public static int searchManage(){
			int index = -1;
			String userid = jt_id.getText();
			if(IOStreamManage.file.length() == 0){
				return index;
			}else{
				ArrayList<Manage> arr  = IOStreamManage.readFromFile();
				for(int i=0; i<arr.size(); i++){
					if(userid.equals(arr.get(i).getId())){
						index = i;
						return index;
					}
				}
			}
			return index;
		}
}
