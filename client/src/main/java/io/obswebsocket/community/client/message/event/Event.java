package io.obswebsocket.community.client.message.event;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import io.obswebsocket.community.client.message.Message;
import io.obswebsocket.community.client.translator.serialization.EventIntentSerialization;
import io.obswebsocket.community.client.translator.serialization.EventSerialization;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@JsonAdapter(EventSerialization.class)
public abstract class Event<T> extends Message {
  @SerializedName("d")
  private Data<T> messageData;

  protected Event(Intent eventIntent) {
    this(eventIntent, null);
  }

  protected Event(Intent eventIntent, T messageData) {
    super(OperationCode.Event);
    this.messageData = Data.<T>builder().eventType(EventType.from(getClass()))
        .eventIntent(eventIntent).eventData(messageData).build();
  }

  @Getter
  @JsonAdapter(EventIntentSerialization.class)
  public enum Intent {
    /**
     * Set subscriptions to 0 to disable all events
     */
    None(0),
    /**
     * Receive events in the `General` category
     */
    General(1),
    /**
     * Receive events in the `Config` category
     */
    Config(1 << 1),
    /**
     * Receive events in the `Scenes` category
     */
    Scenes(1 << 2),
    /**
     * Receive events in the `Inputs` category
     */
    Inputs(1 << 3),
    /**
     * Receive events in the `Transitions` category
     */
    Transitions(1 << 4),
    /**
     * Receive events in the `Filters` category
     */
    Filters(1 << 5),
    /**
     * Receive events in the `Outputs` category
     */
    Outputs(1 << 6),
    /**
     * Receive events in the `Scene Items` category
     */
    SceneItems(1 << 7),
    /**
     * Receive events in the `MediaInputs` category
     */
    MediaInputs(1 << 8),
    /**
     * Receive events in the `Vendors` category
     */
    Vendors(1 << 9),
    /**
     * Receive events in the `UI` category
     */
    Ui(1 << 10),
    /**
     * Receive all event categories (default subscription setting)
     */
    All(General.value | Config.value | Scenes.value | Inputs.value | Transitions.value
        | Filters.value | Outputs.value | SceneItems.value | MediaInputs.value | Vendors.value
        | Ui.value),
    /**
     * InputVolumeMeters event (high-volume)
     */
    InputVolumeMeters(1 << 16),
    /**
     * InputActiveStateChanged event (high-volume)
     */
    InputActiveStateChanged(1 << 17),
    /**
     * InputShowStateChanged event (high-volume)
     */
    InputShowStateChanged(1 << 18),
    /**
     * SceneItemTransformChanged event (high-volume)
     */
    SceneItemTransformChanged(1 << 19),
    ;

    private final int value;

    Intent(int value) {
      this.value = value;
    }
  }

  @Getter
  @ToString
  @SuperBuilder
  public static class Data<T> {

    private EventType eventType;
    private Intent eventIntent;
    private T eventData;
  }
}
