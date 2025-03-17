import javax.swing.JOptionPane;

public class gui 
{
    
        public static void main(String []args) 
        {
            String name=JOptionPane.showInputDialog("enter your name");
            JOptionPane.showMessageDialog(null,"Hello "+name);
        
            int age =Integer.parseInt(JOptionPane.showInputDialog("enter you age"));
            JOptionPane.showMessageDialog(null,"you are "+age+" years old");
        
            double height =Double.parseDouble(JOptionPane.showInputDialog("enter you height"));
            JOptionPane.showMessageDialog(null,"you are "+height+" cm tall");
        }    
    
}
