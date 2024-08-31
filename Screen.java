import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Screen extends JPanel implements ActionListener {
    private JButton Student1;
    private JButton Student2;
    private JButton Student3;
    private JButton goBack;
    private JButton bAdd;

    private JButton Refresh;
    
    private JTextField t1;
    
    private ArrayList<myPair<Student, Schedule>> studentList = new ArrayList<>();
    private int option = 0;
    private JTextArea t3;
    private int value1;
    public BufferedImage John;
    public BufferedImage Jack;
    public BufferedImage James;
    private JTextField t2;
    private String className;
    private int StudentNumber = 0;
    public Screen() {
        studentList.add(new myPair<Student, Schedule> (new Student("James"), new Schedule()));
        studentList.add(new myPair<Student, Schedule>(new Student("John"), new Schedule()));
        studentList.add(new myPair<Student, Schedule> (new Student("Jack"), new Schedule()));
        this.setLayout(null);
        
            Student1 = new JButton("James");
            Student1.setBounds(50+180,270-100,90,40);
            Student1.addActionListener(this);
            this.add(Student1);
            Student2 = new JButton("John");
            Student2.setBounds(50+90+180,270-100,90,40);
            Student2.addActionListener(this);
            this.add(Student2);
            Student3 = new JButton("Jack");
            Student3.setBounds(50+90+180+90,270-100,90,40);
            Student3.addActionListener(this);
            this.add(Student3);
        
        
        
        
        
        
            
        //Button
            bAdd = new JButton("Add");
            bAdd.setBounds(50, 130, 90, 40); //sets the location and size
            bAdd.addActionListener(this); //add the listener
            this.add(bAdd);
            bAdd.setVisible(false);
             //add to JPanel
             goBack = new JButton("Back");
             goBack.setBounds(50, 130+40+40, 90, 40); //sets the location and size
             goBack.addActionListener(this); //add the listener
             this.add(goBack);
             goBack.setVisible(false);
         

            Refresh = new JButton("Refresh List");
            Refresh.setBounds(50, 130+40, 90, 40); //sets the location and size
            Refresh.addActionListener(this); //add the listener
             //add to JPanel
            this.add(Refresh);
            Refresh.setVisible(false);
          

        //TextField
        t1 = new JTextField(20);
        t1.setBounds(50,90, 100, 30);
        this.add(t1);
        t1.setVisible(false);
        t2 = new JTextField(20);
        t2.setBounds(100+50,90, 100,30);
        this.add(t2);
        t2.setVisible(false);

t3 = new JTextArea(20,20);
        t3.setBounds(150,130, 300,300);
        this.add(t3);
        t3.setVisible(false);

        this.setFocusable(true);
        //reads images
        try {
     
      
        James = ImageIO.read(new File("James.png"));
        John = ImageIO.read(new File("John.png"));
        Jack = ImageIO.read(new File("Jack.png"));
        
    } catch (Exception e) {
      e.printStackTrace();
    }
    }


    public Dimension getPreferredSize() {
        //Sets the size of the panel
        return new Dimension(800,400);
    }
    //sets student screen
    public void setScreen2(){
        t1.setVisible(true);
        t2.setVisible(true);
        t3.setVisible(true);
        Refresh.setVisible(true);
        bAdd.setVisible(true);
        goBack.setVisible(true);
        Student1.setVisible(false);
        Student2.setVisible(false);
        Student3.setVisible(false);
        t3.setText("");
        t3.append(studentList.get(StudentNumber).getType2().toString());
    }
    //sets screen of students
    public void setScreen1(){
        t1.setVisible(false);
        t2.setVisible(false);
        t3.setVisible(false);
        Refresh.setVisible(false);
        bAdd.setVisible(false);
        goBack.setVisible(false);
        Student1.setVisible(true);
        Student2.setVisible(true);
        Student3.setVisible(true);
        t3.setText("");
    }


    public void paintComponent(Graphics g) {

    super.paintComponent(g);
    Font font = new Font("Arial", Font.PLAIN, 20);
    g.setFont(font);
    g.setColor(Color.black);
        //draw instructions
        if(option == 0){
            g.drawString("Select a Student", 50+90+180-30,70);
        }
        if(option == 1){
            g.drawString(studentList.get(StudentNumber).getType1().toString(), 50,30);
            g.drawString("Add Class ", 50, 60);
            g.drawString("Add Period ",150,60);
            g.drawImage(James, 300,30,100,100,null);
        }
        if(option ==2){
            g.drawString(studentList.get(StudentNumber).getType1().toString(), 50,30);
            g.drawString("Add Class ", 50, 60);
            g.drawString("Add Period ",150,60);
            g.drawImage(John, 300,30,100,100,null);
        }
        if(option == 3){
            g.drawString(studentList.get(StudentNumber).getType1().toString(), 50,30);
            g.drawString("Add Class ", 50, 60);
            g.drawString("Add Period ",150,60);
            g.drawImage(Jack, 300,30,100,100,null);
        }
        
      
       

    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == Student1){
            option = 1;
            StudentNumber=0;
            setScreen2();
           
            repaint();
        }
        if(e.getSource() == Student2){
            option = 2;
           
            StudentNumber=1;
            setScreen2();
            repaint();
        }
        if(e.getSource() == Student3){
            option = 3;
            StudentNumber = 2;
            setScreen2();
            repaint();
        }
        else if (e.getSource() == bAdd) {
            value1 = Integer.parseInt((t2.getText()));
            className = t1.getText();
            
            
            t1.setText("");
            t2.setText("");
            Schedule newSchedule = studentList.get(StudentNumber).getType2();
            newSchedule.addClass(value1, className);
            studentList.set(StudentNumber, new myPair<Student, Schedule>(studentList.get(StudentNumber).getType1(), newSchedule));
            
            System.out.println(studentList.get(StudentNumber));
            System.out.println(studentList.get(StudentNumber));
            
            setScreen2();
            repaint();
        }
        else if (e.getSource() == Refresh){
            System.out.println(studentList.get(StudentNumber));
            t1.setText("");
            
            repaint();
            setScreen2();
        } 
        else if (e.getSource() == goBack){
            
            option = 0;
            setScreen1();
            repaint();

        }
        else{
            System.out.println("fix"); // catches error
        }
    }



}

