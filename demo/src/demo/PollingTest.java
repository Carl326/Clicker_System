package demo;

import com.turningtech.poll.Poll;
import com.turningtech.poll.PollService;
import com.turningtech.poll.Response;
import com.turningtech.poll.ResponseListener;
import com.turningtech.receiver.Receiver;
import com.turningtech.receiver.ReceiverService;
import com.turningtech.receiver.ResponseCardLibrary;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Test app for demoing ResponseCard(C) SDK capabilities.
 *
 * @author Turning Technologies
 */
public class PollingTest extends javax.swing.JFrame {

    private Poll poll;
    private ResponseListModel responseListModel = new ResponseListModel();
    private ReceiverListModel receiverListModel = new ReceiverListModel();
    private ReceiverListCellRenderer receiverCellRenderer = new ReceiverListCellRenderer();
    //dataset for poll results graph
    private DefaultCategoryDataset dataset;

    public PollingTest() {
        initReceivers();
        initComponents();
        initModel();
        jPopupMenu1.add(new SetChannelAction());
        if (receiverList.getModel().getSize() > 0)
            receiverList.setSelectedIndex(0);
    }

    private void initReceivers() {
        try {
            receiverListModel.addAll(ReceiverService.findReceivers());
        } catch (Exception e) {
            showError("Could not initialize receivers.", e);
        }
        dataset = createDataset();
    }

    private void initModel() {
        responseChart.setDataset(dataset);

        responseList.setModel(responseListModel);
        receiverList.setModel(receiverListModel);
        receiverList.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }
                int selection = receiverList.getSelectedIndex();
                try {
                    Receiver receiver = receiverListModel.get(selection);
                    lblChannel.setText(Integer.toString(receiver.getChannel()));
                    lblDescription.setText(receiver.getDescription());
                    lblId.setText(receiver.getId());
                } catch (Exception ex) {
                    //ignore
                }

            }
        });
        receiverList.setCellRenderer(receiverCellRenderer);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        receiverList = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblChannel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        responseChart = new org.jfree.beans.JBarChart();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        responseList = new javax.swing.JList();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuRefresh = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JSeparator();
        mnuStart = new javax.swing.JMenuItem();
        mnuStop = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ResponseCardSDK Demo App");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                PollingTest.this.windowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Receivers"));

        receiverList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        receiverList.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(receiverList);

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 341, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Receiver Info"));

        jLabel1.setText("Description:");

        lblDescription.setText("N/A");

        jLabel3.setText("Channel:");

        lblChannel.setText("N/A");

        jLabel2.setText("Id:");

        lblId.setText("N/A");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel1)
                    .add(jLabel3)
                    .add(jLabel2))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel2Layout.createSequentialGroup()
                        .add(lblChannel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                        .add(99, 99, 99))
                    .add(lblDescription, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .add(lblId))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblDescription, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblChannel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lblId)
                    .add(jLabel2))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        responseChart.setBarOutlineVisible(true);
        responseChart.setCategoryAxisLabel("Responses");
        responseChart.setCategoryAxisLineVisible(false);
        responseChart.setChartBackgroundPaint(getBackground());
        responseChart.setPlotBackgroundAlpha(0.3F);
        responseChart.setPlotOutlineVisible(false);
        responseChart.setSource("");
        responseChart.setSubtitle("Polling Closed");
        responseChart.setTitle("Polling Results");
        responseChart.setValueAxisLabel("Count");
        responseChart.setValueAxisLineVisible(false);
        responseChart.setValueAxisLowerMargin(1.0);
        responseChart.setValueAxisUpperMargin(1.0);

        org.jdesktop.layout.GroupLayout responseChartLayout = new org.jdesktop.layout.GroupLayout(responseChart);
        responseChart.setLayout(responseChartLayout);
        responseChartLayout.setHorizontalGroup(
            responseChartLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 269, Short.MAX_VALUE)
        );
        responseChartLayout.setVerticalGroup(
            responseChartLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(0, 259, Short.MAX_VALUE)
        );

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, responseChart, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(responseChart, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Poll Results"));

        jScrollPane2.setViewportView(responseList);

        org.jdesktop.layout.GroupLayout jPanel4Layout = new org.jdesktop.layout.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
        );

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Quit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionHandler(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Poll");

        mnuRefresh.setText("Refresh Receiver List");
        mnuRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshReceiverHandler(evt);
            }
        });
        jMenu2.add(mnuRefresh);
        jMenu2.add(jSeparator1);

        mnuStart.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        mnuStart.setText("Start Poll (All Receivers)");
        mnuStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startPollHandler(evt);
            }
        });
        jMenu2.add(mnuStart);

        mnuStop.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnuStop.setText("Stop Poll (All Receivers)");
        mnuStop.setEnabled(false);
        mnuStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopPollHandler(evt);
            }
        });
        jMenu2.add(mnuStop);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .add(12, 12, 12)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionHandler
        try {
            poll.shutdown();
        } catch (Exception ex) {
            Logger.getLogger(PollingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.exit(0);
    }//GEN-LAST:event_exitActionHandler

    private void startPollHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startPollHandler
        this.responseChart.setDataset((dataset = createDataset()));
        this.responseListModel.clear();
        try {
            poll = PollService.createPoll();
            poll.addResponseListener(new BasicResponseListener());
            poll.start();
            mnuRefresh.setEnabled(false);
            mnuStart.setEnabled(false);
            mnuStop.setEnabled(true);
            responseChart.setSubtitle("Polling Open");
        } catch (Exception e) {
            showError("Unable to start poll.", e);
        }
    }//GEN-LAST:event_startPollHandler

    private void stopPollHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopPollHandler
        try {
            poll.stop();
            mnuRefresh.setEnabled(true);
            mnuStart.setEnabled(true);
            mnuStop.setEnabled(false);
            responseChart.setSubtitle("Polling Closed");
        } catch (Exception e) {
            showError("Unable to stop poll.", e);
        }
    }//GEN-LAST:event_stopPollHandler

	private void refreshReceiverHandler(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshReceiverHandler
            receiverListModel.clear();
            responseListModel.clear();
            try {
                int selectedIndex = receiverList.getSelectedIndex();
                receiverListModel.addAll(ReceiverService.findReceivers());
                receiverList.clearSelection();
                if (receiverList.getModel().getSize() > 0) {
                    if (receiverList.getModel().getSize() > selectedIndex && selectedIndex > -1)
                        receiverList.setSelectedIndex(selectedIndex);
                    else
                        receiverList.setSelectedIndex(0);
                }
            } catch (Exception ex) {
                showError("Unable to initialize receivers.", ex);
            }
            this.responseChart.setDataset((dataset = createDataset()));
    }//GEN-LAST:event_refreshReceiverHandler

