
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import  java.util.*;

public class Game {

    public static void main(String[] args) {
int count = 0;
       String userData = JOptionPane.showInputDialog("������������! ������� ���� ���: ");
        String name = userData;
       String userData2 = JOptionPane.showInputDialog("������ "+ name + " !� ����� ���� �� ������ �������: \n 1. ���������. \n 2.����� ");
        int a = Integer.parseInt(userData2);
        if (a == 1) {
            JOptionPane.showMessageDialog(null, "� ����� 16 �������� , ��� ������ 4 ������� ���� �������� ������� ��������� \n 1) ����� \n 2) ������� \n 3) ������� \n 4) ����������� \n �����!");
            JOptionPane.showMessageDialog(null, "�� ������ ���������� ����� �� ������������� ���, �� ������ ������������ �������.");
            JOptionPane.showMessageDialog(null, "1.�������: ������ ������ ���������� �������.");
            String userData3 = JOptionPane.showInputDialog("������: 1 \n ����� ����, �������� ���������, ����� ������� ������ � ����� �����������? \n 1) ����  \n 2) ������� \n 3) ��� \n 4) ������ \n 5) ������ ");
            int b = Integer.parseInt(userData3);
            if (b == 2) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n 2) ������� ");
                count--;
            }
            String userData4 = JOptionPane.showInputDialog("������: 2 \n  �������� ������ ����� ���������� ������, ������� �� ��������, � ����� �������� � ��� �������. � ���� �� ����� ���������� �����������? \n 1) �� ��������� �������  \n 2) ���� ������� \n 3) ��� ���� �������� \n 4) ��� ���� ��������������  \n 5) ������ ��� ");
            int � = Integer.parseInt(userData4);
            if (� == 1) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n 1) �� ��������� ������� ");
                count--;
            }

            String userData5 = JOptionPane.showInputDialog("������: 3 \n   � ����������� ��������� ���� ���� ������� ������ ������ ��������, � �� ������ �� ��� ����������� �������� � �������, ���������� �� ������� �������� � ������� 1 � �� ������. ���� ��������� ������� �����? \n 1) ��� ���� ����������� ����������  \n 2) ��� ���� �������� ��� ��������� \n 3) �� �� ���������, ��� ���� �������� \n 4) ��� ���� ��������������  \n 5) ��� ������ �����(����) ");
            int d = Integer.parseInt(userData5);
            if (d == 5) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n 5) ��� ������ �����(����)  ");
                count--;
            }
            String userData6 = JOptionPane.showInputDialog("������: 4 \n   ������ �. ��������-��-����, � ������ ����� � �����, � XVII �. ����� ��������������, ������ �������� ��������-���� ����. � ��������� ����� ��� ���������� � ������������ � ���� ����� �����? \n 1) ���������  \n 2) ��������� \n 3) ������� ����  \n 4) ������� \n 5) ������� ");
            int e = Integer.parseInt(userData6);
            if (e == 2) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n 2) ���������");
                count--;
            }
            JOptionPane.showMessageDialog(null, "�������! �� ������� �� 4 ������� 1 ������ ");
            JOptionPane.showMessageDialog(null, "2. �������: ������ ����� ������(������) �� ������.");
            String userData7 = JOptionPane.showInputDialog("������: 5 \n  ������� �������� �� ������� � ������� 11 ������. ������� ����� �� 10 ������ ������, ��� ������. ������� ����� ������? ");
            int j = Integer.parseInt(userData7);
            if (j == 50) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n 50 ������");
                count--;
            }
            String userData8 = JOptionPane.showInputDialog("������: 6 \n  ������ �� ������ � �� ����������� �����������. �������� 1000. ��������� 40. ��������� ��� ������. ��������� 30. ��� 1000. ���� 20. ���� 1000. � ���� 10. ��� ����������? ");
            int q = Integer.parseInt(userData8);
            if (q == 4100) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n 4100");
                count--;
            }
            String userData9 = JOptionPane.showInputDialog("������: 7 \n �� ����� ����� 100 ������ ������. �� ������ 10 ������ ����� ��������� 10 ������. ������� ������ �����������, ����� ��������� 80 ������?");
            int w = Integer.parseInt(userData9);
            if (w == 20) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n 20 ������");
                count--;
            }
            String userData10 = JOptionPane.showInputDialog("������: 8 \n ������ ������� � ���������, �� �� �� ������� �� ������� 10 ������. ���� ���� ������ � ���������, �� ��� �� ��������� ����� 1 �����. \n ���� ������ ������ ���� �� ���� ��������� �� �����, �� �� ��� ����� �� ������� 1 �����. ������ ��������� ���������?");
            int r = Integer.parseInt(userData10);
            if (r == 10) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n 10 ������");
                count--;
            }
            JOptionPane.showMessageDialog(null, "3. �������: �������� �����  ��� ������� �����. ����� � ������ �� � .");
            String userData11 = JOptionPane.showInputDialog("������: 9 \n ����� ����� �� �����. ����� ��� ���, ��� ���� � �������� ��������� � ������� � ������ �� �����. ��� ����� � �����, ���� ����� ������� ��� �����?");
            String y = userData11;
            if (y.equals("���")) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n ���");
                count--;
            }
            String userData12 = JOptionPane.showInputDialog("������: 10 \n � ���� ������ �����, � � ������������ � ������� ��������, ����� � ���������� ����� � ������� ����������� ����. ��� �� �������� � ������ �������? \n ���� ����� ������ ������������ �������, � ���� ������������ ���������� ���. ��� �� �� ������ ����������� ����.");
            String u = userData12;
            if (u.equals("�����������")) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n �����������");
                count--;
            }
            String userData13 = JOptionPane.showInputDialog("������: 11 \n ������ ���������, ������ �����, ������ �������, ������ ��� ��������, �������� ��������, ����� � ��� ������� � ���� ������? \n ������ �����: ������� � ��������� ����� ");
            String o = userData13;
            if (o.equals("�����")) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n �����");
                count--;
            }
            String userData14 = JOptionPane.showInputDialog("������: 12 \n ����� ��������� ������� ����� ��������� ����� ����� �������������, ����� ���������� �������� ������? ");
            String p = userData14;
            if (p.equals("����")) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n ����");
                count--;
            }
            JOptionPane.showMessageDialog(null, "4. �������: �� ������ � ��������� ����� � � ��������� �������� �����(��������� ���������).");
            String userData15 = JOptionPane.showInputDialog("����������: ������ ��������� �����:  \n � � � � �\n" +
                    "� � � � �\n" +
                    "� � � � �\n" +
                    "� � � � � ");
            String i = userData15;
            if (i.equals("������ ��� ������� ����")) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n ������ ��� ������� ����");
            }
            String userData16 = JOptionPane.showInputDialog("������: 13 \n �� ������ ����� ������ ������ ����? (16 ���) ");
            String � = userData16;
            if (�.equals("�� �������������")) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n �� �������������");
                count--;
            }
            String userData17 = JOptionPane.showInputDialog("������: 14 \n � ���� ����, � ���� ���. � ������ �������, � � ����� ������, � ���� ���, � � ����� �� �����! (7 ���)  ");
            String k = userData17;
            if (k.equals("����� �")) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n ����� �");
                count--;
            }
            String userData18 = JOptionPane.showInputDialog("������: 15 \n ����� �� 9 ���� � 6 ���������� ������.  ");
            String m = userData18;
            if (m.equals("���������")) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n  ���������");
                count--;
            }
            String userData19 = JOptionPane.showInputDialog("������: 16 \n � ����� ����� 3 ����� � � ��� ����� �?  ");
            String v = userData19;
            if (v.equals("��������������")) {
                JOptionPane.showMessageDialog(null, "�������! �� ���������!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "��������! �� �� �������. \n ���������� �����: \n  ��������������");
                count--;
            }
            if(count <= 0){
                JOptionPane.showMessageDialog(null,"�� �� ��������� "+name+ " !" + "\n � ���� "+ count+ " �����!");
            }else {
                JOptionPane.showMessageDialog(null, "�� ��������� " + name + " !" + "\n � ���� " + count + " �����!");
            }
        }else if (a == 2){
            System.exit(0);

        }

    }
}
