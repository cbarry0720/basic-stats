package gui;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

import gui.view.View;
import model.BasicStatsModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UndoViewController implements View {

    private JButton jbUndo;

    public UndoViewController(BasicStatsGUI gui, JPanel jpInput) {
        this.jbUndo = new JButton("Undo");
        this.jbUndo.setEnabled(false);

        jpInput.add(jbUndo);

        jbUndo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gui.removeLastNumber();
            }
        });
    }

    @Override
    public void update(BasicStatsModel model) {
        if (model.getArrayDouble().length == 0) {
            this.jbUndo.setEnabled(false);
        } else {
            this.jbUndo.setEnabled(true);
        }
    }

    @Override
    public String getStringValue() {
        return this.jbUndo.isEnabled() ? "enabled" : "disabled";
    }

}
