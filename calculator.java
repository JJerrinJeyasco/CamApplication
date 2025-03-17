import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class calculator implements ActionListener
{
        JFrame frame;
        JTextField screen;
        JButton nbtn[]= new JButton[10];
        JButton btnPlus, btnMinus, btnMult, btnRem, btnDiv, btnAC, btnEquals, btnDec, btnDel, btnZero, btn2Zero;
        Font ff1=new Font("ink.Free",Font.BOLD,35);
        Font ff2=new Font("ink.Free",Font.BOLD,20);

        JPanel panel;
        char opr;
        Double num1,num2,result;
        
        public calculator(){
                frame=new JFrame();
                frame.setSize(400, 530);
                frame.setLocationRelativeTo(null);
                frame.setResizable(true);
                frame.setTitle("JJJCALCULATOR");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(null);
                frame.setVisible(true);
                frame.getContentPane().setBackground(new Color(250,80,100));

                screen=new JTextField();
                screen.setBounds(25,25 , 335, 50);
                screen.setFont(ff1);
                screen.setEditable(true);
                screen.setHorizontalAlignment(JTextField.RIGHT);
                frame.add(screen);

                panel= new JPanel();
                panel.setBounds(25,100 , 335, 370);
                panel.setLayout(new GridLayout(5,4));
                frame.add(panel);

             for(int i=1;i<10;i++){
                    nbtn[i]=new JButton(String.valueOf(i));
                    panel.add(nbtn[i]);
                    nbtn[i].setFont(ff2);
                    nbtn[i].setForeground(Color.WHITE);
                    nbtn[i].setBackground(new Color(50,100,70));
                    nbtn[i].addActionListener(this);
             }
            btnPlus = new JButton("+");
            btnPlus.setFont(ff2);
            btnPlus.setForeground(Color.ORANGE);
            btnPlus.setBackground(new Color(40,40,40));
            btnMinus = new JButton("-");
            btnMinus.setFont(ff2);
            btnMinus.setForeground(Color.ORANGE);
            btnMinus.setBackground(new Color(40,40,40));
            btnDiv = new JButton("/");
            btnDiv.setFont(ff2);
            btnDiv.setForeground(Color.ORANGE);
            btnDiv.setBackground(new Color(40,40,40));
            btnMult = new JButton("*");
            btnMult.setFont(ff2);
            btnMult.setForeground(Color.orange);
            btnMult.setBackground(new Color(40,40,40));
            btnZero = new JButton("0");
            btnZero.setFont(ff2);
            btnZero.setForeground(Color.white);
            btnZero.setBackground(new Color(50,100,70));
            btn2Zero = new JButton("00");
            btn2Zero.setFont(ff2);
            btn2Zero.setForeground(Color.GREEN);
            btn2Zero.setBackground(new Color(40,40,40));
            btnDec = new JButton(".");
            btnDec.setFont(ff2);
            btnDec.setForeground(Color.orange);
            btnDec.setBackground(new Color(40,40,40));
            btnDel = new JButton("DEL");
            btnDel.setFont(ff2);
            btnDel.setForeground(Color.RED);
            btnDel.setBackground(new Color(40,40,40));
            btnAC = new JButton("AC");
            btnAC.setFont(ff2);
            btnAC.setForeground(Color.red);
            btnAC.setBackground(new Color(40,40,40));
            btnEquals = new JButton("=");
            btnEquals.setFont(ff2);
            btnEquals.setForeground(Color.BLACK);
            btnEquals.setBackground(Color.WHITE);
            btnRem = new JButton("%");
            btnRem.setFont(ff2);
            btnRem.setBackground(new Color(40,40,40));
            btnRem.setForeground(Color.orange);

                    panel.add(btnAC);
                    panel.add(btnDel);
                    panel.add(btnRem);
                    panel.add(btnDiv);
                    panel.add(nbtn[9]);
                    panel.add(nbtn[8]);
                    panel.add(nbtn[7]);
                    panel.add(btnMult);
                    panel.add(nbtn[6]);
                    panel.add(nbtn[5]);
                    panel.add(nbtn[4]);
                    panel.add(btnMinus);
                    panel.add(nbtn[3]);
                    panel.add(nbtn[2]);
                    panel.add(nbtn[1]);
                    panel.add(btnPlus);
                    panel.add(btn2Zero);
                    panel.add(btnZero);
                    panel.add(btnDec);
                    panel.add(btnDec);
                    panel.add(btnEquals);
                    

            btn2Zero.addActionListener(this);
            btnAC.addActionListener(this);
            btnDec.addActionListener(this);
            btnDel.addActionListener(this);
            btnDiv.addActionListener(this);
            btnEquals.addActionListener(this);
            btnMinus.addActionListener(this);
            btnMult.addActionListener(this);
            btnPlus.addActionListener(this);
            btnRem.addActionListener(this);
            btnZero.addActionListener(this);
            

        


        frame.setLayout(null);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
            for(int i=1;i<10;i++){
                if(e.getSource()==nbtn[i]){
                    screen.setText(screen.getText().concat(String.valueOf(i)));
                }
        }
        if(e.getSource()==btnZero){
            screen.setText(screen.getText().concat(String.valueOf("0")));
        }
            if(e.getSource()==btn2Zero){
                screen.setText(screen.getText().concat(String.valueOf("00")));
        }
            if(e.getSource()==btnAC){
                screen.setText("");
        }
        if(e.getSource()==btnDec){
            screen.setText(screen.getText().concat(String.valueOf(".")));
    }
            if(e.getSource()==btnDel){
                String backSpace=null;
                if(screen.getText().length()>0){
                        StringBuilder str=new StringBuilder(screen.getText());
                        str.deleteCharAt(screen.getText().length()-1);
                        backSpace=str.toString();
                        screen.setText(backSpace);


                }
            }
            if(e.getSource()==btnPlus){
                num1=Double.parseDouble(screen.getText());
                opr='+';
                screen.setText("");
            }
            if(e.getSource()==btnMinus){
                num1=Double.parseDouble(screen.getText());
                opr='-';
                screen.setText("");
            }
            if(e.getSource()==btnMult){
                num1=Double.parseDouble(screen.getText());
                opr='*';
                screen.setText("");
            }
            if(e.getSource()==btnDiv){
                num1=Double.parseDouble(screen.getText());
                opr='/';
                screen.setText("");
            }
            if(e.getSource()==btnRem){
                num1=Double.parseDouble(screen.getText());
                opr='%';
                screen.setText("");
            }
            if(e.getSource()==btnEquals){
                try{
                num2=Double.parseDouble(screen.getText());

                switch (opr) {
                         case '+':
                        result=num1+num2;
                        screen.setText(String.valueOf(result));
                        break;
                        case '-':
                        result=num1-num2;
                        screen.setText(String.valueOf(result));
                        break;
                        case '*':
                        result=num1*num2;
                        screen.setText(String.valueOf(result));
                        break;
                        case '/':
                        result=num1/num2;
                        screen.setText(String.valueOf(result));
                        break;
                        case '%':
                        result=num1%num2;
                        screen.setText(String.valueOf(result));
                        break;
            
                }
            }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null,"SYNTAX ERROR!!!");
                    screen.setText("");
                }
            }

        }

       
    
        
    
        public static void main(String[] args) {
            new calculator();
        }  
    }

