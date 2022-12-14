/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package graphical;

import core.Inventory;
import core.Product;
import core.Voucher;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.Timer;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ui: jonat behavior: Jerome Loria
 */
public class AgreciboDashboard extends javax.swing.JFrame {

    private Inventory inventory;
    List<Voucher> vouchers;

    /**
     * Creates new form AgreciboDashboard
     */
    public AgreciboDashboard() {
        try {

            // load inventory file in string
            Path inventoryFilePath = Paths.get("data/inventory.txt");
            String content;
            content = Files.readString(inventoryFilePath, StandardCharsets.UTF_8);
            // parse inventory from loaded string
            Inventory inventory = Inventory.parseInventory(content);
            this.inventory = inventory;
            
            

            initComponents();
            showTime();
            showDate();
            allButton.setVisible(false);
            cat1Button.setVisible(false);
            cat2Button.setVisible(false);
            cat3Button.setVisible(false);
            f1NewOrderButton.setVisible(false);
            f5ManageTableButton.setVisible(false);
            f6SalesReportButton.setVisible(false);
            
            
            
            List<JButton> buttons = new ArrayList<>();
            buttons.add(productButton1);
            buttons.add(productButton2);
            buttons.add(productButton3);
            buttons.add(productButton4);
            buttons.add(productButton5);
            buttons.add(productButton6);
            buttons.add(productButton7);
            buttons.add(productButton8);
            buttons.add(productButton9);
            buttons.add(productButton10);
            buttons.add(productButton11);
            buttons.add(productButton12);
            
            for (int i=0; i<inventory.getProducts().size() && i<12; i++) {
                JButton button = buttons.get(i);
                Product product = inventory.getProducts().get(i);
                button.setText(
                        "<html>" 
                        + product.getName() 
                        + "<br>" 
                        + "??? " +     product.getPrice()
                        + "</html>"
                );
                button.setHorizontalAlignment(SwingConstants.CENTER);
            }
            
            this.vouchers = new ArrayList<>();
            // read vouchers from file
            content = Files.readString(Paths.get("data/vouchers.txt"), 
                    StandardCharsets.UTF_8);
            String voucherStrings[] = content.split("\n");
            for (String vString : voucherStrings) {
                // convert string to voucher obj and add to voucher arraylist
                Voucher v = Voucher.parseVoucher(vString);
                vouchers.add(v);
            }

        } catch (IOException ex) {
            Logger.getLogger(AgreciboDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addTable(String id, String desc, double price, int qty, double total) {
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();

        for (int row = 0; row < jTable1.getRowCount(); row++) {
            if (desc == jTable1.getValueAt(row, 1)) {
                dt.removeRow(jTable1.convertRowIndexToModel(row));
            }
        }
        Vector v = new Vector();
        v.add(id);
        v.add(desc);
        v.add(price);
        v.add(qty);
        v.add(total);

        dt.addRow(v);
    }

    void showTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();
                SimpleDateFormat s = new SimpleDateFormat("hh: mm: ss a");
                time.setText(s.format(d));
            }
        }
        ).start();
    }

    void showDate() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        date.setText(s.format(d));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        allButton = new javax.swing.JButton();
        cat1Button = new javax.swing.JButton();
        cat2Button = new javax.swing.JButton();
        cat3Button = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        deletePendingButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        checkoutButton = new javax.swing.JButton();
        totalLabel = new javax.swing.JLabel();
        voucherTextField = new javax.swing.JTextField();
        cashTextField = new javax.swing.JTextField();
        qtyUpButton = new javax.swing.JButton();
        qtyDownButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        f1NewOrderButton = new javax.swing.JButton();
        f1CancelOrderButton = new javax.swing.JButton();
        f2ManageProductsButton = new javax.swing.JButton();
        f5ManageTableButton = new javax.swing.JButton();
        f6SalesReportButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton29 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        productButton1 = new javax.swing.JButton();
        productButton4 = new javax.swing.JButton();
        productButton5 = new javax.swing.JButton();
        productButton2 = new javax.swing.JButton();
        productButton3 = new javax.swing.JButton();
        productButton6 = new javax.swing.JButton();
        productButton7 = new javax.swing.JButton();
        productButton8 = new javax.swing.JButton();
        productButton9 = new javax.swing.JButton();
        productButton11 = new javax.swing.JButton();
        productButton10 = new javax.swing.JButton();
        productButton12 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        receiptTextArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(245, 246, 251));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        allButton.setText("All");
        allButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allButtonActionPerformed(evt);
            }
        });

        cat1Button.setText("[CAT 1]");

        cat2Button.setText("[CAT 2]");

        cat3Button.setText("[CAT 3]");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cat1Button, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cat2Button, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cat3Button, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(allButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(cat1Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(cat2Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(cat3Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(72, 112, 246));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Description", "Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        jTable1.getAccessibleContext().setAccessibleName("");

        deletePendingButton.setBackground(new java.awt.Color(255, 51, 51));
        deletePendingButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        deletePendingButton.setForeground(new java.awt.Color(255, 255, 255));
        deletePendingButton.setText("Delete");
        deletePendingButton.setBorder(null);
        deletePendingButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePendingButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cash");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText(" Voucher");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("TOTAL");

        checkoutButton.setBackground(new java.awt.Color(51, 153, 0));
        checkoutButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        checkoutButton.setForeground(new java.awt.Color(255, 255, 255));
        checkoutButton.setText("CHECKOUT");
        checkoutButton.setBorder(null);
        checkoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutButtonActionPerformed(evt);
            }
        });

        totalLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        totalLabel.setForeground(new java.awt.Color(255, 255, 255));
        totalLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLabel.setText("0.00");

        voucherTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voucherTextFieldActionPerformed(evt);
            }
        });

        cashTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashTextFieldActionPerformed(evt);
            }
        });

        qtyUpButton.setBackground(new java.awt.Color(72, 112, 246));
        qtyUpButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        qtyUpButton.setForeground(new java.awt.Color(255, 255, 255));
        qtyUpButton.setText("<");
        qtyUpButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        qtyUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyUpButtonActionPerformed(evt);
            }
        });

        qtyDownButton.setBackground(new java.awt.Color(72, 112, 246));
        qtyDownButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        qtyDownButton.setForeground(new java.awt.Color(255, 255, 255));
        qtyDownButton.setText(">");
        qtyDownButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        qtyDownButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyDownButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("qty");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkoutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(221, 221, 221)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(totalLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(voucherTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cashTextField)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(deletePendingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtyUpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtyDownButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(29, 29, 29))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deletePendingButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qtyUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyDownButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(voucherTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cashTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(totalLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(checkoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        f1NewOrderButton.setBackground(new java.awt.Color(72, 112, 246));
        f1NewOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f1NewOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        f1NewOrderButton.setText("[F1 - New Order]");

        f1CancelOrderButton.setBackground(new java.awt.Color(72, 112, 246));
        f1CancelOrderButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f1CancelOrderButton.setForeground(new java.awt.Color(255, 255, 255));
        f1CancelOrderButton.setText("[Cancel Order]");
        f1CancelOrderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f1CancelOrderButtonActionPerformed(evt);
            }
        });

        f2ManageProductsButton.setBackground(new java.awt.Color(72, 112, 246));
        f2ManageProductsButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f2ManageProductsButton.setForeground(new java.awt.Color(255, 255, 255));
        f2ManageProductsButton.setText("[Manage Products]");
        f2ManageProductsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                f2ManageProductsButtonActionPerformed(evt);
            }
        });

        f5ManageTableButton.setBackground(new java.awt.Color(72, 112, 246));
        f5ManageTableButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f5ManageTableButton.setForeground(new java.awt.Color(255, 255, 255));
        f5ManageTableButton.setText("[F5 - Manage Table]");

        f6SalesReportButton.setBackground(new java.awt.Color(72, 112, 246));
        f6SalesReportButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f6SalesReportButton.setForeground(new java.awt.Color(255, 255, 255));
        f6SalesReportButton.setText("[F6 - Sales Report]");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(f1NewOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(f1CancelOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(f2ManageProductsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(f5ManageTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(f6SalesReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(f1NewOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f1CancelOrderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f2ManageProductsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f5ManageTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(f6SalesReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jButton29.setBackground(new java.awt.Color(72, 112, 246));
        jButton29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton29.setForeground(new java.awt.Color(255, 255, 255));
        jButton29.setText("[Logout]");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/graphical/Untitled design (1).png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("admin");

        time.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        time.setText("Clock");

        date.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        date.setText("Date");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        productButton1.setText("[Product Here]");
        productButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton1ActionPerformed(evt);
            }
        });

        productButton4.setText("[Product Here]");
        productButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton4ActionPerformed(evt);
            }
        });

        productButton5.setText("[Product Here]");
        productButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton5ActionPerformed(evt);
            }
        });

        productButton2.setText("[Product Here]");
        productButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton2ActionPerformed(evt);
            }
        });

        productButton3.setText("[Product Here]");
        productButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton3ActionPerformed(evt);
            }
        });

        productButton6.setText("[Product Here]");
        productButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton6ActionPerformed(evt);
            }
        });

        productButton7.setText("[Product Here]");
        productButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton7ActionPerformed(evt);
            }
        });

        productButton8.setText("[Product Here]");
        productButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton8ActionPerformed(evt);
            }
        });

        productButton9.setText("[Product Here]");
        productButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton9ActionPerformed(evt);
            }
        });

        productButton11.setText("[Product Here]");
        productButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton11ActionPerformed(evt);
            }
        });

        productButton10.setText("[Product Here]");
        productButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton10ActionPerformed(evt);
            }
        });

        productButton12.setText("[Product Here]");
        productButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productButton12ActionPerformed(evt);
            }
        });

        receiptTextArea.setColumns(20);
        receiptTextArea.setRows(5);
        jScrollPane2.setViewportView(receiptTextArea);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(productButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(productButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(productButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(0, 33, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton3ActionPerformed
        int btnNum = 3;
        Product p3;
        if (inventory.getProducts().size() >= btnNum) {

            p3 = inventory.getProducts().get(btnNum - 1);
            addTable(p3.getId(), p3.getDescription(), p3.getPrice(), 1, p3.getPrice());
        }
    }//GEN-LAST:event_productButton3ActionPerformed

    private void deletePendingButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePendingButtonActionPerformed
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        
        if (table.getRowCount() > 0 && selectedRowIndex >= 0) {
            
            table.removeRow(selectedRowIndex);
        }
    }//GEN-LAST:event_deletePendingButtonActionPerformed

    private void cashTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashTextFieldActionPerformed

    private void checkoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutButtonActionPerformed
        JTextArea b = receiptTextArea;
        try {

            b.setText("                           Agrecibo Software Group \n");
            b.setText(b.getText() + "                                     Bicol University \n");
            b.setText(b.getText() + "                                           BSCS 2A \n");
            b.setText(b.getText() + "                                      SY 2022-2023 \n");
            b.setText(b.getText() + "--------------------------------------------------------------------------\n");
            b.setText(b.getText() + "  Item \t\tQty \tPrice" + "\n");
            b.setText(b.getText() + "--------------------------------------------------------------------------\n");

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();

            double total = 0;
            // get table Product details
            for (int i = 0; i < jTable1.getRowCount(); i++) {

                String Name = df.getValueAt(i, 1).toString();
                String Qty = df.getValueAt(i, 3).toString();
                String Price = df.getValueAt(i, 2).toString();
                total += Double.parseDouble(df.getValueAt(i, 4).toString());

                b.setText(b.getText() + "  " + Name + "\t\t" + Qty + "\t" + Price + "\n");
            }
            
            totalLabel.setText("" + total);
            String enteredCode = voucherTextField.getText().trim();
            double voucheredTotal = 0;
            for (Voucher v : vouchers) {
                if (v.getCode().equals(enteredCode)) {
                    voucheredTotal = total * v.getDiscount();
                    break;
                }
                else {
                    voucheredTotal = total;
                }
            }
            
            if (cashTextField.getText().equals("")) {
                cashTextField.setText("0");
            }

            b.setText(b.getText() + "-----------------------------------------------------------------------------\n");
            b.setText(b.getText() + "Cash        : " + cashTextField.getText() + "\n");
            b.setText(b.getText() + "Sub Total : - " + totalLabel.getText() + "\n");
            
            DecimalFormat dform = new DecimalFormat("####0.00");
            b.setText(b.getText() + "Voucher   : " + dform.format(voucheredTotal) + "\n");
            b.setText(b.getText() + "Change    : " 
                    + dform.format(
                            (Double.parseDouble(cashTextField.getText()) - (total -  voucheredTotal))) 
                    + "\n");
            b.setText(b.getText() + "-----------------------------------------------------------------------------\n");
            b.setText(b.getText() + "                                         Come Again!" + "\n");
            b.setText(b.getText() + "-----------------------------------------------------------------------------\n");
            b.setText(b.getText() + "                             [Modified from Dapp Code]" + "\n");

            b.print(); //print

        } catch (PrinterException ex) {
            Logger.getLogger(AgreciboDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_checkoutButtonActionPerformed

    private void voucherTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voucherTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_voucherTextFieldActionPerformed

    private void qtyUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyUpButtonActionPerformed
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        if (table.getRowCount() > 0 && selectedRowIndex >= 0) {
            int qty = Integer.parseInt(table.getValueAt(selectedRowIndex, 3).toString());
            double price = Double.parseDouble(table.getValueAt(selectedRowIndex, 2).toString());
            if (qty >= 2) {
                qty--;
            }
            jTable1.setValueAt(qty, selectedRowIndex, 3);
            jTable1.setValueAt(qty*price, selectedRowIndex, 4);
        }
    }//GEN-LAST:event_qtyUpButtonActionPerformed

    private void qtyDownButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyDownButtonActionPerformed
        DefaultTableModel table = (DefaultTableModel) jTable1.getModel();
        int selectedRowIndex = jTable1.getSelectedRow();
        if (table.getRowCount() > 0 && selectedRowIndex >= 0) {
            int qty = Integer.parseInt(table.getValueAt(selectedRowIndex, 3).toString());
            double price = Double.parseDouble(table.getValueAt(selectedRowIndex, 2).toString());
            qty++;

            jTable1.setValueAt(qty, selectedRowIndex, 3);
            jTable1.setValueAt(qty*price, selectedRowIndex, 4);
        }
    }//GEN-LAST:event_qtyDownButtonActionPerformed

    private void allButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_allButtonActionPerformed

    private void productButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton1ActionPerformed
        int btnNum = 1;
        Product p1;
        if (inventory.getProducts().size() >= btnNum) {

            p1 = inventory.getProducts().get(btnNum - 1);
            addTable(p1.getId(), p1.getDescription(), p1.getPrice(), 1, p1.getPrice());
        }

    }//GEN-LAST:event_productButton1ActionPerformed

    private void productButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton2ActionPerformed
        int btnNum = 2;
        Product p2;
        if (inventory.getProducts().size() >= btnNum) {

            p2 = inventory.getProducts().get(btnNum - 1);
            addTable(p2.getId(), p2.getDescription(), p2.getPrice(), 1, p2.getPrice());
        }
    }//GEN-LAST:event_productButton2ActionPerformed

    private void productButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton4ActionPerformed
        int btnNum = 4;
        Product p4;
        if (inventory.getProducts().size() >= btnNum) {

            p4 = inventory.getProducts().get(btnNum - 1);
            addTable(p4.getId(), p4.getDescription(), p4.getPrice(), 1, p4.getPrice());
        }
    }//GEN-LAST:event_productButton4ActionPerformed

    private void productButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton5ActionPerformed
        int btnNum = 5;
        Product p5;
        if (inventory.getProducts().size() >= btnNum) {

            p5 = inventory.getProducts().get(btnNum - 1);
            addTable(p5.getId(), p5.getDescription(), p5.getPrice(), 1, p5.getPrice());
        }
    }//GEN-LAST:event_productButton5ActionPerformed

    private void productButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton6ActionPerformed
        int btnNum = 6;
        Product p6;
        if (inventory.getProducts().size() >= btnNum) {

            p6 = inventory.getProducts().get(btnNum - 1);
            addTable(p6.getId(), p6.getDescription(), p6.getPrice(), 1, p6.getPrice());
        }
    }//GEN-LAST:event_productButton6ActionPerformed

    private void productButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton7ActionPerformed
        int btnNum = 7;
        Product p7;
        if (inventory.getProducts().size() >= btnNum) {

            p7 = inventory.getProducts().get(btnNum - 1);
            addTable(p7.getId(), p7.getDescription(), p7.getPrice(), 1, p7.getPrice());
        }
    }//GEN-LAST:event_productButton7ActionPerformed

    private void productButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton8ActionPerformed
        int btnNum = 8;
        Product p8;
        if (inventory.getProducts().size() >= btnNum) {

            p8 = inventory.getProducts().get(btnNum - 1);
            addTable(p8.getId(), p8.getDescription(), p8.getPrice(), 1, p8.getPrice());
        }
    }//GEN-LAST:event_productButton8ActionPerformed

    private void productButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton9ActionPerformed
        int btnNum = 9;
        Product p9;
        if (inventory.getProducts().size() >= btnNum) {

            p9 = inventory.getProducts().get(btnNum - 1);
            addTable(p9.getId(), p9.getDescription(), p9.getPrice(), 1, p9.getPrice());
        }
    }//GEN-LAST:event_productButton9ActionPerformed

    private void productButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton10ActionPerformed
        int btnNum = 10;
        Product p10;
        if (inventory.getProducts().size() >= btnNum) {

            p10 = inventory.getProducts().get(btnNum - 1);
            addTable(p10.getId(), p10.getDescription(), p10.getPrice(), 1, p10.getPrice());
        }
    }//GEN-LAST:event_productButton10ActionPerformed

    private void productButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton11ActionPerformed
        int btnNum = 11;
        Product p11;
        if (inventory.getProducts().size() >= btnNum) {

            p11 = inventory.getProducts().get(btnNum - 1);
            addTable(p11.getId(), p11.getDescription(), p11.getPrice(), 1, p11.getPrice());
        }
    }//GEN-LAST:event_productButton11ActionPerformed

    private void productButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productButton12ActionPerformed
        int btnNum = 12;
        Product p12;
        if (inventory.getProducts().size() >= btnNum) {

            p12 = inventory.getProducts().get(btnNum - 1);
            addTable(p12.getId(), p12.getDescription(), p12.getPrice(), 1, p12.getPrice());
        }
    }//GEN-LAST:event_productButton12ActionPerformed

    private void f2ManageProductsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f2ManageProductsButtonActionPerformed

        String args[] = {""};
        this.setVisible(false);
        new AgreciboManageTableScreen().main(args); //shows it
    }//GEN-LAST:event_f2ManageProductsButtonActionPerformed

    private void f1CancelOrderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_f1CancelOrderButtonActionPerformed
        
        int responseOK = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to cancel?",
                "Confirm Cancel", JOptionPane.OK_CANCEL_OPTION);
        if (responseOK == 0) {
            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
            dtm.setRowCount(0);
        }
    }//GEN-LAST:event_f1CancelOrderButtonActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        this.setVisible(false);
        new AgreciboGUI().setVisible(true);
    }//GEN-LAST:event_jButton29ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgreciboDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgreciboDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgreciboDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgreciboDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgreciboDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton allButton;
    private javax.swing.JTextField cashTextField;
    private javax.swing.JButton cat1Button;
    private javax.swing.JButton cat2Button;
    private javax.swing.JButton cat3Button;
    private javax.swing.JButton checkoutButton;
    private javax.swing.JLabel date;
    private javax.swing.JButton deletePendingButton;
    private javax.swing.JButton f1CancelOrderButton;
    private javax.swing.JButton f1NewOrderButton;
    private javax.swing.JButton f2ManageProductsButton;
    private javax.swing.JButton f5ManageTableButton;
    private javax.swing.JButton f6SalesReportButton;
    private javax.swing.JButton jButton29;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton productButton1;
    private javax.swing.JButton productButton10;
    private javax.swing.JButton productButton11;
    private javax.swing.JButton productButton12;
    private javax.swing.JButton productButton2;
    private javax.swing.JButton productButton3;
    private javax.swing.JButton productButton4;
    private javax.swing.JButton productButton5;
    private javax.swing.JButton productButton6;
    private javax.swing.JButton productButton7;
    private javax.swing.JButton productButton8;
    private javax.swing.JButton productButton9;
    private javax.swing.JButton qtyDownButton;
    private javax.swing.JButton qtyUpButton;
    private javax.swing.JTextArea receiptTextArea;
    private javax.swing.JLabel time;
    private javax.swing.JLabel totalLabel;
    private javax.swing.JTextField voucherTextField;
    // End of variables declaration//GEN-END:variables
}
