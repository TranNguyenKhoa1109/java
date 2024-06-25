package Form;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import Sever.*;
import CLIENT.*;
import java.awt.event.ActionListener;
public class Main extends JFrame {
    public Main() {
        initComponents();
    }
    private void initComponents() {
    	 setTitle("Trang chủ");
        JButton jButton1 = new JButton("Hỗ Trợ");
        JButton jButton2 = new JButton("Tập Luyện");
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18));
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                client client = new client(); 
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                    .addGap(88, 88, 88)
                    .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(143, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
                    .addGap(139, 139, 139))
        );
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    private void jButton2ActionPerformed(ActionEvent evt) {
        this.dispose();
        dinhduong dinhduong = new dinhduong();
        dinhduong.setVisible(true);
    }
    private void jButton1ActionPerformed(ActionEvent evt) {
        this.dispose();
        dinhduong dinhduong = new dinhduong();
        dinhduong.setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }}

