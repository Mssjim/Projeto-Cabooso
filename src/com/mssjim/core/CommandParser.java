package com.mssjim.core;

import java.util.ArrayList;

import com.mssjim.utils.Utils;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandParser {

    public commandContainer parse(String raw, MessageReceivedEvent event) {
        String beheaded = raw.replaceFirst(Utils.getPrefix, "");
        String[] splitbeheaded = beheaded.split(" ");
        String invoke = splitbeheaded[0];
        ArrayList<String> split = new ArrayList<>();
        for(String s : splitbeheaded) {
            split.add(s);
        }
        String[] args = new String[split.size() - 1];
        split.subList(1, split.size()).toArray(args);

        return new commandContainer(raw, beheaded, splitbeheaded,invoke, args, event);
    }

    public class commandContainer {
        public final String raw;
        public final String beheaded;
        public final String[] splitBeheaded;
        public final String invoke;
        public final String[] args;
        public final MessageReceivedEvent event;

        public commandContainer(String raw, String beheaded, String[] splitbeheaded, String invoke, String[] args, MessageReceivedEvent event) {
            this.raw = raw;
            this.beheaded = beheaded;
            this.splitBeheaded = splitbeheaded;
            this.invoke = invoke;
            this.args = args;
            this.event = event;
        }
    }
}
