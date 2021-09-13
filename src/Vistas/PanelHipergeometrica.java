package Vistas;

import Distribuciones.discretas.Binomial;
import Distribuciones.discretas.Hipergeometrica;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sebastian
 */
public class PanelHipergeometrica extends javax.swing.JPanel {

    /**
     * Creates new form PanelHipergeometrica
     */
    public PanelHipergeometrica() {
        initComponents();
        label_coma.setVisible(false);
        jFormattedTextField_x2.setVisible(false);
    }

    private void graficar() {
        Graficas migrafica = new Graficas(Graficas.BARRAS, "Distribución Hipergeométrica", "X", "P(x)");

        int R = Integer.parseInt(jFormattedTextField_R.getValue().toString().replace(".", ""));
        int NTotal = Integer.parseInt(jFormattedTextField_NTotal.getText().replace(".", ""));
        int n = Integer.parseInt(jFormattedTextField_n.getText().replace(".", ""));
        
        double[] x = rango(0, menor(R, n), 1);
        double[] y = new double[x.length];
        Hipergeometrica h = new Hipergeometrica(R, NTotal, n);
        for (int i = 0; i < x.length; i++) {
            y[i] = h.funcionProbabilidad((int) x[i]);
        }

        migrafica.agregarCategorias(x, y);
        JPanel panel = migrafica.obtienePanel();
        panel.setSize(jPanelGrafica.getSize());
        jPanelGrafica.removeAll();
        jPanelGrafica.add(panel, BorderLayout.CENTER);
        jPanelGrafica.revalidate();
        jPanelGrafica.repaint();

    }
    
    private int menor(int R , int n){        
        if (R<n) {
            return R;
        }else{
            return n;
        }        
    } 

    private double[] rango(double xi, double xn, double d) {
        int n = (int) ((xn - xi) / d);
        double[] r = new double[n + 1];
        for (int i = 0; i <= n; i++) {
            r[i] = xi + d * i;
        }
        return r;
    }

    private boolean validarCampos() {
        boolean res = true;

        if (jFormattedTextField_n.getText().isEmpty()
                || jFormattedTextField_R.getText().isEmpty()
                || jFormattedTextField_NTotal.getText().isEmpty()
                || jFormattedTextField_x1.getText().isEmpty()) {
            return false;
        }
        if (jComboBoxVar.getSelectedIndex() == 3 && jFormattedTextField_x2.getText().isEmpty()) {
            return false;
        }
        try {
            int R = Integer.parseInt(jFormattedTextField_R.getValue().toString().replace(".", ""));
            int NTotal = Integer.parseInt(jFormattedTextField_NTotal.getText().replace(".", ""));
            int n = Integer.parseInt(jFormattedTextField_n.getText().replace(".", ""));
            int x1 = Integer.parseInt(jFormattedTextField_x1.getText());

            if (R < 0 || R > NTotal) {
                JOptionPane.showMessageDialog(this, "El valor de R debe estar entre N", "Error", JOptionPane.ERROR_MESSAGE);
                res = false;
            }
            if (n <= 0 || n > NTotal) {
                JOptionPane.showMessageDialog(this, "n debe estar entre los valores de N", "Error", JOptionPane.ERROR_MESSAGE);
                res = false;
            }
            if (x1 < 0 || x1 > n  || x1 > R) {
                JOptionPane.showMessageDialog(this, "x tiene que estar entre los valores de n y R ", "Error", JOptionPane.ERROR_MESSAGE);
                res = false;
            }
            if (jComboBoxVar.getSelectedIndex() == 3) {
                int x2 = Integer.parseInt(jFormattedTextField_x2.getText());
                if (x2 < 0 || x2 > n  || x2 > R) {
                    JOptionPane.showMessageDialog(this, "x tiene que estar entre los valores de n y R ", "Error", JOptionPane.ERROR_MESSAGE);
                    res = false;
                }
                if (x2 < x1) {
                    JOptionPane.showMessageDialog(this, "el segundo término debe ser mayor que el primero ", "Error", JOptionPane.ERROR_MESSAGE);
                    res = false;
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            res = false;
        }

        return res;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTitulo = new javax.swing.JLabel();
        label_n = new javax.swing.JLabel();
        jFormattedTextField_n = new javax.swing.JFormattedTextField();
        label_R = new javax.swing.JLabel();
        jFormattedTextField_R = new javax.swing.JFormattedTextField();
        jComboBoxVar = new javax.swing.JComboBox<>();
        jTextFieldResultado = new javax.swing.JTextField();
        jFormattedTextField_x1 = new javax.swing.JFormattedTextField();
        jFormattedTextField_x2 = new javax.swing.JFormattedTextField();
        label_X = new javax.swing.JLabel();
        label_coma = new javax.swing.JLabel();
        jButton_calcular = new javax.swing.JButton();
        label_X1 = new javax.swing.JLabel();
        LabelTitulo1 = new javax.swing.JLabel();
        jPanelGrafica = new javax.swing.JPanel();
        label_p1 = new javax.swing.JLabel();
        label_media = new javax.swing.JLabel();
        jTextFieldmedia = new javax.swing.JTextField();
        label_varianza = new javax.swing.JLabel();
        jTextFieldVarianza = new javax.swing.JTextField();
        jFormattedTextField_NTotal = new javax.swing.JFormattedTextField();
        label_NTotal = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setPreferredSize(new java.awt.Dimension(720, 519));

        LabelTitulo.setBackground(new java.awt.Color(51, 51, 51));
        LabelTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Distribución Hipergeométrica");
        LabelTitulo.setToolTipText("");

        label_n.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_n.setText("n =");

        jFormattedTextField_n.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField_n.setToolTipText("muestra");
        jFormattedTextField_n.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jFormattedTextField_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField_nActionPerformed(evt);
            }
        });

