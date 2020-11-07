package GUI;

import exception.ExceptionAge;
import exception.ExperienceSalaryException;
import worker.Worker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


import static javax.swing.GroupLayout.Alignment.*;
public class GUI extends JFrame {
    public GUI() {

        setTitle("Department");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(450,190,1020,597);
        setResizable(false);
        JPanel contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPane);
        contentPane.setLayout(null);


        JLabel labelTitle = new JLabel("Department");
        labelTitle.setFont(new Font("Itim", Font.BOLD, 30));
        labelTitle.setBounds(362, 52, 325, 80);
        contentPane.add(labelTitle);
//Labels
        JLabel label1=new JLabel("Name:");
        label1.setBounds(58, 145, 99, 43);
        contentPane.add(label1);

        JTextField name=new JTextField();
        name.setBounds(230, 150, 228, 30);
        contentPane.add(name);
        name.setColumns(10);

        JLabel label2=new JLabel("Surname:");
        label2.setBounds(58,205,99,43);
        contentPane.add(label2);

        JTextField surname=new JTextField();
        surname.setBounds(230, 210, 228, 30);
        contentPane.add(surname);
        surname.setColumns(10);

        JLabel label3=new JLabel("Age:");
        label3.setBounds(58, 275, 99, 43);
        contentPane.add(label3);


        JTextField age=new JTextField();
        age.setBounds(230, 275, 228, 30);
        contentPane.add(age);
        age.setColumns(10);

        
        JLabel label5=new JLabel("Experience:");
        label5.setBounds(542, 145, 99, 29);
        contentPane.add(label5);


        JTextField experience=new JTextField();
        experience.setBounds(707, 150, 228, 30);
        contentPane.add(experience);
        experience.setColumns(10);

        JLabel label6=new JLabel("Speciality:");
        label6.setBounds(542, 215, 99, 24);
        contentPane.add(label6);

        JTextField speciality=new JTextField();
        speciality.setBounds(707, 210, 228, 30);
        contentPane.add(speciality);
        speciality.setColumns(10);

        JLabel label7=new JLabel("Salary:");
        label7.setBounds(542, 280, 99, 24);
        contentPane.add(label7);

        JTextField salary=new JTextField();
        salary.setBounds(707, 270, 228, 30);
        contentPane.add(salary);
        salary.setColumns(10);


        ArrayList<Worker> workers=new ArrayList<>();
        JButton button1=new JButton("Add worker");
        JLabel label8=new JLabel("Info");

        label8.setBounds(58, 330, 840, 24);
        contentPane.add(label8);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String firstname = name.getText();
                    String secondname = surname.getText();
                    int ageOfPerson = Integer.parseInt(age.getText());
                    String specialityOfPerson = speciality.getText();
                    double salaryOfPerson = Double.parseDouble(salary.getText());
                    int experienceOfPerson = Integer.parseInt(experience.getText());
                    if (experienceOfPerson > ageOfPerson)
                        JOptionPane.showMessageDialog(null, "experience is more than your age,you're liar");
                Worker worker = new Worker(ageOfPerson, firstname, secondname, salaryOfPerson, specialityOfPerson, experienceOfPerson);
                label8.setText("Info: \n" + " Name: " + worker.getName() + "\n Surname: " + worker.getSurname() + " Age: " + worker.getAge() + "\n Salary: "
                        + worker.getSalary() + " \n Speciality: " + worker.getSpeciality() + "\n Years of experience: " + worker.getExperience());
            }catch(NumberFormatException exception1){
                    JOptionPane.showMessageDialog(null,"Enter values in TextField");
                }




            }
        });

        button1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        button1.setBounds(100, 447, 259, 74);
        contentPane.add(button1);

        JButton button2=new JButton("Rise salary");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                        String firstname = name.getText();
                        String secondname = surname.getText();
                        int ageOfPerson = Integer.parseInt(age.getText());
                        String specialityOfPerson = speciality.getText();
                        double salaryOfPerson = 2 * Double.parseDouble(salary.getText());
                        int experienceOfPerson = Integer.parseInt(experience.getText());

                    if (experienceOfPerson > ageOfPerson)
                        JOptionPane.showMessageDialog(null, "experience is more than your age,you're liar");
                    Worker worker = new Worker(ageOfPerson, firstname, secondname, salaryOfPerson, specialityOfPerson, experienceOfPerson);
                    label8.setText("Info: \n" + " Name: " + worker.getName() + "\n Surname: " + worker.getSurname() + " Age: " + worker.getAge() + "\n Salary: "
                            + worker.getSalary() + " \n Speciality: " + worker.getSpeciality() + "\n Years of experience: " + worker.getExperience());
                }catch(NumberFormatException exception1){
                    JOptionPane.showMessageDialog(null,"Incorrect input");
                }
                catch(ArithmeticException exception2){
                    JOptionPane.showMessageDialog(null,"Incorrect salary was entered");
                }
            }
        });
        button2.setFont(new Font("Tahoma", Font.PLAIN, 22));
        button2.setBounds(500, 447, 259, 74);
        contentPane.add(button2);
    }
    void checkExperience(JTextField experience){
        JOptionPane.showMessageDialog(this,"isn't correct number for experience");
    }
    void checkSalary(JTextField salary){
        JOptionPane.showMessageDialog(this,"isn't correct number for your salary");
    }
    void experienceSalary(JTextField experience){
        JOptionPane.showMessageDialog(this,"xp is higher and you get higher salary");
    }

}
