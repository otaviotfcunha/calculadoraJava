package view;

import library.CalculadoraException;
import model.Calculadora;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class TelaCalculadora extends JFrame implements ActionListener {

    protected Dimension dFrame, dTextField, dButtonNums, dButtonVariaveis, dButtonIgual, dLabel, dButtonSair;
    protected Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPonto, btnMais, btnMenos, btnDivide, btnMultiplica, btnIgual, btnCe, btnAc, btnSair;
    protected TextField txtValor;

    protected Label lblInfo;

    private double valorFinal;
    private boolean primeiroPasso;

    private boolean resetCampo;
    private String ultimaEquacao;
    Calculadora calculadora = new Calculadora();

    public TelaCalculadora(){
        valorFinal = 0;
        resetCampo = false;
        ultimaEquacao = "";
        primeiroPasso = true;

        //Dimensões
        dFrame = new Dimension(500, 500);
        dTextField = new Dimension(450, 50);
        dButtonNums = new Dimension(75, 75);
        dButtonVariaveis = new Dimension(100, 75);
        dButtonIgual = new Dimension(205, 75);
        dButtonSair = new Dimension(35, 20);
        dLabel = new Dimension(415, 20);

        //Definição das propriedades da Janela Principal
        setTitle("Calculadora em Java");
        setResizable(false);
        setSize(dFrame);
        setLocationRelativeTo(null);
        setLayout(null);

        txtValor = new TextField(null);
        txtValor.setSize(dTextField);
        txtValor.setEditable(false);
        txtValor.setForeground(Color.black);
        txtValor.setBackground(Color.white);
        txtValor.setFont(new Font("Arial",1, 20));
        txtValor.setLocation(20, 25);
        add(txtValor);

        btn1 = new Button("1");
        btn1.setSize(dButtonNums);
        btn1.setLocation(20, 100);
        btn1.addActionListener(this);
        add(btn1);

        btn2 = new Button("2");
        btn2.setSize(dButtonNums);
        btn2.setLocation(100, 100);
        btn2.addActionListener(this);
        add(btn2);

        btn3 = new Button("3");
        btn3.setSize(dButtonNums);
        btn3.setLocation(180, 100);
        btn3.addActionListener(this);
        add(btn3);

        btnAc = new Button("AC");
        btnAc.setSize(dButtonVariaveis);
        btnAc.setLocation(265, 100);
        btnAc.addActionListener(this);
        add(btnAc);

        btnCe = new Button("CE");
        btnCe.setSize(dButtonVariaveis);
        btnCe.setLocation(370, 100);
        btnCe.addActionListener(this);
        add(btnCe);

        btn4 = new Button("4");
        btn4.setSize(dButtonNums);
        btn4.setLocation(20, 180);
        btn4.addActionListener(this);
        add(btn4);

        btn5 = new Button("5");
        btn5.setSize(dButtonNums);
        btn5.setLocation(100, 180);
        btn5.addActionListener(this);
        add(btn5);

        btn6 = new Button("6");
        btn6.setSize(dButtonNums);
        btn6.setLocation(180, 180);
        btn6.addActionListener(this);
        add(btn6);

        btnMais = new Button("+");
        btnMais.setSize(dButtonVariaveis);
        btnMais.setLocation(265, 180);
        btnMais.addActionListener(this);
        add(btnMais);

        btnMenos = new Button("-");
        btnMenos.setSize(dButtonVariaveis);
        btnMenos.setLocation(370, 180);
        btnMenos.addActionListener(this);
        add(btnMenos);

        btn7 = new Button("7");
        btn7.setSize(dButtonNums);
        btn7.setLocation(20, 260);
        btn7.addActionListener(this);
        add(btn7);

        btn8 = new Button("8");
        btn8.setSize(dButtonNums);
        btn8.setLocation(100, 260);
        btn8.addActionListener(this);
        add(btn8);

        btn9 = new Button("9");
        btn9.setSize(dButtonNums);
        btn9.setLocation(180, 260);
        btn9.addActionListener(this);
        add(btn9);

        btnDivide = new Button("/");
        btnDivide.setSize(dButtonVariaveis);
        btnDivide.setLocation(265, 260);
        btnDivide.addActionListener(this);
        add(btnDivide);

        btnMultiplica = new Button("*");
        btnMultiplica.setSize(dButtonVariaveis);
        btnMultiplica.setLocation(370, 260);
        btnMultiplica.addActionListener(this);
        add(btnMultiplica);

        btn0 = new Button("0");
        btn0.setSize(dButtonNums);
        btn0.setLocation(100, 340);
        btn0.addActionListener(this);
        add(btn0);

        btnPonto = new Button(",");
        btnPonto.setSize(dButtonNums);
        btnPonto.setLocation(180, 340);
        btnPonto.addActionListener(this);
        add(btnPonto);

        btnIgual = new Button("=");
        btnIgual.setSize(dButtonIgual);
        btnIgual.setLocation(265, 340);
        btnIgual.addActionListener(this);
        add(btnIgual);

        lblInfo = new Label("Calculadora em JAVA - Aluno: Otavio T. F. da Cunha - Prof: Maromo", 1);
        lblInfo.setSize(dLabel);
        lblInfo.setLocation(20, 430);
        add(lblInfo);

        btnSair = new Button("Sair");
        btnSair.setSize(dButtonSair);
        btnSair.setLocation(435, 430);
        btnSair.addActionListener(this);
        add(btnSair);

    }
    private void concatena(String v){
        try{
            if(resetCampo){
                txtValor.setText(null);
                String txt = txtValor.getText();
                txt += v;
                txtValor.setText(txt);
                resetCampo = false;
            }else{
                String txt = txtValor.getText();
                txt += v;
                txtValor.setText(txt);
            }

        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO: ", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void insereValor(String x){

        if(primeiroPasso){

            try{
                valorFinal = Double.parseDouble(txtValor.getText());
                resetCampo = true;
                primeiroPasso = false;
                btnMais.setEnabled(false);
                btnMenos.setEnabled(false);
                btnDivide.setEnabled(false);
                btnMultiplica.setEnabled(false);

            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Número inválido para a operação.", "ERRO: ", JOptionPane.ERROR_MESSAGE);
            } catch(Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO: ", JOptionPane.ERROR_MESSAGE);
            }

        }else{
            try{
                double val1 = valorFinal;
                double val2 = Double.parseDouble(txtValor.getText());
                txtValor.setText(null);
                if(Objects.equals(x, "+")){
                    valorFinal = calculadora.somar(val1, val2);
                }else if(Objects.equals(x, "-")){
                    valorFinal = calculadora.subtrair(val1, val2);
                }else if(Objects.equals(x, "/")){
                    valorFinal = calculadora.dividir(val1, val2);
                }else if(Objects.equals(x, "*")){
                    valorFinal = calculadora.multiplicar(val1, val2);
                }else{
                    valorFinal = calculadora.somar(val1, val2);
                }
                btnMais.setEnabled(false);
                btnMenos.setEnabled(false);
                btnDivide.setEnabled(false);
                btnMultiplica.setEnabled(false);
                exibeValor(false);
                resetCampo = true;


            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO: ", JOptionPane.ERROR_MESSAGE);
            }
        }

    }
    private void exibeValor(boolean limpar){
        try{
            if(limpar){
                insereValor(ultimaEquacao);
                txtValor.setText(String.valueOf(valorFinal));
                valorFinal = 0;
                btn0.setEnabled(false);
                btn1.setEnabled(false);
                btn2.setEnabled(false);
                btn3.setEnabled(false);
                btn4.setEnabled(false);
                btn5.setEnabled(false);
                btn6.setEnabled(false);
                btn7.setEnabled(false);
                btn8.setEnabled(false);
                btn9.setEnabled(false);
                btnCe.setEnabled(false);
                btnIgual.setEnabled(false);
            }else{
                txtValor.setText(String.valueOf(valorFinal));
            }
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO: ", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSair){
            JOptionPane.showMessageDialog(null, "O programa será finalizado!", "Fim", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
        if(e.getSource() == btn0){
            try{
                concatena("0");
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO: ", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == btn1){
            concatena("1");
        }
        if(e.getSource() == btn2){
            concatena("2");
        }
        if(e.getSource() == btn3){
            concatena("3");
        }
        if(e.getSource() == btn4){
            concatena("4");
        }
        if(e.getSource() == btn5){
            concatena("5");
        }
        if(e.getSource() == btn6){
            concatena("6");
        }
        if(e.getSource() == btn7){
            concatena("7");
        }
        if(e.getSource() == btn8){
            concatena("8");
        }
        if(e.getSource() == btn9){
            concatena("9");
        }
        if(e.getSource() == btnPonto){
            concatena(".");
        }
        if(e.getSource() == btnAc){
            try{
                txtValor.setText(null);
                valorFinal = 0;
                primeiroPasso = true;
                btnMais.setEnabled(true);
                btnMenos.setEnabled(true);
                btnDivide.setEnabled(true);
                btnMultiplica.setEnabled(true);
                btn0.setEnabled(true);
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                btn5.setEnabled(true);
                btn6.setEnabled(true);
                btn7.setEnabled(true);
                btn8.setEnabled(true);
                btn9.setEnabled(true);
                btnCe.setEnabled(true);
                btnIgual.setEnabled(true);
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO: ", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == btnCe){
            try{
                txtValor.setText(null);
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO: ", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == btnMais){
            ultimaEquacao = "+";
            insereValor(ultimaEquacao);
        }
        if(e.getSource() == btnMenos){
            ultimaEquacao = "-";
            insereValor(ultimaEquacao);
        }
        if(e.getSource() == btnDivide){
            ultimaEquacao = "/";
            insereValor(ultimaEquacao);
        }
        if(e.getSource() == btnMultiplica){
            ultimaEquacao = "*";
            insereValor(ultimaEquacao);
        }
        if(e.getSource() == btnIgual){
            exibeValor(true);
        }

    }
}
