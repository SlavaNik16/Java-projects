import javax.swing.*;
import java.io.IOException;

public class GameSin {
	String userData;
	public static void main(String[] args) throws IOException {
		String userData = JOptionPane.showInputDialog("Выберите через какую теорему будете находить треугольник: \n true (sin(хотя бы два угла и одна сторона(две стороны))) \n false (cos(хотя бы один угол и две стороны(три) или только три стороны ))");
		String q = userData;
		if (q.equals("true")) {
			String userData1 = JOptionPane.showInputDialog("Введите сторону BC(A): ");
			double A = Integer.parseInt(userData1);
			String userData2 = JOptionPane.showInputDialog("Введите сторону AC(B): ");
			double B = Integer.parseInt(userData2);
			String userData3 = JOptionPane.showInputDialog("Введите сторону AB(C): ");
			double C = Integer.parseInt(userData3);
			String userData4 = JOptionPane.showInputDialog("Введите угол a: ");
			double a = Integer.parseInt(userData4);
			String userData5 = JOptionPane.showInputDialog("Введите угол b: ");
			double b = Integer.parseInt(userData5);
			String userData6 = JOptionPane.showInputDialog("Введите угол c: ");
			double c = Integer.parseInt(userData6);
			String userData7 = JOptionPane.showInputDialog("Введите радиус: ");
			double R = Integer.parseInt(userData7);
			double r = 2*R;

			if (a == 0 && b != 0 && c != 0) {
				a = 180 - b - c;
			} else if (a != 0 && b == 0 && c != 0) {
				b = 180 - a - c;
			} else if (a != 0 && b != 0 && c == 0) {
				c = 180 - a - b;
			} else {}
			
			if (a + b + c != 180) {
				JOptionPane.showMessageDialog(null,"Ошибка! Сумма углов должна быть равна 180 градусов!");
				System.exit(0);
			}
			double aa = (Math.sin(Math.toRadians(a)));
			double bb = (Math.sin(Math.toRadians(b)));
			double cc = (Math.sin(Math.toRadians(c)));

			double res_a = ((double) Math.round(aa * 10000d)) / 10000d;
			double res_b = ((double) Math.round(bb * 10000d)) / 10000d;
			double res_c = ((double) Math.round(cc * 10000d)) / 10000d;

			if(A == 0 && B == 0 && C == 0 && r != 0) {
				A = aa * r;
				B = bb * r;
				C = cc * r;
			}
			if (r != 0 && A == 0 && B == 0) {
				A = aa * r;
				B = bb * r;
			} 
			if (r != 0 && B == 0 && C == 0) {
				B = bb * r;
				C = cc * r;
			} 
			if (r != 0 && C == 0 && A == 0 || A == 0) {
				A = aa * r;
				C = cc * r;
			} 
			if (A == 0 && B != 0 && C != 0) {
				A = (double) ((B * res_a) / res_b);
			} else if (A != 0 && B == 0 && C != 0) {
				B = (double) ((A * res_b) / res_a);
			} else if (A != 0 && B != 0 && C == 0) {
				C = (double) ((A * res_c) / res_a);
			}
			if (A == 0 && B == 0 && C != 0) {
				A = (double) ((C * res_a) / res_c);
				B = (double) ((C * res_b) / res_c);
			} else if (A == 0 && B != 0 && C == 0) {
				A = (double) ((B * res_a) / res_b);
				C = (double) ((B * res_c) / res_b);
			} else if (A != 0 && B == 0 && C == 0) {
				B = (double) ((A * res_b) / res_a);
				C = (double) ((A * res_c) / res_a);
			}
			System.out.println(a + "" + b + "" + c);
			if(((A+B)<C || ((A+C)<B) || ((B+C)<A)) && r == 0) {
				JOptionPane.showMessageDialog(null,"Такого треугольника не существует");
				System.exit(0);
			}
			JOptionPane.showMessageDialog(null,"Сторона BC(A) = " + A);
			JOptionPane.showMessageDialog(null,"Сторона AC(B) = " + B);
			JOptionPane.showMessageDialog(null,"Сторона AB(C) = " + C);
			JOptionPane.showMessageDialog(null,"Угол а = " + a);
			JOptionPane.showMessageDialog(null,"Угол b = " + b);
			JOptionPane.showMessageDialog(null,"Угол с = " + c);
		}else if(q.equals("false")){
			String userData1 = JOptionPane.showInputDialog("Введите сторону BC(A): ");
			double A = Integer.parseInt(userData1);
			String userData2 = JOptionPane.showInputDialog("Введите сторону AC(C): ");
			double B = Integer.parseInt(userData2);
			String userData3 = JOptionPane.showInputDialog("Введите сторону AB(C): ");
			double C = Integer.parseInt(userData3);

			String userData4 = JOptionPane.showInputDialog("Введите угол a: ");
			double a = Integer.parseInt(userData4);
			String userData5 = JOptionPane.showInputDialog("Введите угол b: ");
			double b = Integer.parseInt(userData5);
			String userData6 = JOptionPane.showInputDialog("Введите угол c: ");
			double c = Integer.parseInt(userData6);
			
			if (a == 0 && b != 0 && c != 0) {
				a = 180 - b - c;
			} else if (a != 0 && b == 0 && c != 0) {
				b = 180 - a - c;
			} else if (a != 0 && b != 0 && c == 0) {
				c = 180 - a - b;
			} else {

			}
			if (a == 0 && b == 0 && c == 0 && A != 0 && B != 0 && C != 0) {
				a = ((B * B) + (C * C) - (A * A)) / (2 * B * C);
				b = ((A * A) + (C * C) - (B * B)) / (2 * A * C);
				c = ((A * A) + (B * B) - (C * C)) / (2 * A * B);
				double res_a = (Math.cos(Math.toRadians(a)));
				double res_b = (Math.cos(Math.toRadians(b)));
				double res_c = (Math.cos(Math.toRadians(c)));
				if (a == 0 && b == 0 && c != 0 && A != 0 && B != 0 && C == 0) {
					C = Math.sqrt((A * A) + (B * B) - 2 * A * B * res_c);
				} else if (a == 0 && b != 0 && c == 0 && A != 0 && B == 0 && C != 0) {
					B = Math.sqrt((A * A) + (C * C) - 2 * A * C * res_b);
				} else if (a != 0 && b == 0 && c == 0 && A == 0 && B != 0 && C != 0) {
					A = Math.sqrt((B * B) + (C * C) - 2 * B * C * res_a);
				}else  if (a != 0 && b != 0 && c != 0 && A != 0 && B != 0 && C != 0){

				} else {
					JOptionPane.showMessageDialog(null,"Ошибка! Неправильно введены данные!");
					System.exit(0);
				}
				if((A+B)<C || ((A+C)<B) || ((B+C)<A)) {
					JOptionPane.showMessageDialog(null,"Такого треугольника не существует");
					System.exit(0);
				}
				if (a + b + c != 180) {
					JOptionPane.showMessageDialog(null,"Ошибка! Сумма углов должна быть равна 180 градусов!");
					System.exit(0);
				}
				JOptionPane.showMessageDialog(null,"Сторона BC = " + A);
				JOptionPane.showMessageDialog(null,"Сторона AC = " + B);
				JOptionPane.showMessageDialog(null,"Сторона AB = " + C);
				JOptionPane.showMessageDialog(null,"Угол а = " + a);
				JOptionPane.showMessageDialog(null,"Угол b = " + b);
				JOptionPane.showMessageDialog(null,"Угол с = " + c);
			} else {
				double res_a = (Math.cos(Math.toRadians(a)));
				double res_b = (Math.cos(Math.toRadians(b)));
				double res_c = (Math.cos(Math.toRadians(c)));
				
				if (a == 0 && b == 0 && c != 0 && A != 0 && B != 0 && C == 0) {
					C = Math.sqrt((A * A) + (B * B) - 2 * A * B * res_c);
				} else if (a == 0 && b != 0 && c == 0 && A != 0 && B == 0 && C != 0) {
					B = Math.sqrt((A * A) + (C * C) - 2 * A * C * res_b);
				} else if (a != 0 && b == 0 && c == 0 && A == 0 && B != 0 && C != 0) {
					A = Math.sqrt((B * B) + (C * C) - 2 * B * C * res_a);
				} else {
					JOptionPane.showMessageDialog(null,"Ошибка! Неправильно введены данные!");
					System.exit(0);
				}
				if((A+B)<C || ((A+C)<B) || ((B+C)<A)) {
					JOptionPane.showMessageDialog(null,"Такого треугольника не существует");
					System.exit(0);
				}
				JOptionPane.showMessageDialog(null,"Сторона BC = " + A);
				JOptionPane.showMessageDialog(null,"Сторона AC = " + B);
				JOptionPane.showMessageDialog(null,"Сторона AB = " + C);
				JOptionPane.showMessageDialog(null,"Угол а = " + a);
				JOptionPane.showMessageDialog(null,"Угол b = " + b);
				JOptionPane.showMessageDialog(null,"Угол с = " + c);
			}
		}else{
			JOptionPane.showMessageDialog(null,"Ошибка!");
			System.exit(0);
		}
	}
}