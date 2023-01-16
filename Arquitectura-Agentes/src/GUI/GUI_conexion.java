package GUI;

import claseCAR.CAR;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class GUI_conexion extends JFrame implements Serializable {
    private JPanel panel1;
    private JTextField txtModelName;
    private JTextField txtTransmission;
    private JTextField txtOdometerValue;
    private JTextField txtYearProduced;
    private JTextField txtEngineCapacity;
    private JTextField txtBodyType;
    private JRadioButton trueRadioButtonFeature1;
    private JRadioButton falseRadioButtonFeature1;
    private JRadioButton trueRadioButtonFeature2;
    private JRadioButton falseRadioButtonFeature2;
    private JRadioButton trueRadioButtonFeature4;
    private JRadioButton falseRadioButtonFeature4;
    private JTextField txtDrivetrain;
    private JRadioButton trueRadioButtonFeature3;
    private JRadioButton falseRadioButtonFeature3;
    private JRadioButton trueRadioButtonFeature5;
    private JRadioButton trueRadioButtonFeature6;
    private JRadioButton trueRadioButtonFeature7;
    private JRadioButton trueRadioButtonFeature8;
    private JRadioButton falseRadioButtonFeature5;
    private JRadioButton falseRadioButtonFeature6;
    private JRadioButton falseRadioButtonFeature7;
    private JRadioButton falseRadioButtonFeature8;
    private JPanel PanelArgs;
    private JButton btnInsertar;
    private JTextArea txtArea;
    private JRadioButton trueRadioButtonFeature9;
    private JRadioButton trueRadioButtonFeature0;
    private JRadioButton falseRadioButtonFeature9;
    private JRadioButton falseRadioButtonFeature0;
    private JRadioButton falseRadioButtonHasWarranty;
    private JRadioButton trueRadioButtonHasWarranty;

    private CAR closet;

    public CAR getCloset() {
        return closet;
    }

    public void setCloset(CAR closet) {
        this.closet = closet;
    }

    private boolean botonInsertar;

    public boolean isBotonInsertar() {
        return botonInsertar;
    }

    public void setBotonInsertar(boolean botonInsertar) {
        this.botonInsertar = botonInsertar;
    }

    private boolean pressBotonInsertar(){
        return true;
    }

    public void setTxtArea(String txtArea) {
        this.txtArea.append(txtArea);
    }

    public GUI_conexion(){
        //Init mainFrame
        setContentPane(PanelArgs);
        setTitle("Python-Java-GUI");
        setSize(1000,650);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        btnInsertar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Boton Insertar");
                String model_name, transmission, body_type, drivetrain;
                double engine_capacity;
                int feature_1, feature_2, feature_3, feature_4, feature_5, feature_6, feature_7, feature_8,feature_9,feature_0;
                int has_warranty,odometer_value,year_produced;

                model_name=txtModelName.getText();
                transmission=txtTransmission.getText();
                odometer_value=Integer.parseInt(txtOdometerValue.getText());
                year_produced=Integer.parseInt(txtYearProduced.getText());
                engine_capacity=Double.parseDouble(txtEngineCapacity.getText());
                body_type=txtBodyType.getText();
                if(trueRadioButtonHasWarranty.isSelected()){
                    has_warranty=1;
                } else {
                    has_warranty=0;
                }
                drivetrain=txtDrivetrain.getText();

                if(trueRadioButtonFeature1.isSelected()){
                    feature_1=1;
                } else {
                    feature_1=0;
                }
                if(trueRadioButtonFeature2.isSelected()){
                    feature_2=1;
                } else {
                    feature_2=0;
                }
                if(trueRadioButtonFeature3.isSelected()){
                    feature_3=1;
                } else {
                    feature_3=0;
                }
                if(trueRadioButtonFeature4.isSelected()){
                    feature_4=1;
                } else {
                    feature_4=0;
                }
                if(trueRadioButtonFeature5.isSelected()){
                    feature_5=1;
                } else {
                    feature_5=0;
                }
                if(trueRadioButtonFeature6.isSelected()){
                    feature_6=1;
                } else {
                    feature_6=0;
                }
                if(trueRadioButtonFeature7.isSelected()){
                    feature_7=1;
                } else {
                    feature_7=0;
                }
                if(trueRadioButtonFeature8.isSelected()){
                    feature_8=1;
                } else {
                    feature_8=0;
                }
                if(trueRadioButtonFeature9.isSelected()){
                    feature_9=1;
                } else {
                    feature_9=0;
                }
                if(trueRadioButtonFeature0.isSelected()){
                    feature_0=1;
                } else {
                    feature_0=0;
                }
                txtArea.setText(null);
                setCloset(new CAR(model_name, transmission, odometer_value, year_produced, engine_capacity, body_type, has_warranty, drivetrain, feature_0, feature_1, feature_2, feature_3, feature_4, feature_5, feature_6, feature_7, feature_8, feature_9 ));
                botonInsertar=true;
            }
        });
    }
}