private void windowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_windowClosing
    try {
        if (poll != null) {
            poll.shutdown();
        } else {
            List<Receiver> receivers = receiverListModel.getReceivers();
            for (Receiver receiver : receivers) {
                receiver.close();
            }
        }
        } catch (Exception ex) {//GEN-LAST:event_windowClosing
            Logger.getLogger(PollingTest.class.getName()).log(Level.SEVERE, "There was a problem shutting down the poll.", ex);
        }
    }

    private void showError(String message, Exception e) {
        JOptionPane.showMessageDialog(null, message + "\n Reason:" + e.getMessage());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Usage: PollingTest [company name] [license key]");
            System.exit(0);

        }
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        
        ResponseCardLibrary.initializeLicense(
                args[0],
                args[1]);
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {/*ignore*/

                }
                new PollingTest().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblChannel;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblId;
    private javax.swing.JMenuItem mnuRefresh;
    private javax.swing.JMenuItem mnuStart;
    private javax.swing.JMenuItem mnuStop;
    private javax.swing.JList receiverList;
    private org.jfree.beans.JBarChart responseChart;
    private javax.swing.JList responseList;
    // End of variables declaration//GEN-END:variables

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset newDataset = new DefaultCategoryDataset();
        List<Receiver> receivers = receiverListModel.getReceivers();
        for (Receiver receiver : receivers) {
            for (int i = 0; i < 10; i++) {
                newDataset.addValue(0, receiver.getId(), Integer.toString(i));
            }
        }

        return newDataset;

    }

    private class ReceiverListModel extends DefaultListModel {
        private List<Receiver> receivers = new ArrayList();

        @Override
        public void clear() {
            receivers.clear();
            fireContentsChanged(this, 0, 0);
        }

        public void addAll(Collection newData) {
            receivers.addAll(newData);
            fireContentsChanged(this, 0, 0);
        }

        @Override
        public int getSize() {
            return receivers.size();
        }

        @Override
        public Object getElementAt(int index) {
            return receivers.get(index);
        }

        @Override
        public Receiver get(int index){
            return receivers.get(index);
        }

        public List<Receiver> getReceivers(){
            return receivers;
        }
    }

    private class ReceiverListCellRenderer extends JLabel implements ListCellRenderer {

        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {

            Receiver r = receiverListModel.get(index);

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setOpaque(true);
            setText(r.getId());

            return this;
        }
    }

    private class ResponseListModel extends DefaultListModel {
        List<Response> responses = new ArrayList();

        @Override
        public void clear() {
            responses.clear();
            fireContentsChanged(this, 0, 0);
        }

        public void add(Response newData) {
            responses.add(newData);
            fireContentsChanged(this, getSize()-2, getSize()-1);
        }

        @Override
        public int getSize() {
            return responses.size();
        }

        @Override
        public Object getElementAt(int index) {
            return responses.get(index);
        }
    }

    private class BasicResponseListener implements ResponseListener {

        public BasicResponseListener() {
        }

        public void responseReceived(Response response) {
            responseListModel.add(response);

            if (response.getReceiverId() == null ||
                    response.getResponse() == null ||
                    response.getResponse().equals("?")) {
                return;
            }

//            if (!dataset.getColumnKeys().contains(response.getResponse()))
//                System.out.println(response);
            Number count = dataset.getValue(response.getReceiverId(), response.getResponse());
            if (count == null) {
                count = new Integer(1);
            }
            dataset.incrementValue(1, response.getReceiverId(), response.getResponse());
        }
    }

    private class SetChannelAction extends AbstractAction {

        public SetChannelAction() {
            putValue(Action.NAME, "Set Channel");
            putValue(Action.LONG_DESCRIPTION, "Set Channel");
        }

        public void actionPerformed(ActionEvent arg0) {
            try {

                int index =
                        receiverList.getSelectionModel().getAnchorSelectionIndex();
                if (index < 0) {
                    return;
                }
                List<Receiver> receivers = receiverListModel.getReceivers();
                Receiver r = receivers.get(index);
                String channel = JOptionPane.showInputDialog("Please enter the new channel:");
                if (channel == null) {
                    return;
                }
                r.setChannel(Integer.parseInt(channel));
                lblChannel.setText(Integer.toString(r.getChannel()));

            } catch (Exception ex) {
                Logger.getLogger(PollingTest.class.getName()).log(
                        Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Could not set the channel.");
            }
        }
    }
}
