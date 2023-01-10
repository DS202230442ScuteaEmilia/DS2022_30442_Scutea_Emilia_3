// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: greet.proto

package assignment1.grpc.grpc;

/**
 * Protobuf type {@code grpc.Messages}
 */
public final class Messages extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.Messages)
        assignment1.grpc.grpc.MessagesOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Messages.newBuilder() to construct.
  private Messages(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Messages() {
    messages_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new Messages();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return assignment1.grpc.grpc.Greet.internal_static_grpc_Messages_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return assignment1.grpc.grpc.Greet.internal_static_grpc_Messages_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
                assignment1.grpc.grpc.Messages.class, assignment1.grpc.grpc.Messages.Builder.class);
  }

  public static final int MESSAGES_FIELD_NUMBER = 1;
  private java.util.List<assignment1.grpc.grpc.Greeting> messages_;
  /**
   * <code>repeated .grpc.Greeting messages = 1;</code>
   */
  @java.lang.Override
  public java.util.List<assignment1.grpc.grpc.Greeting> getMessagesList() {
    return messages_;
  }
  /**
   * <code>repeated .grpc.Greeting messages = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends assignment1.grpc.grpc.GreetingOrBuilder>
      getMessagesOrBuilderList() {
    return messages_;
  }
  /**
   * <code>repeated .grpc.Greeting messages = 1;</code>
   */
  @java.lang.Override
  public int getMessagesCount() {
    return messages_.size();
  }
  /**
   * <code>repeated .grpc.Greeting messages = 1;</code>
   */
  @java.lang.Override
  public assignment1.grpc.grpc.Greeting getMessages(int index) {
    return messages_.get(index);
  }
  /**
   * <code>repeated .grpc.Greeting messages = 1;</code>
   */
  @java.lang.Override
  public assignment1.grpc.grpc.GreetingOrBuilder getMessagesOrBuilder(
      int index) {
    return messages_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < messages_.size(); i++) {
      output.writeMessage(1, messages_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < messages_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, messages_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof assignment1.grpc.grpc.Messages)) {
      return super.equals(obj);
    }
    assignment1.grpc.grpc.Messages other = (assignment1.grpc.grpc.Messages) obj;

    if (!getMessagesList()
        .equals(other.getMessagesList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getMessagesCount() > 0) {
      hash = (37 * hash) + MESSAGES_FIELD_NUMBER;
      hash = (53 * hash) + getMessagesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static assignment1.grpc.grpc.Messages parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static assignment1.grpc.grpc.Messages parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static assignment1.grpc.grpc.Messages parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static assignment1.grpc.grpc.Messages parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static assignment1.grpc.grpc.Messages parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static assignment1.grpc.grpc.Messages parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static assignment1.grpc.grpc.Messages parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static assignment1.grpc.grpc.Messages parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static assignment1.grpc.grpc.Messages parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static assignment1.grpc.grpc.Messages parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static assignment1.grpc.grpc.Messages parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static assignment1.grpc.grpc.Messages parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(assignment1.grpc.grpc.Messages prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
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
   * Protobuf type {@code grpc.Messages}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.Messages)
          assignment1.grpc.grpc.MessagesOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return assignment1.grpc.grpc.Greet.internal_static_grpc_Messages_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return assignment1.grpc.grpc.Greet.internal_static_grpc_Messages_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
                  assignment1.grpc.grpc.Messages.class, assignment1.grpc.grpc.Messages.Builder.class);
    }

    // Construct using grpc.Messages.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (messagesBuilder_ == null) {
        messages_ = java.util.Collections.emptyList();
      } else {
        messages_ = null;
        messagesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return assignment1.grpc.grpc.Greet.internal_static_grpc_Messages_descriptor;
    }

    @java.lang.Override
    public assignment1.grpc.grpc.Messages getDefaultInstanceForType() {
      return assignment1.grpc.grpc.Messages.getDefaultInstance();
    }

    @java.lang.Override
    public assignment1.grpc.grpc.Messages build() {
      assignment1.grpc.grpc.Messages result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public assignment1.grpc.grpc.Messages buildPartial() {
      assignment1.grpc.grpc.Messages result = new assignment1.grpc.grpc.Messages(this);
      int from_bitField0_ = bitField0_;
      if (messagesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          messages_ = java.util.Collections.unmodifiableList(messages_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.messages_ = messages_;
      } else {
        result.messages_ = messagesBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof assignment1.grpc.grpc.Messages) {
        return mergeFrom((assignment1.grpc.grpc.Messages)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(assignment1.grpc.grpc.Messages other) {
      if (other == assignment1.grpc.grpc.Messages.getDefaultInstance()) return this;
      if (messagesBuilder_ == null) {
        if (!other.messages_.isEmpty()) {
          if (messages_.isEmpty()) {
            messages_ = other.messages_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureMessagesIsMutable();
            messages_.addAll(other.messages_);
          }
          onChanged();
        }
      } else {
        if (!other.messages_.isEmpty()) {
          if (messagesBuilder_.isEmpty()) {
            messagesBuilder_.dispose();
            messagesBuilder_ = null;
            messages_ = other.messages_;
            bitField0_ = (bitField0_ & ~0x00000001);
            messagesBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getMessagesFieldBuilder() : null;
          } else {
            messagesBuilder_.addAllMessages(other.messages_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              assignment1.grpc.grpc.Greeting m =
                  input.readMessage(
                          assignment1.grpc.grpc.Greeting.parser(),
                      extensionRegistry);
              if (messagesBuilder_ == null) {
                ensureMessagesIsMutable();
                messages_.add(m);
              } else {
                messagesBuilder_.addMessage(m);
              }
              break;
            } // case 10
            default: {
//              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
//              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<assignment1.grpc.grpc.Greeting> messages_ =
      java.util.Collections.emptyList();
    private void ensureMessagesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        messages_ = new java.util.ArrayList<assignment1.grpc.grpc.Greeting>(messages_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            assignment1.grpc.grpc.Greeting, assignment1.grpc.grpc.Greeting.Builder, assignment1.grpc.grpc.GreetingOrBuilder> messagesBuilder_;

    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public java.util.List<assignment1.grpc.grpc.Greeting> getMessagesList() {
      if (messagesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(messages_);
      } else {
        return messagesBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public int getMessagesCount() {
      if (messagesBuilder_ == null) {
        return messages_.size();
      } else {
        return messagesBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public assignment1.grpc.grpc.Greeting getMessages(int index) {
      if (messagesBuilder_ == null) {
        return messages_.get(index);
      } else {
        return messagesBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public Builder setMessages(
        int index, assignment1.grpc.grpc.Greeting value) {
      if (messagesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessagesIsMutable();
        messages_.set(index, value);
        onChanged();
      } else {
        messagesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public Builder setMessages(
        int index, assignment1.grpc.grpc.Greeting.Builder builderForValue) {
      if (messagesBuilder_ == null) {
        ensureMessagesIsMutable();
        messages_.set(index, builderForValue.build());
        onChanged();
      } else {
        messagesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public Builder addMessages(assignment1.grpc.grpc.Greeting value) {
      if (messagesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessagesIsMutable();
        messages_.add(value);
        onChanged();
      } else {
        messagesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public Builder addMessages(
        int index, assignment1.grpc.grpc.Greeting value) {
      if (messagesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureMessagesIsMutable();
        messages_.add(index, value);
        onChanged();
      } else {
        messagesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public Builder addMessages(
            assignment1.grpc.grpc.Greeting.Builder builderForValue) {
      if (messagesBuilder_ == null) {
        ensureMessagesIsMutable();
        messages_.add(builderForValue.build());
        onChanged();
      } else {
        messagesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public Builder addMessages(
        int index, assignment1.grpc.grpc.Greeting.Builder builderForValue) {
      if (messagesBuilder_ == null) {
        ensureMessagesIsMutable();
        messages_.add(index, builderForValue.build());
        onChanged();
      } else {
        messagesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public Builder addAllMessages(
        java.lang.Iterable<? extends assignment1.grpc.grpc.Greeting> values) {
      if (messagesBuilder_ == null) {
        ensureMessagesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, messages_);
        onChanged();
      } else {
        messagesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public Builder clearMessages() {
      if (messagesBuilder_ == null) {
        messages_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        messagesBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public Builder removeMessages(int index) {
      if (messagesBuilder_ == null) {
        ensureMessagesIsMutable();
        messages_.remove(index);
        onChanged();
      } else {
        messagesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public assignment1.grpc.grpc.Greeting.Builder getMessagesBuilder(
        int index) {
      return getMessagesFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public assignment1.grpc.grpc.GreetingOrBuilder getMessagesOrBuilder(
        int index) {
      if (messagesBuilder_ == null) {
        return messages_.get(index);  } else {
        return messagesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public java.util.List<? extends assignment1.grpc.grpc.GreetingOrBuilder>
         getMessagesOrBuilderList() {
      if (messagesBuilder_ != null) {
        return messagesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(messages_);
      }
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public assignment1.grpc.grpc.Greeting.Builder addMessagesBuilder() {
      return getMessagesFieldBuilder().addBuilder(
              assignment1.grpc.grpc.Greeting.getDefaultInstance());
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public assignment1.grpc.grpc.Greeting.Builder addMessagesBuilder(
        int index) {
      return getMessagesFieldBuilder().addBuilder(
          index, assignment1.grpc.grpc.Greeting.getDefaultInstance());
    }
    /**
     * <code>repeated .grpc.Greeting messages = 1;</code>
     */
    public java.util.List<assignment1.grpc.grpc.Greeting.Builder>
         getMessagesBuilderList() {
      return getMessagesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
            assignment1.grpc.grpc.Greeting, assignment1.grpc.grpc.Greeting.Builder, assignment1.grpc.grpc.GreetingOrBuilder>
        getMessagesFieldBuilder() {
      if (messagesBuilder_ == null) {
        messagesBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
                assignment1.grpc.grpc.Greeting, assignment1.grpc.grpc.Greeting.Builder, assignment1.grpc.grpc.GreetingOrBuilder>(
                messages_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        messages_ = null;
      }
      return messagesBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:grpc.Messages)
  }

  // @@protoc_insertion_point(class_scope:grpc.Messages)
  private static final assignment1.grpc.grpc.Messages DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new assignment1.grpc.grpc.Messages();
  }

  public static assignment1.grpc.grpc.Messages getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Messages>
      PARSER = new com.google.protobuf.AbstractParser<Messages>() {
    @java.lang.Override
    public Messages parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<Messages> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Messages> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public assignment1.grpc.grpc.Messages getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
