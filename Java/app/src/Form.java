import javax.swing.*;
import java.awt.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.event.*;


public class Form extends JFrame{

   public Form(){
 
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
      Container pane=getContentPane();
      pane.setLayout(new BorderLayout());
      JLabel label=new JLabel("form");
      JButton btn=new JButton("Test");
      btn.addActionListener(new ActionListener(){

         public void actionPerformed(ActionEvent evt){
         
            System.setProperty("webdriver.chrome.driver", "/Programs/selenium/drivers/chromedriver");
            WebDriver driver=new ChromeDriver();
            driver.get("http://www.amazon.com");         

         }  
      });
      pane.add(label, BorderLayout.CENTER);
      pane.add(new JTextField(10), BorderLayout.NORTH);
      pane.add(btn, BorderLayout.SOUTH);

      pack();
      setVisible(true);

   }

   public static void main(String[] args){     
       new Form();  
   }

}
