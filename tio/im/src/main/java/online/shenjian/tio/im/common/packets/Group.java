// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: chat.proto

package online.shenjian.tio.im.common.packets;

/**
 * <pre>
 **
 * 群组信息
 * </pre>
 *
 * Protobuf type {@code Group}
 */
public  final class Group extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:Group)
    GroupOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Group.newBuilder() to construct.
  private Group(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Group() {
    id_ = 0L;
    nickname_ = "";
    avatar_ = "";
    total_ = 0;
    online_ = 0;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Group(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 8: {

            id_ = input.readInt64();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            nickname_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            avatar_ = s;
            break;
          }
          case 32: {

            total_ = input.readInt32();
            break;
          }
          case 40: {

            online_ = input.readInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return Chat.internal_static_Group_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Chat.internal_static_Group_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Group.class, Group.Builder.class);
  }

  public static final int ID_FIELD_NUMBER = 1;
  private long id_;
  /**
   * <pre>
   * 群组ID
   * </pre>
   *
   * <code>int64 id = 1;</code>
   */
  public long getId() {
    return id_;
  }

  public static final int NICKNAME_FIELD_NUMBER = 2;
  private volatile java.lang.Object nickname_;
  /**
   * <pre>
   * 昵称
   * </pre>
   *
   * <code>string nickname = 2;</code>
   */
  public java.lang.String getNickname() {
    java.lang.Object ref = nickname_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nickname_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 昵称
   * </pre>
   *
   * <code>string nickname = 2;</code>
   */
  public com.google.protobuf.ByteString
      getNicknameBytes() {
    java.lang.Object ref = nickname_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nickname_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int AVATAR_FIELD_NUMBER = 3;
  private volatile java.lang.Object avatar_;
  /**
   * <pre>
   * 头像
   * </pre>
   *
   * <code>string avatar = 3;</code>
   */
  public java.lang.String getAvatar() {
    java.lang.Object ref = avatar_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      avatar_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * 头像
   * </pre>
   *
   * <code>string avatar = 3;</code>
   */
  public com.google.protobuf.ByteString
      getAvatarBytes() {
    java.lang.Object ref = avatar_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      avatar_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOTAL_FIELD_NUMBER = 4;
  private int total_;
  /**
   * <pre>
   * 群组总人数
   * </pre>
   *
   * <code>int32 total = 4;</code>
   */
  public int getTotal() {
    return total_;
  }

  public static final int ONLINE_FIELD_NUMBER = 5;
  private int online_;
  /**
   * <pre>
   * 群组在线人数
   * </pre>
   *
   * <code>int32 online = 5;</code>
   */
  public int getOnline() {
    return online_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (id_ != 0L) {
      output.writeInt64(1, id_);
    }
    if (!getNicknameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, nickname_);
    }
    if (!getAvatarBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, avatar_);
    }
    if (total_ != 0) {
      output.writeInt32(4, total_);
    }
    if (online_ != 0) {
      output.writeInt32(5, online_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (id_ != 0L) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt64Size(1, id_);
    }
    if (!getNicknameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, nickname_);
    }
    if (!getAvatarBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, avatar_);
    }
    if (total_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(4, total_);
    }
    if (online_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(5, online_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof Group)) {
      return super.equals(obj);
    }
    Group other = (Group) obj;

    boolean result = true;
    result = result && (getId()
        == other.getId());
    result = result && getNickname()
        .equals(other.getNickname());
    result = result && getAvatar()
        .equals(other.getAvatar());
    result = result && (getTotal()
        == other.getTotal());
    result = result && (getOnline()
        == other.getOnline());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
        getId());
    hash = (37 * hash) + NICKNAME_FIELD_NUMBER;
    hash = (53 * hash) + getNickname().hashCode();
    hash = (37 * hash) + AVATAR_FIELD_NUMBER;
    hash = (53 * hash) + getAvatar().hashCode();
    hash = (37 * hash) + TOTAL_FIELD_NUMBER;
    hash = (53 * hash) + getTotal();
    hash = (37 * hash) + ONLINE_FIELD_NUMBER;
    hash = (53 * hash) + getOnline();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Group parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Group parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Group parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Group parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Group parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Group parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Group parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Group parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Group parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Group parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Group parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Group parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(Group prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   **
   * 群组信息
   * </pre>
   *
   * Protobuf type {@code Group}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:Group)
          GroupOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Chat.internal_static_Group_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Chat.internal_static_Group_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Group.class, Group.Builder.class);
    }

    // Construct using Group.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      id_ = 0L;

      nickname_ = "";

      avatar_ = "";

      total_ = 0;

      online_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Chat.internal_static_Group_descriptor;
    }

    public Group getDefaultInstanceForType() {
      return Group.getDefaultInstance();
    }

    public Group build() {
      Group result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public Group buildPartial() {
      Group result = new Group(this);
      result.id_ = id_;
      result.nickname_ = nickname_;
      result.avatar_ = avatar_;
      result.total_ = total_;
      result.online_ = online_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof Group) {
        return mergeFrom((Group)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Group other) {
      if (other == Group.getDefaultInstance()) return this;
      if (other.getId() != 0L) {
        setId(other.getId());
      }
      if (!other.getNickname().isEmpty()) {
        nickname_ = other.nickname_;
        onChanged();
      }
      if (!other.getAvatar().isEmpty()) {
        avatar_ = other.avatar_;
        onChanged();
      }
      if (other.getTotal() != 0) {
        setTotal(other.getTotal());
      }
      if (other.getOnline() != 0) {
        setOnline(other.getOnline());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      Group parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (Group) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private long id_ ;
    /**
     * <pre>
     * 群组ID
     * </pre>
     *
     * <code>int64 id = 1;</code>
     */
    public long getId() {
      return id_;
    }
    /**
     * <pre>
     * 群组ID
     * </pre>
     *
     * <code>int64 id = 1;</code>
     */
    public Builder setId(long value) {
      
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 群组ID
     * </pre>
     *
     * <code>int64 id = 1;</code>
     */
    public Builder clearId() {
      
      id_ = 0L;
      onChanged();
      return this;
    }

    private java.lang.Object nickname_ = "";
    /**
     * <pre>
     * 昵称
     * </pre>
     *
     * <code>string nickname = 2;</code>
     */
    public java.lang.String getNickname() {
      java.lang.Object ref = nickname_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nickname_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 昵称
     * </pre>
     *
     * <code>string nickname = 2;</code>
     */
    public com.google.protobuf.ByteString
        getNicknameBytes() {
      java.lang.Object ref = nickname_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nickname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 昵称
     * </pre>
     *
     * <code>string nickname = 2;</code>
     */
    public Builder setNickname(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nickname_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 昵称
     * </pre>
     *
     * <code>string nickname = 2;</code>
     */
    public Builder clearNickname() {
      
      nickname_ = getDefaultInstance().getNickname();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 昵称
     * </pre>
     *
     * <code>string nickname = 2;</code>
     */
    public Builder setNicknameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nickname_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object avatar_ = "";
    /**
     * <pre>
     * 头像
     * </pre>
     *
     * <code>string avatar = 3;</code>
     */
    public java.lang.String getAvatar() {
      java.lang.Object ref = avatar_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        avatar_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * 头像
     * </pre>
     *
     * <code>string avatar = 3;</code>
     */
    public com.google.protobuf.ByteString
        getAvatarBytes() {
      java.lang.Object ref = avatar_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        avatar_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * 头像
     * </pre>
     *
     * <code>string avatar = 3;</code>
     */
    public Builder setAvatar(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      avatar_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 头像
     * </pre>
     *
     * <code>string avatar = 3;</code>
     */
    public Builder clearAvatar() {
      
      avatar_ = getDefaultInstance().getAvatar();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 头像
     * </pre>
     *
     * <code>string avatar = 3;</code>
     */
    public Builder setAvatarBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      avatar_ = value;
      onChanged();
      return this;
    }

    private int total_ ;
    /**
     * <pre>
     * 群组总人数
     * </pre>
     *
     * <code>int32 total = 4;</code>
     */
    public int getTotal() {
      return total_;
    }
    /**
     * <pre>
     * 群组总人数
     * </pre>
     *
     * <code>int32 total = 4;</code>
     */
    public Builder setTotal(int value) {
      
      total_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 群组总人数
     * </pre>
     *
     * <code>int32 total = 4;</code>
     */
    public Builder clearTotal() {
      
      total_ = 0;
      onChanged();
      return this;
    }

    private int online_ ;
    /**
     * <pre>
     * 群组在线人数
     * </pre>
     *
     * <code>int32 online = 5;</code>
     */
    public int getOnline() {
      return online_;
    }
    /**
     * <pre>
     * 群组在线人数
     * </pre>
     *
     * <code>int32 online = 5;</code>
     */
    public Builder setOnline(int value) {
      
      online_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * 群组在线人数
     * </pre>
     *
     * <code>int32 online = 5;</code>
     */
    public Builder clearOnline() {
      
      online_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:Group)
  }

  // @@protoc_insertion_point(class_scope:Group)
  private static final Group DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Group();
  }

  public static Group getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Group>
      PARSER = new com.google.protobuf.AbstractParser<Group>() {
    public Group parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Group(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Group> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Group> getParserForType() {
    return PARSER;
  }

  public Group getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
