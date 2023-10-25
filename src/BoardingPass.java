import javax.swing.*;


public class BoardingPass extends UserInfo {



    public static void main(String[] args) {
        UserInfo u = new UserInfo();
        u.setContentPane(u.panel1);
        u.setTitle("UserInfo");
        u.setBounds(600, 200, 300, 300);
        u.setVisible(true);
        u.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}