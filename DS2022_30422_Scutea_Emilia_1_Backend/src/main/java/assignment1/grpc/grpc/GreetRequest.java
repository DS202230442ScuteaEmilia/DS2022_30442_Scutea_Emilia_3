// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: greet.proto

package assignment1.grpc.grpc;

/**
 * Protobuf type {@code grpc.GreetRequest}
 */
public final class GreetRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:grpc.GreetRequest)
        assignment1.grpc.grpc.GreetRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GreetRequest.newBuilder() to construct.
  private GreetRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GreetRequest() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GreetRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return assignment1.grpc.grpc.Greet.internal_static_grpc_GreetRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return assignment1.grpc.grpc.Greet.internal_static_grpc_GreetRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
                assignment1.grpc.grpc.GreetRequest.class, assignment1.grpc.grpc.GreetRequest.Builder.class);
  }

  public static final int GREETING_FIELD_NUMBER = 1;
  private assignment1.grpc.grpc.Greeting greeting_;
  /**
   * <code>.grpc.Greeting greeting = 1;</code>
   * @return Whether the greeting field is set.
   */
  @java.lang.Override
  public boolean hasGreeting() {
    return greeting_ != null;
  }
  /**
   * <code>.grpc.Greeting greeting = 1;</code>
   * @return The greeting.
   */
  @java.lang.Override
  public assignment1.grpc.grpc.Greeting getGreeting() {
    return greeting_ == null ? assignment1.grpc.grpc.Greeting.getDefaultInstance() : greeting_;
  }
  /**
   * <code>.grpc.Greeting greeting = 1;</code>
   */
  @java.lang.Override
  public assignment1.grpc.grpc.GreetingOrBuilder getGreetingOrBuilder() {
    return getGreeting();
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
    if (greeting_ != null) {
      output.writeMessage(1, getGreeting());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (greeting_ != null) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, getGreeting());
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
    if (!(obj instanceof assignment1.grpc.grpc.GreetRequest)) {
      return super.equals(obj);
    }
    assignment1.grpc.grpc.GreetRequest other = (assignment1.grpc.grpc.GreetRequest) obj;

    if (hasGreeting() != other.hasGreeting()) return false;
    if (hasGreeting()) {
      if (!getGreeting()
          .equals(other.getGreeting())) return false;
    }
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
    if (hasGreeting()) {
      hash = (37 * hash) + GREETING_FIELD_NUMBER;
      hash = (53 * hash) + getGreeting().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static assignment1.grpc.grpc.GreetRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static assignment1.grpc.grpc.GreetRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static assignment1.grpc.grpc.GreetRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static assignment1.grpc.grpc.GreetRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static assignment1.grpc.grpc.GreetRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static assignment1.grpc.grpc.GreetRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static assignment1.grpc.grpc.GreetRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static assignment1.grpc.grpc.GreetRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static assignment1.grpc.grpc.GreetRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static assignment1.grpc.grpc.GreetRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static assignment1.grpc.grpc.GreetRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static assignment1.grpc.grpc.GreetRequest parseFrom(
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
  public static Builder newBuilder(assignment1.grpc.grpc.GreetRequest prototype) {
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
   * Protobuf type {@code grpc.GreetRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:grpc.GreetRequest)
          assignment1.grpc.grpc.GreetRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return assignment1.grpc.grpc.Greet.internal_static_grpc_GreetRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return assignment1.grpc.grpc.Greet.internal_static_grpc_GreetRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
                  assignment1.grpc.grpc.GreetRequest.class, assignment1.grpc.grpc.GreetRequest.Builder.class);
    }

    // Construct using grpc.GreetRequest.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (greetingBuilder_ == null) {
        greeting_ = null;
      } else {
        greeting_ = null;
        greetingBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return assignment1.grpc.grpc.Greet.internal_static_grpc_GreetRequest_descriptor;
    }

    @java.lang.Override
    public assignment1.grpc.grpc.GreetRequest getDefaultInstanceForType() {
      return assignment1.grpc.grpc.GreetRequest.getDefaultInstance();
    }

    @java.lang.Override
    public assignment1.grpc.grpc.GreetRequest build() {
      assignment1.grpc.grpc.GreetRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public assignment1.grpc.grpc.GreetRequest buildPartial() {
      assignment1.grpc.grpc.GreetRequest result = new assignment1.grpc.grpc.GreetRequest(this);
      if (greetingBuilder_ == null) {
        result.greeting_ = greeting_;
      } else {
        result.greeting_ = greetingBuilder_.build();
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
      if (other instanceof assignment1.grpc.grpc.GreetRequest) {
        return mergeFrom((assignment1.grpc.grpc.GreetRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(assignment1.grpc.grpc.GreetRequest other) {
      if (other == assignment1.grpc.grpc.GreetRequest.getDefaultInstance()) return this;
      if (other.hasGreeting()) {
        mergeGreeting(other.getGreeting());
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
              input.readMessage(
                  getGreetingFieldBuilder().getBuilder(),
                  extensionRegistry);

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

    private assignment1.grpc.grpc.Greeting greeting_;
    private com.google.protobuf.SingleFieldBuilderV3<
            assignment1.grpc.grpc.Greeting, assignment1.grpc.grpc.Greeting.Builder, assignment1.grpc.grpc.GreetingOrBuilder> greetingBuilder_;
    /**
     * <code>.grpc.Greeting greeting = 1;</code>
     * @return Whether the greeting field is set.
     */
    public boolean hasGreeting() {
      return greetingBuilder_ != null || greeting_ != null;
    }
    /**
     * <code>.grpc.Greeting greeting = 1;</code>
     * @return The greeting.
     */
    public assignment1.grpc.grpc.Greeting getGreeting() {
      if (greetingBuilder_ == null) {
        return greeting_ == null ? assignment1.grpc.grpc.Greeting.getDefaultInstance() : greeting_;
      } else {
        return greetingBuilder_.getMessage();
      }
    }
    /**
     * <code>.grpc.Greeting greeting = 1;</code>
     */
    public Builder setGreeting(assignment1.grpc.grpc.Greeting value) {
      if (greetingBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        greeting_ = value;
        onChanged();
      } else {
        greetingBuilder_.setMessage(value);
      }

      return this;
    }
    /**
     * <code>.grpc.Greeting greeting = 1;</code>
     */
    public Builder setGreeting(
            assignment1.grpc.grpc.Greeting.Builder builderForValue) {
      if (greetingBuilder_ == null) {
        greeting_ = builderForValue.build();
        onChanged();
      } else {
        greetingBuilder_.setMessage(builderForValue.build());
      }

      return this;
    }
    /**
     * <code>.grpc.Greeting greeting = 1;</code>
     */
    public Builder mergeGreeting(assignment1.grpc.grpc.Greeting value) {
      if (greetingBuilder_ == null) {
        if (greeting_ != null) {
          greeting_ =
                  assignment1.grpc.grpc.Greeting.newBuilder(greeting_).mergeFrom(value).buildPartial();
        } else {
          greeting_ = value;
        }
        onChanged();
      } else {
        greetingBuilder_.mergeFrom(value);
      }

      return this;
    }
    /**
     * <code>.grpc.Greeting greeting = 1;</code>
     */
    public Builder clearGreeting() {
      if (greetingBuilder_ == null) {
        greeting_ = null;
        onChanged();
      } else {
        greeting_ = null;
        greetingBuilder_ = null;
      }

      return this;
    }
    /**
     * <code>.grpc.Greeting greeting = 1;</code>
     */
    public assignment1.grpc.grpc.Greeting.Builder getGreetingBuilder() {
      
      onChanged();
      return getGreetingFieldBuilder().getBuilder();
    }
    /**
     * <code>.grpc.Greeting greeting = 1;</code>
     */
    public assignment1.grpc.grpc.GreetingOrBuilder getGreetingOrBuilder() {
      if (greetingBuilder_ != null) {
        return greetingBuilder_.getMessageOrBuilder();
      } else {
        return greeting_ == null ?
                assignment1.grpc.grpc.Greeting.getDefaultInstance() : greeting_;
      }
    }
    /**
     * <code>.grpc.Greeting greeting = 1;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            assignment1.grpc.grpc.Greeting, assignment1.grpc.grpc.Greeting.Builder, assignment1.grpc.grpc.GreetingOrBuilder>
        getGreetingFieldBuilder() {
      if (greetingBuilder_ == null) {
        greetingBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
                assignment1.grpc.grpc.Greeting, assignment1.grpc.grpc.Greeting.Builder, assignment1.grpc.grpc.GreetingOrBuilder>(
                getGreeting(),
                getParentForChildren(),
                isClean());
        greeting_ = null;
      }
      return greetingBuilder_;
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


    // @@protoc_insertion_point(builder_scope:grpc.GreetRequest)
  }

  // @@protoc_insertion_point(class_scope:grpc.GreetRequest)
  private static final assignment1.grpc.grpc.GreetRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new assignment1.grpc.grpc.GreetRequest();
  }

  public static assignment1.grpc.grpc.GreetRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GreetRequest>
      PARSER = new com.google.protobuf.AbstractParser<GreetRequest>() {
    @java.lang.Override
    public GreetRequest parsePartialFrom(
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

  public static com.google.protobuf.Parser<GreetRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GreetRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public assignment1.grpc.grpc.GreetRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

