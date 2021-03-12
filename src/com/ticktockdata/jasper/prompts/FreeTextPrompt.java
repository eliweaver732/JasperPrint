/*
 * Copyright (C) 2019 Joseph A Miller
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ticktockdata.jasper.prompts;

import net.sf.jasperreports.engine.JRParameter;

/**
 *
 * @author default
 */
public class FreeTextPrompt extends PromptComponent<String> {
    
//    private static Map<String, FreeTextPrompt> promptMap = new WeakHashMap<String, FreeTextPrompt>();
//    private JRParameter param;
    private String defaultValue = "";   // empty string
    
    /**
     * Creates new form FreeTextPrompt
     */
    public FreeTextPrompt() {
        
        initComponents();
        
    }
    
    @Override
    public void setParameter(JRParameter param) {
        super.setParameter(param);
        
        String desc = param.getDescription();
        if (desc == null) desc = param.getName();
        lblDescription.setText(desc);
        
        String defVal = param.getDefaultValueExpression().getText();
        if (defVal == null) defVal = "";
        // strip leading and trailing " characters
        if (defVal.startsWith("\"")) {
            defVal = defVal.replaceFirst("\"", "");
        }
        if (defVal.endsWith("\"")) {
            defVal = defVal.substring(0, defVal.length()-1);
        }
        if ("%".equals(defVal)) {
            defVal = "";    // don't set %, set as empty string instead
            defaultValue = "%";
        }
        
        if (txtParam.getText().isEmpty() && !defVal.isEmpty()) {
            txtParam.setText(defVal);
        }
        
    }
    
    
//    public static javax.swing.JPanel getPromptComponent(JRParameter param) {
//        
//        FreeTextPrompt panel = promptMap.get(param.getName());
//        
//        if (panel == null) {
//            panel = new FreeTextPrompt();
//            panel.setParam(param);
//            promptMap.put(param.getName(), panel);
//        } else {
//            panel.setParam(param);
//        }
//        
//        return panel;
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDescription = new javax.swing.JLabel();
        txtParam = new javax.swing.JTextField();

        lblDescription.setText("Prompt");

        txtParam.setPreferredSize(new java.awt.Dimension(176, 23));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtParam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDescription;
    private javax.swing.JTextField txtParam;
    // End of variables declaration//GEN-END:variables

    
    
    @Override
    public String getPromptValue() {
        return (txtParam.getText() == null || txtParam.getText().isEmpty() ? defaultValue : txtParam.getText());
    }

    @Override
    public void setPromptValue(String val) {
        txtParam.setText(val);
    }

    @Override
    public void refreshData() {
        // nothing to do!
    }
}