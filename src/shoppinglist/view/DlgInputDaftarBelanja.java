/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppinglist.view;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import shoppinglist.dao.DaftarBelanjaJpaDao;
import shoppinglist.dao.DbUtil;
import shoppinglist.entity.DaftarBelanja;
import shoppinglist.entity.DaftarBelanjaDetil;

/**
 *
 * @author irfin
 */
public class DlgInputDaftarBelanja extends javax.swing.JDialog
{
    // FLAG utk menandakan form ini ditutup oleh aksi apa.
    public static final int RET_CANCEL = 0; // Jika user klik batal atau close dialog
    public static final int RET_OK = 1;     // Jika user klik "Simpan dan Tutup".
    
    private int retStatus = RET_CANCEL;  // Menyimpan salah satu dari nilai RET_CANCEL atau RET_OK.
    
    private static final int COL_NO_URUT = 0;
    private static final int COL_NAMA_BARANG = 1;
    private static final int COL_BYK = 2;
    private static final int COL_SATUAN = 3;
    private static final int COL_MEMO = 4;
    
    private DaftarBelanja belanja;

    /**
     * Creates new form DlgInputDaftarBelanja
     */
    public DlgInputDaftarBelanja(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        
        // Tampilkan tgl & jam sekarang
        Calendar cal = Calendar.getInstance();
        txtfTanggal.setValue(cal.getTime());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        btnBatal = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        txtfTanggal = new javax.swing.JFormattedTextField();
        txtJudul = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBarang = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnBatal.setText("Batal");
        btnBatal.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnBatalActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan & Tutup");
        btnSimpan.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnSimpanActionPerformed(evt);
            }
        });

        jLabel1.setText("Tanggal");

        txtfTanggal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm"))));

        txtJudul.setFont(txtJudul.getFont().deriveFont(txtJudul.getFont().getStyle() | java.awt.Font.BOLD));

        jLabel2.setText("Judul");

        tblBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {
                "No", "Nama Barang", "Banyak", "Satuan", "Memo"
            }
        )
        {
            Class[] types = new Class []
            {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean []
            {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex)
            {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblBarang);

        btnAdd.setText("+");
        btnAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("-");
        btnRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtfTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txtJudul)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(489, 489, 489)
                                .addComponent(btnSimpan)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBatal)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtfTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnRemove))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBatal)
                    .addComponent(btnSimpan))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnBatalActionPerformed
    {//GEN-HEADEREND:event_btnBatalActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnSimpanActionPerformed
    {//GEN-HEADEREND:event_btnSimpanActionPerformed
        belanja = new DaftarBelanja();
        belanja.setJudul(txtJudul.getText().trim());
        
        java.util.Date userInputDate = (java.util.Date) txtfTanggal.getValue();
        LocalDateTime locDateTime = userInputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        belanja.setTanggal(locDateTime);
        
        // Telusuri tiap baris di JTable utk diambil datanya dan disimpan dalam
        // objek DaftarBelanjaDetil lalu dimasukkan ke dalam objek DaftarBelanja.
        DaftarBelanjaDetil barang;
        DefaultTableModel tm = (DefaultTableModel) tblBarang.getModel();
        for (int idxRow = 0; idxRow < tm.getRowCount(); idxRow++) 
        {
            barang = new DaftarBelanjaDetil();
            barang.setNoUrut((int) tm.getValueAt(idxRow, COL_NO_URUT));
            barang.setNamaBarang((String) tm.getValueAt(idxRow, COL_NAMA_BARANG));
            barang.setByk((float) tm.getValueAt(idxRow, COL_BYK));
            barang.setSatuan((String) tm.getValueAt(idxRow, COL_SATUAN));
            barang.setMemo((String) tm.getValueAt(idxRow, COL_MEMO));
            
            belanja.addDaftarBarang(barang);
        }
        
        // Simpan ke Database
        simpanKeDatabase(belanja);
        
        doClose(RET_OK);
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnAddActionPerformed
    {//GEN-HEADEREND:event_btnAddActionPerformed
        // Ambil objek TableModel yg sdh diset di JTable
        DefaultTableModel tableModel = (DefaultTableModel) tblBarang.getModel();
        
        int jmlbaris = tableModel.getRowCount();
        tableModel.addRow(new Object[] {(jmlbaris+1), "", null, "", ""});
        
        // "No", "Nama Barang", "Banyak", "Satuan", "Memo"
        //  Int    String        Float      String    STring
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_btnRemoveActionPerformed
    {//GEN-HEADEREND:event_btnRemoveActionPerformed
        // Ambil objek TableModel yg sdh diset di JTable
        DefaultTableModel tableModel = (DefaultTableModel) tblBarang.getModel();
        
        int[] selectedRows = tblBarang.getSelectedRows();
        for (int i = selectedRows.length-1; i >= 0; i--) {
            tableModel.removeRow(selectedRows[i]);
        }
        
        penomoranUlang();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void doClose(int status)
    {
        retStatus = status;
        
        // Tutup JDialog ini.
        this.setVisible(false);
        this.dispose();     // Bebaskan alokasi ruang memori.
    }
    
    public DaftarBelanja getInputtedData()
    {
        return belanja;
    }
    
    /**
     * Mengembalikan status ditutupnya JDialog ini.
     * 
     * @return 
     */
    public int getReturnStatus()
    {
        return retStatus;
    }
    
    private void penomoranUlang()
    {
        DefaultTableModel tableModel = (DefaultTableModel) tblBarang.getModel();
        
        int rowCount = tableModel.getRowCount();
        int nomorUrut;
        for (int idxRow = 0; idxRow < rowCount; idxRow++) {
            nomorUrut = idxRow+1;
            tableModel.setValueAt(nomorUrut, idxRow, COL_NO_URUT);
        }
    }
    
    private void simpanKeDatabase(DaftarBelanja db)
    {
        DaftarBelanjaJpaDao dao = new DaftarBelanjaJpaDao(DbUtil.getEntityManagerFactory());
        boolean berhasil = dao.simpan(db);
        if (berhasil)
            java.awt.Toolkit.getDefaultToolkit().beep();
        else
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data", "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblBarang;
    private javax.swing.JTextField txtJudul;
    private javax.swing.JFormattedTextField txtfTanggal;
    // End of variables declaration//GEN-END:variables
}