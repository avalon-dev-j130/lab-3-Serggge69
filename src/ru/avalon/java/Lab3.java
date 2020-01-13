package ru.avalon.java;

import ru.avalon.java.console.ConsoleUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileMoveAction;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI {
    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {
//        try {
//            
//            //new FileCopyAction("README.md", "README2.md").start();
//            //new FileMoveAction("README2.md", "README5.md").start();
//            Commands cmd = new Commands("copy README.md README3.md");
//            System.out.println("Команда " + cmd.toString() + " ");
//        } catch (IllegalCommand ex) {
//            System.out.println("Ошибка: " + ex.getMessage());
//        }
        new Lab3().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Lab3() {
//        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) {
        switch (command.comm) {
            case copy:
                new FileCopyAction(command.param[0], command.param[1]).start();
                System.out.println("onCommand отработал для copy");
                break;
            case move:
                new FileMoveAction(command.param[0], command.param[1]).start();
                System.out.println("onCommand отработал для move");
                break;
            case exit:
                close();
                break;
            default:
                System.out.println("Плохая команда");
                /*
                 * TODO №9 Обработайте необработанные команды
                 */
        }
    }
    
}
