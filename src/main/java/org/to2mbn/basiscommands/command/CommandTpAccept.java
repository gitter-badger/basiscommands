package org.to2mbn.basiscommands.command;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import org.to2mbn.basiscommands.BasisCommands;
import org.to2mbn.basiscommands.teleportrequest.TeleportRequest;
import org.to2mbn.basiscommands.utils.command.CommandArgumentTemplet;
import org.to2mbn.basiscommands.utils.command.CommandArguments;

public class CommandTpAccept implements Command {
    @Override
    public String getName() {
        return "tpaccept";
    }

    @Override
    public boolean canExecute(CommandSender sender) {
        return sender instanceof Player;
    }

    @Override
    public CommandArgumentTemplet<?>[] getArgumentTemplets() {
        return new CommandArgumentTemplet<?>[0];
    }

    @Override
    public void execute(CommandSender sender, CommandArguments args) {
        Player player = (Player) sender;
        TeleportRequest request = BasisCommands.getTeleportRequestsHandler().pickRequest(player);

        if (request != null) {
            Player requestPlayer = request.getRequestPlayer();
            requestPlayer.teleportImmediate(player.getPosition());

            requestPlayer.sendMessage(player.getName() + " accepted your request");
            player.sendMessage("Accepted " + requestPlayer.getName() + " to teleport to you");
        }
    }
}