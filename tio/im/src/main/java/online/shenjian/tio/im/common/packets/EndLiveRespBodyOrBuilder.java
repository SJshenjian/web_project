// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package online.shenjian.tio.im.common.packets;

public interface EndLiveRespBodyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:EndLiveRespBody)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * 消息发送时间
   * </pre>
   *
   * <code>int64 time = 1;</code>
   */
  long getTime();

  /**
   * <pre>
   * 本次直播id
   * </pre>
   *
   * <code>int64 liveId = 2;</code>
   */
  long getLiveId();
}
