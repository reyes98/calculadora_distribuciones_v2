package Vistas;

import Distribuciones.discretas.Binomial;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author sebastian
 */
public class PanelBinomial extends javax.swing.JPanel {

    /**
     * Creates new form PanelBinomial
     */
    public PanelBinomial() {
        initComponents();
        label_coma.setVisible(false);
        jFormattedTextField_x2.setVisible(false);
    }

    private void graficar() {
        Graficas migrafica = new Graficas(Graficas.BARRAS, "Distribución binomial","X","P(x)");
       
        double probabilidad = Double.parseDouble(jFormattedTextField_p.getValue().toString());        
        int n = Integer.parseInt(jFormattedTextField_n.getText().replace(".", ""));
        double[] x = rango(0, n, 1);
        double[] y = new double[x.length];
        Binomial b = new Binomial(n, probabilidad);
        for (int i = 0; i < x.length; i++) {
            y[i] = b.funcionProbabilidad((int) x[i]);
        }

        migrafica.agregarCategorias(x, y);
        JPanel panel = migrafica.obtienePanel();
        panel.setSize(jPanelGrafica.getSize());
        jPanelGrafica.removeAll();
        jPanelGrafica.add(panel,BorderLayout.CENTER);
        jPanelGrafica.revalidate();
        jPanelGrafica.repaint();

    }

    private double[] rango(double xi, double xn, double d) {
        int n = (int) ((xn - xi) / d);
        double[] r = new double[n+1];
        for (int i = 0; i <= n; i++) {
            r[i] = xi + d * i;
        }
        return r;
    }

    private boolean validarCampos() {
        boolean res = true;

        if (jFormattedTextField_n.getText().isEmpty()
                || jFormattedTextField_p.getText().isEmpty()
                || jFormattedTextField_x1.getText().isEmpty()) {
            return false;
        }
        if (jComboBoxVar.getSelectedIndex() == 3 && jFormattedTextField_x2.getText().isEmpty()) {
            return false;
        }
        try {
            double probabilidad = Double.parseDouble(jFormattedTextField_p.getValue().toString());
            int n = Integer.parseInt(jFormattedTextField_n.getText().replace(".", ""));
            int x1 = Integer.parseInt(jFormattedTextField_x1.getText());

            if (probabilidad < 0 || probabilidad > 1) {
                JOptionPane.showMessageDialog(this, "La probabilidad va desde 0 a 1", "Error", JOptionPane.ERROR_MESSAGE);
                res = false;
            }
            if (n <= 0) {
                JOptionPane.showMessageDialog(this, "n no puede tomar valores negativos ", "Error", JOptionPane.ERROR_MESSAGE);
                res = false;
            }
            if (x1 < 0 || x1 > n) {
                JOptionPane.showMessageDialog(this, "x tiene que estar entre los n ", "Error", JOptionPane.ERROR_MESSAGE);
                res = false;
            }
            if (jComboBoxVar.getSelectedIndex() == 3) {
                int x2 = Integer.parseInt(jFormattedTextField_x2.getText());
                if (x2 < 0 || x2 > n) {
                    JOptionPane.showMessageDialog(this, "x tiene que estar entre los n ", "Error", JOptionPane.ERROR_MESSAGE);
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
        label_p = new javax.swing.JLabel();
        jFormattedTextField_p = new javax.swing.JFormattedTextField();
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

        setBackground(new java.awt.Color(204, 204, 255));
        setPreferredSize(new java.awt.Dimension(720, 519));

        LabelTitulo.setBackground(new java.awt.Color(51, 51, 51));
        LabelTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        LabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelTitulo.setText("Distribución Binomial");
        LabelTitulo.setToolTipText("");

        label_n.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_n.setText("n =");

        jFormattedTextField_n.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));
        jFormattedTextField_n.setToolTipText("numero de eventos");
        jFormattedTextField_n.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jFormattedTextField_n.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextField_nActionPerformed(evt);
            }
        });

        label_p.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        label_p.setText("p =");

        jFormattedTextField_p.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jFormattedTextField_p.setToolTipText("probabilidad del evento");
        jFormattedTextField_p.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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
        LabelTitulo1.setText("X~B(n,p)");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(LabelTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(label_p1)
                        .addGap(626, 626, 626))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addComponent(LabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(label_n)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jFormattedTextField_n, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(label_X)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jFormattedTextField_x1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(label_coma)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jFormattedTextField_x2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton_calcular)
                                        .addGap(38, 38, 38)
                                        .addComponent(label_media)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(label_p)
                                        .addGap(21, 21, 21)
                                        .addComponent(jFormattedTextField_p, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextFieldmedia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(label_varianza)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jTextFieldVarianza))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jComboBoxVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(6, 6, 6)
                                                .addComponent(label_X1)
                                                .addGap(8, 8, 8)
                                                .addComponent(jTextFieldResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(LabelTitulo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_n)
                    .addComponent(jFormattedTextField_n, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_p)
                    .addComponent(jFormattedTextField_p, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_X)
                    .addComponent(jFormattedTextField_x1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextField_x2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_coma)
                    .addComponent(jComboBoxVar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldResultado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_X1))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_calcular)
                    .addComponent(label_media)
                    .addComponent(jTextFieldmedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_varianza)
                    .addComponent(jTextFieldVarianza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
            double probabilidad = Double.parseDouble(jFormattedTextField_p.getValue().toString());
            int n = Integer.parseInt(jFormattedTextField_n.getText().replace(".", ""));
            Binomial b = new Binomial(n, probabilidad);
            int x1 = Integer.parseInt(jFormattedTextField_x1.getText());
            jTextFieldmedia.setText(String.format("%.3f", b.media()));
            jTextFieldVarianza.setText(String.format("%.3f", b.varianza()));
            switch (jComboBoxVar.getSelectedIndex()) {
                case 0:
                    jTextFieldResultado.setText(String.format("%.10f", b.funcionProbabilidad(x1)));
                    break;
                case 1:
                    jTextFieldResultado.setText(String.format("%.10f", b.funcionDistribucion(0, x1)));
                    break;
                case 2:
                    jTextFieldResultado.setText(String.format("%.10f", b.funcionDistribucion(x1, n)));
                    break;
                case 3:
                    int x2 = Integer.parseInt(jFormattedTextField_x2.getText());
                    jTextFieldResultado.setText(String.format("%.10f", b.funcionDistribucion(x1, x2)));
                    break;
            }
            graficar();
        }
    }//GEN-LAST:event_jButton_calcularActionPerformed

    private void jFormattedTextField_nActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextField_nActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextField_nActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelTitulo1;
    private javax.swing.JButton jButton_calcular;
    private javax.swing.JComboBox<String> jComboBoxVar;
    private javax.swing.JFormattedTextField jFormattedTextField_n;
    private javax.swing.JFormattedTextField jFormattedTextField_p;
    private javax.swing.JFormattedTextField jFormattedTextField_x1;
    private javax.swing.JFormattedTextField jFormattedTextField_x2;
    private javax.swing.JPanel jPanelGrafica;
    private javax.swing.JTextField jTextFieldResultado;
    private javax.swing.JTextField jTextFieldVarianza;
    private javax.swing.JTextField jTextFieldmedia;
    private javax.swing.JLabel label_X;
    private javax.swing.JLabel label_X1;
    private javax.swing.JLabel label_coma;
    private javax.swing.JLabel label_media;
    private javax.swing.JLabel label_n;
    private javax.swing.JLabel label_p;
    private javax.swing.JLabel label_p1;
    private javax.swing.JLabel label_varianza;
    // End of variables declaration//GEN-END:variables
}