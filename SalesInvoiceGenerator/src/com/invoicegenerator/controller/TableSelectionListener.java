/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.invoicegenerator.controller;

import com.invoicegenerator.model.InvoiceHeader;
import com.invoicegenerator.model.InvoiceLine;
import com.invoicegenerator.model.InvoiceLineTableModel;
import com.invoicegenerator.view.InvoiceFrame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
/**
 *
 * @author Muhamed Rifat
 */
public class TableSelectionListener implements ListSelectionListener {

    private InvoiceFrame frame;

    public TableSelectionListener(InvoiceFrame frame) {
        this.frame = frame;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int selectedInvIndex = frame.getInvHTbl().getSelectedRow();
        System.out.println("Invoice selected: " + selectedInvIndex);
        if (selectedInvIndex != -1) {
            InvoiceHeader selectedInv = frame.getInvoicesArray().get(selectedInvIndex);
            ArrayList<InvoiceLine> lines = selectedInv.getLines();
            InvoiceLineTableModel lineTableModel = new InvoiceLineTableModel(lines);
            frame.setLinesArray(lines);
            frame.getInvLTbl().setModel(lineTableModel);
            frame.getCustNameLbl().setText(selectedInv.getCustomer());
            frame.getInvNumLbl().setText("" + selectedInv.getNum());
            frame.getInvTotalIbl().setText("" + selectedInv.getInvoiceTotal());
            frame.getInvDateLbl().setText(InvoiceFrame.dateFormat.format(selectedInv.getInvDate()));
        }
    }

}

