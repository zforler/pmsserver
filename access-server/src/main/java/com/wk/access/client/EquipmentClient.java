package com.wk.access.client;

import com.wk.access.server.connection.Client;
import io.netty.channel.Channel;


public class EquipmentClient extends Client {

    public EquipmentClient() {
    }


    @Override
    public void disconnected(Channel ch) {
        super.disconnected(ch);
    }
}
