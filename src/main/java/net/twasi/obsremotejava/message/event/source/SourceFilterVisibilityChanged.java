package net.twasi.obsremotejava.message.event.source;

import net.twasi.obsremotejava.message.event.Event;

public class SourceFilterVisibilityChanged extends Source {
    static {
        Event.registerEventType(Type.SourceFilterVisibilityChanged, SourceFilterVisibilityChanged.class);
    }

    private Data eventData;

    protected SourceFilterVisibilityChanged() {
        super(Type.SourceFilterVisibilityChanged);
    }

    @Override
    public Data getEventData() {
        return this.eventData;
    }

    public static class Data extends Source.Data {
        private String filterName;
        private boolean filterEnabled;

        public String getFilterName() {
            return this.filterName;
        }

        public boolean isFilterEnabled() {
            return this.filterEnabled;
        }
    }
}
