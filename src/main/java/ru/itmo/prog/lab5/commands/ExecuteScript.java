package ru.itmo.prog.lab5.commands;

import ru.itmo.prog.lab5.managers.CommandManager;
import ru.itmo.prog.lab5.utils.InputFormat;
import ru.itmo.prog.lab5.utils.Runner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Класс команды execute_script
 *
 * @author ldpst
 */
public class ExecuteScript extends Command {

    public ExecuteScript(CommandManager commandManager) {
        super("execute_script file_name", "считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме", commandManager);
        collectionManager = commandManager.getCollectionManager();
    }

    @Override
    public void run(String[] args) {
        if (args.length != 2) {
            stream.printErr("Неверный формат команды\n");
            return;
        }
        if (Runner.usedScripts.contains(args[1])) {
            stream.printErr("Запуск скрипта " + args[1] + " вызывает рекурсию\n");
            System.exit(1);
        }
        Runner.usedScripts.add(args[1]);
        try (FileInputStream fis = new FileInputStream(args[1])) {
            stream.printSuccess("Выполнение скрипта\n");
            new Runner(stream, collectionManager, fis, InputFormat.FILE).run();
            Runner.usedScripts.remove(args[1]);
            stream.printSuccess("Скрипт успешно выполнен\n");
        } catch (FileNotFoundException e) {
            stream.printErr("Файл со скриптом не найден\n");
        } catch (NullPointerException e) {
            stream.printErr("\nВ скрипте отсутствует команда exit. Программа завершена\n");
            System.exit(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
