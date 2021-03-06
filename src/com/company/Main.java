package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    public static void main(String[] args) {
        new Main("СЛАВА ЧТО ТЫ СДЕЛАЛ???????????????????????????????");
    }

    public Main(String title) {
        super(title);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Tab 1", new ImageIcon("img/5.jpg"), new Card1(), "СЛАВА");
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
        tabbedPane.addTab("Tab 2", new ImageIcon("img/8.jpg"), new Card2(), "ЧТО ТЫ");
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        tabbedPane.addTab("Tab 3", new ImageIcon("img/76.jpg"), new Card3(), "СДЕЛАЛ");
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        add(tabbedPane);

        pack();
        setVisible(true);
    }

    class Card1 extends JPanel {
        public Card1() {
            setLayout(new BorderLayout());
            JPanel central = new JPanel();
            central.setLayout(new BorderLayout());

            JButton right = new JButton(new ImageIcon("img/left.png"));
            central.add(right, BorderLayout.NORTH);
            JButton left = new JButton(new ImageIcon("img/right.png"));
            central.add(left, BorderLayout.SOUTH);
            add(central, BorderLayout.CENTER);

            final String[] DATA1 = {"Клип за 10 лямов", "el problema", "cadillac ", "WATAFUCK?!",
                    "Быстро", "Lollipop", "PATATATATA", "Мне пох", "Ice",
                    "Новый мерин", "Young Hufner"
            };

            final String[] DATA2 = {"Грутсная песня", "ОНА - ОНО", "Пососи", "ЧИЧА",
                    "УФФ... Деньги", "ЧЕТЫРЕ УКРАИНКИ", "Я ПЫЛЬ",
            };

            DefaultListModel leftlistModel = new DefaultListModel();
            JList leftlist = new JList(leftlistModel);
            leftlist.setFont(new Font(getFont().getFontName(), Font.PLAIN, 17));
            DefaultListModel rightlistModel = new DefaultListModel();
            JList rightlist = new JList(rightlistModel);
            rightlist.setFont(new Font(getFont().getFontName(), Font.PLAIN, 17));

            for (String el : DATA1)
                leftlistModel.addElement(el);

            for (String el : DATA2)
                rightlistModel.addElement(el);

            add(leftlist, BorderLayout.WEST);
            add(new JScrollPane(leftlist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.WEST);
            add(rightlist, BorderLayout.EAST);
            add(new JScrollPane(rightlist, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.EAST);


            right.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!leftlist.isSelectionEmpty()) {

                        while(leftlist.getSelectedIndex() >= 0) {
                            rightlistModel.addElement(leftlist.getSelectedValue());
                            leftlistModel.remove(leftlist.getSelectedIndex());

                        }
                        if (!leftlistModel.isEmpty())
                            leftlist.setSelectedIndex(0);
                    }
                }
            });
            left.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!rightlist.isSelectionEmpty()) {
                        while(rightlist.getSelectedIndex() >= 0) {
                            leftlistModel.addElement(rightlist.getSelectedValue());
                            rightlistModel.remove(rightlist.getSelectedIndex());
                        }
                        if (!rightlistModel.isEmpty())
                            rightlist.setSelectedIndex(0);
                    }
                }
            });
            pack();
            //setPreferredSize(new Dimension(500, 300));
        }
    }

    class Card2 extends JPanel implements MouseListener {
        private Color oldBtnColor;
        private String oldName;
        private final int T = 8;
        private final int PX = 70;
        public Card2() {
            setLayout(new GridLayout(T, T));
            for (int i = 0; i < T; i++)
                for (int j = 0; j < T; j++) {
                    JButton bn = new JButton(i*T+j+1+"");
                    bn.addMouseListener(this);
                    add(bn);
                }
            setPreferredSize(new Dimension(PX*T,PX*T));
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            JButton tmp = ((JButton) e.getSource());
            oldName = tmp.getText();
            tmp.setText("click!");
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            JButton tmp = ((JButton) e.getSource());
            tmp.setText(oldName);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton tmp = ((JButton) e.getSource());
            oldBtnColor = tmp.getBackground();
            tmp.setBackground(Color.BLUE);
            tmp.setOpaque(true);            // for working with mac os!
            tmp.setForeground(Color.BLUE);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton tmp = ((JButton) e.getSource());
            tmp.setBackground(oldBtnColor);
            tmp.setForeground(Color.BLACK);
        }
    }

    class Card3 extends JPanel {
        public Card3() {
            Box box = new Box(1);
            ButtonGroup radioGroup = new ButtonGroup();
            final ImageIcon[] icons = new ImageIcon[] {
                    new ImageIcon("img/1.jpg"),
                    new ImageIcon("img/3.jpg"),
                    new ImageIcon("img/4.jpg"),
                    new ImageIcon("img/6.jpg"),
            };

            for (int i = 0; i < 4; i++) {
                JRadioButton temp = new JRadioButton(icons[0]);
                temp.setPressedIcon(icons[1]);
                temp.setRolloverIcon(icons[2]);
                temp.setSelectedIcon(icons[3]);
                radioGroup.add(temp);
                box.add(temp);
            }
            add(box);
        }
    }
}