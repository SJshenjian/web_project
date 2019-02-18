package online.shenjian.tio.im.common;

import online.shenjian.tio.im.common.packets.Command;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Jian Shen
 * @version V1.0
 * @date 2018/11/3
 */
public class CommandStat {
    public static final Map<Command, CommandStat> commandAndCount = new ConcurrentHashMap<>();

    public final AtomicLong handled = new AtomicLong();
    public final AtomicLong received = new AtomicLong();
    public final AtomicLong sent = new AtomicLong();

    public static CommandStat getCount(Command command) {
        if (command == null) {
            return null;
        }

        // The reason designing this is ?
        CommandStat commandStat = commandAndCount.get(command);
        if (commandStat != null) {
            return commandStat;
        }
        synchronized (commandAndCount) {
            commandStat = commandAndCount.get(command);
            if (commandStat != null) {
                return commandStat;
            }
            commandStat = new CommandStat();
            commandAndCount.put(command, commandStat);
        }
        return commandStat;
    }

    public AtomicLong getHandled() {
        return handled;
    }

    public AtomicLong getReceived() {
        return received;
    }

    public AtomicLong getSent() {
        return sent;
    }
}
