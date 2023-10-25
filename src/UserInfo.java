import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.sql.Time;
import java.text.NumberFormat;
import java.util.Random;


public class UserInfo extends JFrame {
    JPanel panel1;
    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phoneTextField;
    private JTextField ageTextField;
    private JTextField genderTextField;
    private JTextField dateTextField;
    private JTextField destinationTextField;
    private JTextField departureTextField;
    private JButton doneButton;
    private JTextField originTextField;


    public UserInfo() {

        doneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                String name = nameTextField.getText();
                String email = emailTextField.getText();
                String phone = phoneTextField.getText();
                String age = ageTextField.getText();
                String gender = genderTextField.getText();
                String date = dateTextField.getText();
                String origin = originTextField.getText();
                String destination = destinationTextField.getText();
                String departure = departureTextField.getText();



                Random rand = new Random();
                int randomNumber = (int) Math.floor(Math.random() * (99999 - 10000 + 1) + 10000);
                final Random random = new Random();
                final int millisInDay = 24*60*60*1000;
                Time time = new Time((long)random.nextInt(millisInDay));


                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                double price = 100;

                if (gender == "female" || gender == "Female" || gender == "F" || gender == "f") {
                    price = price *.75;
                }

                if (Integer.parseInt(age) <= 12) {
                    price = price * .5;
                } else if (Integer.parseInt(age) >= 60) {
                    price = price * .4;
                }

                String moneyString = formatter.format(price);




                try {
                    FileWriter dataFile = new FileWriter("data.txt", true);
                    dataFile.write("\nName: " + name + "\nEmail: " + email + "\nPhone Number: " + phone
                            + "\nAge: " + age + "\nGender: " + gender + "\nDate: " + date
                            + "\nOrigin: " + origin + "\nDestination: " + destination + "\nDeparture Date: "
                            + departure + "\nBoarding Pass Number: "
                    + randomNumber + "\nEstimated Time of Arrival: " + time + "\nTicket Price: " + moneyString);
                    dataFile.close();
                    JOptionPane.showMessageDialog(null, "Success");


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
    }


}
