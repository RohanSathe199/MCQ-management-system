/*Online Operating System Paper Test*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Test2 extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	Test2()
	{
		//super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: The ... contains commands associated with the my computer window ");
			jb[0].setText("standered menu");jb[1].setText("start menu");jb[2].setText("system menu");jb[3].setText("none of above");	
		}
		if(current==1)
		{
			l.setText("Que2: If the display system time and date is wrong,reset it using");
			jb[0].setText("write");jb[1].setText("calender");jb[2].setText("write file");jb[3].setText("control panel");
		}
		if(current==2)
		{
			l.setText("Que3: you should save your computer from ");
			jb[0].setText("viruses");jb[1].setText("bomb");jb[2].setText("warms");jb[3].setText("all of above");
		}
		if(current==3)
		{
			l.setText("Que4: world wide web is being standered by ");
			jb[0].setText("worldwide corporation");jb[1].setText("w3c");jb[2].setText("World Wide Consortium");jb[3].setText("World Wide Web Standard");
		}
		if(current==4)
		{
			l.setText("Que5: Which is the layer of computer system between hardware and user program ");
			jb[0].setText("Operating environment");jb[1].setText("Operating system");jb[2].setText("System invornment");jb[3].setText("none of above");
		}
		if(current==5)
		{
			l.setText("Que6: operating system is the most comman type of ...software ");
			jb[0].setText("communication");jb[1].setText("application");jb[2].setText("system");jb[3].setText("none of above");
		}
		if(current==6)
		{
			l.setText("Que7: Which of the following is an example of utility ");
			jb[0].setText("Antivirus");jb[1].setText("word");jb[2].setText("system");jb[3].setText("data recovery");
		}
		if(current==7)
		{
			l.setText("Que8: Which is build directly on hardware  ");
			jb[0].setText("operating system");jb[1].setText("application software");jb[2].setText("system software");jb[3].setText("database system");		
                }
		if(current==8)
		{
			l.setText("Que9: The purpose of run command in start menu ");
			jb[0].setText("Launch internet explorer");jb[1].setText("open internet explorer");jb[2].setText("start program");jb[3].setText("open windows explorer");
		}
		if(current==9)
		{
			l.setText("Que10: vertual memory typically located on ");
			jb[0].setText("RAM");jb[1].setText("CPU");jb[2].setText("flash drive");jb[3].setText("hard drive");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[2].isSelected());
		if(current==1)
			return(jb[3].isSelected());
		if(current==2)
			return(jb[0].isSelected());
		if(current==3)
			return(jb[1].isSelected());
		if(current==4)
			return(jb[1].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[0].isSelected());
		if(current==7)
			return(jb[0].isSelected());
		if(current==8)
			return(jb[2].isSelected());
		if(current==9)
			return(jb[3].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new Test2();
	}


}