        label_R.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_R.setText("R =");

        jFormattedTextField_R.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextField_R.setToolTipText("numero de éxito considerado");
        jFormattedTextField_R.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jComboBoxVar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jComboBoxVar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "P(X=a)", "P(X<=a)", "P(X>=a)", "P(a<=X<=b)" }));
        jComboBoxVar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVarActionPerformed(evt);
            }
        });

        jTextFieldResultado.setEditable(false);

        jFormattedTextField_x1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField_x1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jFormattedTextField_x2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField_x2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        label_X.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_X.setText("X =");

        label_coma.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_coma.setText(",");

        jButton_calcular.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_calcular.setText("Calcular");
        jButton_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcularActionPerformed(evt);
            }
        });

        label_X1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_X1.setText(":");

        LabelTitulo1.setBackground(new java.awt.Color(51, 51, 51));
        LabelTitulo1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        LabelTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo1.setText("X~H(N,n,R)");
        LabelTitulo1.setToolTipText("");

        javax.swing.GroupLayout jPanelGraficaLayout = new javax.swing.GroupLayout(jPanelGrafica);
        jPanelGrafica.setLayout(jPanelGraficaLayout);
        jPanelGraficaLayout.setHorizontalGroup(
            jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelGraficaLayout.setVerticalGroup(
            jPanelGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );

        label_p1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_p1.setText("Gráfica :");

        label_media.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_media.setText("Media =");

        jTextFieldmedia.setEditable(false);

        label_varianza.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_varianza.setText("Varianza =");

        jTextFieldVarianza.setEditable(false);

        jFormattedTextField_NTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField_NTotal.setToolTipText("tamaño total de la población");
        jFormattedTextField_NTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jFormattedTextField_NTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField_NTotalActionPerformed(evt);
            }
        });

        label_NTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_NTotal.setText("N =");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(label_X)
                        .addGap(4, 4, 4)
                        .addComponent(jFormattedTextField_x1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(label_coma)
                        .addGap(4, 4, 4)
                        .addComponent(jFormattedTextField_x2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jComboBoxVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(label_X1)
                        .addGap(8, 8, 8)
                        .addComponent(jTextFieldResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jButton_calcular)
                        .addGap(38, 38, 38)
                        .addComponent(label_media)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldmedia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(label_varianza)
                        .addGap(4, 4, 4)
                        .addComponent(jTextFieldVarianza, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(label_p1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(label_NTotal)
                        .addGap(18, 18, 18)
                        .addComponent(jFormattedTextField_NTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_n)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField_n, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(label_R)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jFormattedTextField_R, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 161, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(LabelTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(LabelTitulo)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(LabelTitulo1)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextField_NTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_NTotal)
                    .addComponent(label_n)
                    .addComponent(jFormattedTextField_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_R)
                    .addComponent(jFormattedTextField_R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(label_X))
                    .addComponent(jFormattedTextField_x1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(label_coma))
                    .addComponent(jFormattedTextField_x2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(label_X1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_calcular)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(label_media))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jTextFieldmedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(label_varianza))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jTextFieldVarianza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(label_p1)
                .addGap(18, 18, 18)
                .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxVarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVarActionPerformed
        if (jComboBoxVar.getSelectedIndex() == 3) {
            label_coma.setVisible(true);
            jFormattedTextField_x2.setVisible(true);
        } else {
            label_coma.setVisible(false);
            jFormattedTextField_x2.setVisible(false);
        }
    }//GEN-LAST:event_jComboBoxVarActionPerformed

    private void jButton_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcularActionPerformed
        if (validarCampos()) {
            int R = Integer.parseInt(jFormattedTextField_R.getValue().toString().replace(".", ""));
            int NTotal = Integer.parseInt(jFormattedTextField_NTotal.getText().replace(".", ""));
            int n = Integer.parseInt(jFormattedTextField_n.getText().replace(".", ""));
            Hipergeometrica h = new Hipergeometrica(R, NTotal, n);
            int x1 = Integer.parseInt(jFormattedTextField_x1.getText());
            jTextFieldmedia.setText(String.format("%.3f", h.media()));
            jTextFieldVarianza.setText(String.format("%.3f", h.varianza()));
            switch (jComboBoxVar.getSelectedIndex()) {
                case 0:
                    jTextFieldResultado.setText(String.format("%.10f", h.funcionProbabilidad(x1)));
                    break;
                case 1:
                    jTextFieldResultado.setText(String.format("%.10f", h.funcionDistribucion(0, x1)));
                    break;
                case 2:
                    jTextFieldResultado.setText(String.format("%.10f", h.funcionDistribucion(x1, menor(R, n))));
                    break;
                case 3:
                    int x2 = Integer.parseInt(jFormattedTextField_x2.getText());
                    jTextFieldResultado.setText(String.format("%.10f", h.funcionDistribucion(x1, x2)));
                    break;
            }
            graficar();
        }
    }//GEN-LAST:event_jButton_calcularActionPerformed

    private void jFormattedTextField_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_nActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField_nActionPerformed

    private void jFormattedTextField_NTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_NTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField_NTotalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTitulo1;
    private javax.swing.JButton jButton_calcular;
    private javax.swing.JComboBox<String> jComboBoxVar;
    private javax.swing.JFormattedTextField jFormattedTextField_NTotal;
    private javax.swing.JFormattedTextField jFormattedTextField_R;
    private javax.swing.JFormattedTextField jFormattedTextField_n;
    private javax.swing.JFormattedTextField jFormattedTextField_x1;
    private javax.swing.JFormattedTextField jFormattedTextField_x2;
    private javax.swing.JPanel jPanelGrafica;
    private javax.swing.JTextField jTextFieldResultado;
    private javax.swing.JTextField jTextFieldVarianza;
    private javax.swing.JTextField jTextFieldmedia;
    private javax.swing.JLabel label_NTotal;
    private javax.swing.JLabel label_R;
    private javax.swing.JLabel label_X;
    private javax.swing.JLabel label_X1;
    private javax.swing.JLabel label_coma;
    private javax.swing.JLabel label_media;
    private javax.swing.JLabel label_n;
    private javax.swing.JLabel label_p1;
    private javax.swing.JLabel label_varianza;
    // End of variables declaration//GEN-END:variables
}
