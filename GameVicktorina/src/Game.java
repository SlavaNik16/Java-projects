
import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import  java.util.*;

public class Game {

    public static void main(String[] args) {
int count = 0;
       String userData = JOptionPane.showInputDialog("Здравствуйте! Введите свое имя: ");
        String name = userData;
       String userData2 = JOptionPane.showInputDialog("Привет "+ name + " !В какую игру вы хотите сыграть: \n 1. Викторина. \n 2.Выход ");
        int a = Integer.parseInt(userData2);
        if (a == 1) {
            JOptionPane.showMessageDialog(null, "Я задам 16 вопросов , где каждые 4 вопроса буду повышать уровень сложности \n 1) легко \n 2) средний \n 3) сложный \n 4) невозможный \n Удачи!");
            JOptionPane.showMessageDialog(null, "За каждый правильный ответ ты зарабатываешь бал, за каждый неправильный теряешь.");
            JOptionPane.showMessageDialog(null, "1.Уровень: просто выбери правильный вариант.");
            String userData3 = JOptionPane.showInputDialog("Вопрос: 1 \n Какую реку, согласно пословице, можно перейти только в одном направлении? \n 1) Лена  \n 2) Рубикон \n 3) Объ \n 4) Енисей \n 5) Однапр ");
            int b = Integer.parseInt(userData3);
            if (b == 2) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n 2) Рубикон ");
                count--;
            }
            String userData4 = JOptionPane.showInputDialog("Вопрос: 2 \n  Коренные жители Бирмы выращивают свиней, продают их китайцам, а затем покупают у них свинину. К чему им такие невыгодные манипуляции? \n 1) Им запрещали убивать  \n 2) Было выгодно \n 3) Они были дураками \n 4) Они были вегетарианцами  \n 5) Просто так ");
            int с = Integer.parseInt(userData4);
            if (с == 1) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n 1) Им запрещали убивать ");
                count--;
            }

            String userData5 = JOptionPane.showInputDialog("Вопрос: 3 \n   В таиландской гостинице Непа Лодж деревья растут вокруг бассейна, и на каждом из них прикреплена табличка с текстом, советующим не ставить шезлонги в радиусе 1 м от ствола. Чего опасаются хозяева отеля? \n 1) Это была запрещенная террирория  \n 2) Там жили животные или насекомые \n 3) Им не нравилось, что люди подходят \n 4) Они были вегетарианцами  \n 5) Мог упасть кокос(орех) ");
            int d = Integer.parseInt(userData5);
            if (d == 5) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n 5) Мог упасть кокос(орех)  ");
                count--;
            }
            String userData6 = JOptionPane.showInputDialog("Вопрос: 4 \n   Вблизи г. Сантьяго-де-Куба, у самого входа в бухту, с XVII в. стоит величественная, мощная крепость Кастилио-дель Моро. В настоящее время она превращена в единственный в мире музей… Какой? \n 1) Исскуства  \n 2) Пиратства \n 3) Главный Штаб  \n 4) Военный \n 5) Русский ");
            int e = Integer.parseInt(userData6);
            if (e == 2) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n 2) Пиратства");
                count--;
            }
            JOptionPane.showMessageDialog(null, "Молодец! Ты ответил на 4 вопроса 1 уровня ");
            JOptionPane.showMessageDialog(null, "2. Уровень: Ответь одним словом(числом) на вопрос.");
            String userData7 = JOptionPane.showInputDialog("Вопрос: 5 \n  Мальчик заплатил за бутылку с пробкой 11 рублей. Бутылка стоит на 10 рублей больше, чем пробка. Сколько стоит пробка? ");
            int j = Integer.parseInt(userData7);
            if (j == 50) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n 50 копеек");
                count--;
            }
            String userData8 = JOptionPane.showInputDialog("Вопрос: 6 \n  Ничего не пишите и не используйте калькулятор. Возьмите 1000. Прибавьте 40. Прибавьте еще тысячу. Прибавьте 30. Еще 1000. Плюс 20. Плюс 1000. И плюс 10. Что получилось? ");
            int q = Integer.parseInt(userData8);
            if (q == 4100) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n 4100");
                count--;
            }
            String userData9 = JOptionPane.showInputDialog("Вопрос: 7 \n На столе лежит 100 листов бумаги. За каждые 10 секунд можно посчитать 10 листов. Сколько секунд понадобится, чтобы посчитать 80 листов?");
            int w = Integer.parseInt(userData9);
            if (w == 20) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n 20 листов");
                count--;
            }
            String userData10 = JOptionPane.showInputDialog("Вопрос: 8 \n Марина мечтала о шоколадке, но ей на покупку не хватало 10 рублей. Вася тоже мечтал о шоколадке, но ему не доставало всего 1 рубля. \n Дети решили купить хотя бы одну шоколадку на двоих, но им все равно не хватило 1 рубля. Какова стоимость шоколадки?");
            int r = Integer.parseInt(userData10);
            if (r == 10) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n 10 рублей");
                count--;
            }
            JOptionPane.showMessageDialog(null, "3. Уровень: написать слово  без большой буквы. Буква ё меняем на е .");
            String userData11 = JOptionPane.showInputDialog("Вопрос: 9 \n Банка стоит на столе. Стоит она так, что одна её половина находится в воздухе а другая на столе. Что лежит в банке, если через полчаса она упадёт?");
            String y = userData11;
            if (y.equals("лед")) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n лед");
                count--;
            }
            String userData12 = JOptionPane.showInputDialog("Вопрос: 10 \n К тебе пришли гости, а в холодильнике — бутылка лимонада, пакет с ананасовым соком и бутылка минеральной воды. Что ты откроешь в первую очередь? \n Если гости больше предпочитают лимонад, а твои родственники ананасовый сок. Сам же ты хочешь минеральной воды.");
            String u = userData12;
            if (u.equals("холодильник")) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n холодильник");
                count--;
            }
            String userData13 = JOptionPane.showInputDialog("Вопрос: 11 \n Джордж Вашингтон, Шерлок Холмс, Вильям Шекспир, Людвиг Ван Бетховен, Наполеон Бонапарт, Нерон — кто «лишний» в этом списке? \n Напиши ответ: фамилию с маленькой буквы ");
            String o = userData13;
            if (o.equals("холмс")) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n холмс");
                count--;
            }
            String userData14 = JOptionPane.showInputDialog("Вопрос: 12 \n Какую маленькую лошадку нужно поставить между двумя местоимениями, чтобы получилось название страны? ");
            String p = userData14;
            if (p.equals("пони")) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n пони");
                count--;
            }
            JOptionPane.showMessageDialog(null, "4. Уровень: Ты должен с маленькой буквы и с пробелами написать ответ(используя подсказки).");
            String userData15 = JOptionPane.showInputDialog("Подготовка: Напиши правильно фразу:  \n К Й Г А И\n" +
                    "Ы И О Н Б\n" +
                    "З Ч М Е Ю\n" +
                    "Я У Ш Т Л ");
            String i = userData15;
            if (i.equals("любите наш могучий язык")) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n любите наш могучий язык");
            }
            String userData16 = JOptionPane.showInputDialog("Вопрос: 13 \n Из какого крана нельзя помыть руки? (16 бит) ");
            String х = userData16;
            if (х.equals("из строительного")) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n из строительного");
                count--;
            }
            String userData17 = JOptionPane.showInputDialog("Вопрос: 14 \n У бога есть, у царя нет. У Бориса спереди, а у Глеба позади, У бабы две, а у девки ни одной! (7 бит)  ");
            String k = userData17;
            if (k.equals("буква б")) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n буква б");
                count--;
            }
            String userData18 = JOptionPane.showInputDialog("Вопрос: 15 \n Слово из 9 букв с 6 согласными подряд.  ");
            String m = userData18;
            if (m.equals("взбзднуть")) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n  взбзднуть");
                count--;
            }
            String userData19 = JOptionPane.showInputDialog("Вопрос: 16 \n В каком слове 3 буквы л и три буквы п?  ");
            String v = userData19;
            if (v.equals("параллелепипед")) {
                JOptionPane.showMessageDialog(null, "Молодец! Ты справился!");
                count++;
            } else {
                JOptionPane.showMessageDialog(null, "Простите! Вы не угадали. \n Правильный ответ: \n  параллелепипед");
                count--;
            }
            if(count <= 0){
                JOptionPane.showMessageDialog(null,"Ты не справился "+name+ " !" + "\n У тебя "+ count+ " балов!");
            }else {
                JOptionPane.showMessageDialog(null, "Ты справился " + name + " !" + "\n У тебя " + count + " балов!");
            }
        }else if (a == 2){
            System.exit(0);

        }

    }
}
